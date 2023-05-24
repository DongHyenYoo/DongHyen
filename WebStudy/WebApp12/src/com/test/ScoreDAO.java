package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	
	private Connection conn;
	
	public void open() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
	}
	
	
	public int add(ScoreDTO dto) throws SQLException
	{
		int result=0;
		
		
		//sql
		String sql = "INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, ?, ?,?,?)";
		
		
		//작업객체
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//? 변수 채워넣기
		pstmt.setString(1, dto.getName());
		pstmt.setInt(2, dto.getKor());
		pstmt.setInt(3, dto.getEng());
		pstmt.setInt(4, dto.getMat());
		
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
		
	}
	
	public ScoreDTO[] list() throws SQLException
	{
		
		ScoreDTO[] scoreArr = new ScoreDTO[count()];
		int n=0;
		String sql = "SELECT SID,NAME,KOR,ENG,MAT ,"
					+" (KOR+ENG+MAT) AS TOT, ROUND((KOR+ENG+MAT)/3,1) AS AVG FROM TBL_SCORE ORDER BY 1";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
			dto.setTot(rs.getInt("TOT"));
			dto.setAvg(rs.getDouble("AVG"));
			
			scoreArr[n] = dto;
			n++;
		}
		
		rs.close();
		pstmt.close();
		
		return scoreArr;
	}
	
	public int count() throws SQLException
	{
		int result = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs =  pstmt.executeQuery();
		
		if(rs.next())
		{
			result = rs.getInt("COUNT");
		}
		
		rs.close();
		pstmt.close();
		
		return result;
		
		
	}
	
	public void close() throws SQLException
	{
		DBConn.close();
		
	}
	
	

}
