package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO
{
	
	//주요 속성 구성
	private Connection conn;
	
	//데이터베이스 연결
	public void connect()
	{
		try
		{
			conn = DBConn.getConnection();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
	}

	//데이터베이스 연결 해제
	public void disConnection()
	{
		try
		{
			DBConn.close();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	//멤버 리스트 조회
	public ArrayList<MemberDTO> list() throws SQLException
	{
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		String sql="SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("ID"));
			dto.setName(rs.getString("NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setEmail(rs.getString("EMAIL"));
			result.add(dto);
		}
		
		rs.close();
		pstmt.close();
		return result;
		
		
	}
	
	//멤버 리스트 등록
	public int insertQuery(MemberDTO dto) throws SQLException
	{
		int result=0;
		
		String sql="INSERT INTO TBL_MEMBERLIST(ID, PW, NAME, TEL, EMAIL)"
				+ " VALUES(?, CRYPTPACK.ENCRYPT(?, ?), ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try
		{
			
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, dto.getTel());
			pstmt.setString(6, dto.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		System.out.println(result);
		
		pstmt.close();
		return result;
		
	}
	
}
