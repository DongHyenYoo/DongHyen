package com.test.spr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MssqlDAO implements IDAO
{

	@Override
	public ArrayList<MemberDTO> list() throws ClassNotFoundException, SQLException
	{
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@211.238.142.62:1521:xe"
				, "scott", "tiger");
		
		String sql = "SELECT ID, NAME, TEL, EMAIL FROM TBL_MEMBERLIST";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next())
	      {
	         MemberDTO dto = new MemberDTO();
	         
	         dto.setId(rs.getString("ID"));
	         dto.setName(rs.getString("NAME"));
	         dto.setTel(rs.getString("TEL"));
	         dto.setEmail(rs.getString("EMAIL"));
	      
	         // 결과 집합을 컬렉션(result)에 추가   
	         result.add(dto);
	      }
	      
	      // 리소스 반납
	      rs.close();
	      pstmt.close();
		
	      if(!conn.isClosed())
	      {
	    	  conn.close();
	      }
	      
		return result;
	}
	
	

}
