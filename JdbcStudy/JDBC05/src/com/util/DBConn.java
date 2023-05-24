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
		try
		{
			if(dbconn == null)
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				dbconn = DriverManager.getConnection(url, user, pwd);
			}
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return dbconn;
		
	}
	
	
	public static void close()
	{
		if (dbconn != null)
		{
			try
			{
				if(!dbconn.isClosed())
				{
					dbconn.close();
				}
				
			} catch (Exception e)
			{
				// TODO: handle exception
			}
			dbconn = null;
		}
		
		
	}

}
