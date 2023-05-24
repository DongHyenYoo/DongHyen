package com.test;

import java.sql.Connection;

import com.util.DBConn;

public class DBConnTest
{
	public static void main(String[] args)
	{
		Connection conn = DBConn.getConnection();
		
		if(conn != null)
		{
			System.out.println("데이터 베이스 연결 성공");
			
		}
		else {
			System.out.println("연결실패");
			
		}
		
		DBConn.close();
			
	}

}
