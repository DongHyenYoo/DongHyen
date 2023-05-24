
//예외 처리 방법 변경
// try ~ catch -> throws

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn
{
	//연결용 변수 선언 Connection 타입
	private static Connection dbconn;
	
	//getConnection > main에서 사용할 Connection 객체 생성을 위해 Connection 반환 메소드 선언
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		//1.연결 안되어있다면
		if (dbconn == null)
		{   
			//오라클 사용자 이름, 비밀번호
			//연결할 서버
			//변수로써 선언
			String user = "scott";
			String pw = "tiger";
			
			//url = jdbc:oracle:tier4:@211.238.142.61:오라클포트번호:오라클버전
			String url = "jdbc:oracle:thin:@211.238.142.61:1521:xe";
			
			//오라클 드라이버가 존재하는지 확인
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//존재하면 해당드라이버로 오라클과 연결
			//(dbconn에 Connection 객체 주입
			// DriverManager.getConnection의 반환자료형은 Connection
			
			dbconn = DriverManager.getConnection(url, user, pw);
		
		}
		return dbconn;
			
	}//end getConnection
	
	
	
	public static Connection getConnection(String url, String user, String pw) throws ClassNotFoundException,SQLException
	{
		//url, user, pw 전부 줬으므로
		//연결객체가 null(연결이 있는지)이 맞다면 dbconn 에 연결 객체를 담는다.
		
		if(dbconn == null)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbconn = DriverManager.getConnection(url, user, pw);
		}
		
		return dbconn;
		
	}
	
	
	public static void close() throws SQLException
	{
		//연결객체가 null이 아니라면
		if (dbconn != null)
		{
			if (!dbconn.isClosed())
			{
				dbconn.close();
			}
			
		}
		dbconn = null;
	}
	
	
	// void close() sql 활용이 끝나면 연결을 끊을 메소드
  
}
