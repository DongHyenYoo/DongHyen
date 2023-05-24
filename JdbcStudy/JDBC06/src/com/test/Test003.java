package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;

public class Test003
{
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBConn.getConnection();
			
			if(conn != null)
			{
				System.out.println("DB연결 성공");
			}
			
			try
			{
				//1.쿼리문 준비
				String sql ="SELECT SID, NAME, TEL"
						+ " FROM TBL_MEMBER"
						+ " ORDER BY SID";
				
				//PreparedStatement 작업 객체 생성(쿼리문 전달)
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				//작업 객체 실행 -> 쿼리문 전달 x -> resultset을 반환할것
				ResultSet rs = pstmt.executeQuery();
				
				//ResultSet 처리 -> 반복문 구성 (단일 레코드일 경우 조건문 가능)
				while (rs.next())
				{
					int sid = rs.getInt("SID");
					String name = rs.getString("NAME");
					String tel = rs.getString("TEL");
					
					String str = String.format("%3d %7s %12s", sid, name, tel);
					
					System.out.println(str);
				}
				
				rs.close();
				pstmt.close();
				
				
				
			} catch (Exception e2)
			{
				System.out.println(e2.toString());
				// TODO: handle exception
			}
			
			DBConn.close();
			System.out.println(">> 데이터베이스 연결 닫힘~!!!");
			System.out.println(">> 프로그램 종료됨~!!!");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			// TODO: handle exception
		}
	}

}
