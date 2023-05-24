
/*=============================
 MemberDAO.java
 -데이터 액션 처리 클래스
 - IMemberDAO 인터페이스를 implements 하는 클래스
  → IMemberDAO 인터페이스에 선언된 메소드 재정의.
 - Connection 객체에 대한 의존성 주입을 위한 준비
  →setter injection
   ① 인터페이스 형태의 데이터타입을 취하는 멤버 구성(변수 선언)
   ② setter 구성 (setter 메소드 정의)
  
 88888888888888888888888888888888*/

package com.test.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;


public class MemberDAO implements IMemberDAO
{
	
	
	
	//※ Connection 객체에 대한 의존성 주입을 위한 준비
	
	//① 인터페이스 형태의 데이터타입
	private DataSource datasource;

	public void setDatasource(DataSource datasource)
	{
		this.datasource = datasource;
	}

	@Override
	public ArrayList<MemberDTO> list() throws SQLException
	{
		
		// 커넥션 객체
		Connection dbconn =  datasource.getConnection();
		
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		String sql = "SELECT MID, NAME, TELEPHONE FROM TBL_MEMBERLIST ORDER BY MID";
		
		PreparedStatement pstmt = dbconn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setMid(rs.getInt("MID"));
			dto.setName(rs.getString("NAME"));
			dto.setTelephone(rs.getString("TELEPHONE"));
			result.add(dto);
			
		}
		
		rs.close();
		pstmt.close();
		dbconn.close();
		
		return result;
	}

	@Override
	public int add(MemberDTO member) throws SQLException
	{
		Connection dbconn =  datasource.getConnection();
		
		int result = 0;
		
		String sql="INSERT INTO TBL_MEMBERLIST(MID, NAME, TELEPHONE) VALUES(MEMBERLISTSEQ.NEXTVAL, ? , ?)";

		PreparedStatement pstmt = dbconn.prepareStatement(sql);
		
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getTelephone());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		dbconn.close();
		
		return result;
	}

	@Override
	public int count() throws SQLException
	{
		int result =0;
		Connection dbconn =  datasource.getConnection();
		//sql 작성
		String sql="SELECT COUNT(*) AS COUNT FROM TBL_MEMBERLIST";
		
		//작업객체 생성
		Statement stmt = dbconn.createStatement();
		
		ResultSet rs =  stmt.executeQuery(sql);
		
		if(rs.next())
		{
			result = rs.getInt("COUNT");
		}
		
		rs.close();
		stmt.close();
		dbconn.close();
		return result;
	}
	
	

}
