/*=================
DBConn.java 
 
===================*/

// ※ 싱글통(singleton)디자인 패턴을 이용한 Database 연결 객체 생성 전용 클래스
//	   ->DB 연결 과정이 가장 부하가 크기 때문에
//		연결이 필요할 때마다 객체를 생성하는 것이 아니라
//		한번 연결된 객체를 계속 사용할 수 있도록 처리.

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn
{
	//변수 선언
	private static Connection dbConn;
	// -- private -> 정보 은닉
	// -- static -> 정적 변수
	//   전역변수로써 자동으로 초기화 지원-> null (객체타입이라서)
	
	//메소드 정의
	public static Connection getConnection() //반환자료형 : Connection 객체타입
	{
		//한 번 연결된 객체를 계속 사용...
		//즉, 연결되지 않은 경우에만 연결을 시도하겠다는 의미
		// -> singleton(디자인 패턴)
		
		if (dbConn == null)
		{
			try
			{
				String url = "jdbc:oracle:thin:@211.238.142.61:1521:xe";
				//아이피는 오라클 서버 IP 주소를 기재하는 부분
				// 1521 은 오라클 port number
				// xe는 오라클 sid(express edition 은 xe)
				
				String user ="scott"; //오라클 사용자 계정 이름
				String pwd = "tiger"; // 오라클 사용자 계정 암호
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); //Class라는 클래스는 CheckedException을 throws함 
																	//즉 try-catch 로 잡거나 throw해야하는데  
													                //밑의 줄도 SQLException을 throw한다.
				//--OracleDriver 클래스에 대한 객체 생성
				// 드라이버로딩 -> JVM에 전달한다.
				
				dbConn = DriverManager.getConnection(url, user, pwd);
				// -- 오라클 서버 실제 연결
				// 위 (line 35 ~ 45)까지는 연결을 위한 환경을 설정하는 과정 
				// 갖고있는 매개변수는 오라클 주소, 계정명, 패스워드
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
				// TODO: handle exception
			}
			
		
			
		}
		
		return dbConn;
	}

	//getConnection() 메소드 오버로딩
	public static Connection getConnection(String url, String user, String pwd)
	{
		if (dbConn == null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, pwd);
				
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
				// 오라클 서버 연결실패시 오류 메세지띄움
				// TODO: handle exception
			}
		}
		
		return dbConn;
		//구성된 연결 객체 반환
	}
	
	//연결 종료 메소드
	public static void close()
	{
		//dbConn 변수(멤버 변수)는
		//Database 가 연결된 상태일 경우 Connection 을 갖는다.
		// 연결되지 않은 상태라면 null 인 상황이 된ㄷ.
		
		if (dbConn != null)
		{
			try
			{
				//연결 객체의 isClosed()메소드를 통해 연결 확인
				// 연결이 닫혀있다면 true
				// 연결이 닫혀있지 않은 경우 false반환
				
				if (!dbConn.isClosed())
				{
					dbConn.close();
					//--연결 객체의 close() 메소드 호출을 통해 연결 종료;
				}
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
				// TODO: handle exception
			}
		}
		
		//연결 객체 초기화 
		dbConn = null;
	}
	
	
}

