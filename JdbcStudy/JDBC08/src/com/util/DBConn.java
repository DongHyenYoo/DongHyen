package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn
{
	private static Connection dbconn;
	
	
	public static Connection getConnection()
	{
		if(dbconn == null)
		{
			String url = "jdbc:oracle:thin:@211.238.142.61:1521:xe";
			String user = "scott";
			String pwd = "tiger";
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbconn = DriverManager.getConnection(url, user, pwd);
				
				
				
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
				// TODO: handle exception
			}
			
		}
		
		return dbconn;
		
	}
	
	public static Connection getConnection(String url, String pwd, String user)
	{
		if(dbconn == null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbconn = DriverManager.getConnection(url, user, pwd);
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
				// TODO: handle exception
			}
			
		}
		
		return dbconn;
		
	}
	
	public static void close()
	{
		if(dbconn!=null)
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
		
	}

}
