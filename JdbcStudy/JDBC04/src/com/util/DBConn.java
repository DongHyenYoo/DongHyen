package com.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConn
{
	private static Connection dbconn;
	// 1.getConnection 2개
	// 3.close()

	public static Connection getConnection()
	{
		// 연결되어있는지 확인
		if (dbconn == null)
		{
			try
			{

				String user = "scott";
				String pwd = "tiger";

				String url = "jdbc:oracle:thin:@211.238.142.61:1521:xe";

				Class.forName("oracle.jdbc.driver.OracleDriver");

				dbconn = DriverManager.getConnection(url, user, pwd);

			} catch (Exception e)
			{
				// TODO: handle exception
			}

		}
		return dbconn;
	}

	public static Connection getConnection(String url, String user, String pwd)

	{
		if (dbconn == null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");

				dbconn = DriverManager.getConnection(url, user, pwd);

			} catch (Exception e)
			{
				// TODO: handle exception
			}

		}
		return dbconn;
	}

	public static void close()
	{

		// 연결객체가 null이 아니라면
		if (dbconn != null)
		{
			try
			{
				if (!dbconn.isClosed())
				{
					dbconn.close();
				}

			} catch (Exception e)
			{
				// TODO: handle exception
			}
			
			

		}
		dbconn = null;
		// 연결이 아직 되어있다면
	}

}
