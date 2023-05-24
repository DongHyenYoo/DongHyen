/*
 * DBCPConn
 * 
 */

package com.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBCPConn
{
	private static Connection conn = null;

	public static Connection getConnection()
	{

		if (conn == null)
		{
			try
			{
				// ○이름과 객체를 바인딩
				// 컨텍스트(Context)를 얻어내는 가장 쉬운 방법은
				// 『javax.naming.IntialContext』 클래스의
				// 인스턴스(객체)를 생성하는 것이다.
				// 『new InitialContext();』
				// 서블릿 컨테이너가 관리할 모든 컨텐츠

				Context ctx = new InitialContext();

				// ※javax.naming.InitialContext 메소드
				// -bind(String str, Objcet obj)
				// : 서비스할 객체를 특정 이름으로 등록한다.
				// -rebind(String str, Object obj)
				// : 서비스할 객체를 특정 이름으로 다시 등록한다.
				// -list(String str)
				// : 특정 이름으로 서비스하는 객체 정보를 반환한다.
				// - unbind(String str)
				// : 등록된 객체를 메모리에서 해제한다.
				// - Object lookup(String str)
				// : 서비스중인 객체정보를 얻어온다.

				// web.xml -> context.xml 부터 환경 설정을 찾아오겠다는 코드 구성
				// 환경설정을 얻어오라고 서블릿 컨테이너는 이해한다.
				// -- 다른 형태로 변경 불가
				Context evt = (Context) ctx.lookup("java:/comp/env");

				
				//환경설정 내용으로부터 얻어온 객체들중
				//context.xml에서 리소스중에 "jdbc/myOracle"이런 이름을 붙인 리소스를 가져올수 있도록
				//코드를 구성
				//즉 서블릿 컨테이너가 해당 리소스타입의 객체를 생성한다.
				DataSource ds = (DataSource) evt.lookup("jdbc/myOracle");
				
				
				conn = ds.getConnection();

			} catch (Exception e)
			{
				System.out.println(e.toString());
				// TODO: handle exception
			}
		}
		return conn;
	}
	

	public static void close()
	{

		if (conn != null)
		{
			try
			{
				if (!conn.isClosed())
				{
					conn.close();
				}
			} catch (Exception e)
			{
				// TODO: handle exception
			}
		}

		conn = null;
	}

}
