/*==============================
 
  DBConn 예외처리 throws
 
 */


package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn
{
	private static Connection dbconn;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		
		if(dbconn == null)
		{
			//url
			String url = "jdbc:oracle:thin:@211.238.142.61:1521:xe";
			//ip
			String user = "scott";
			//pw
			String pwd = "tiger";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			dbconn = DriverManager.getConnection(url, user, pwd);
			
			
			
		}
		
		return dbconn;
		
		
	}
	
	public static Connection getConnection(String url, String user, String pwd) throws ClassNotFoundException, SQLException
	{
		
		if(dbconn == null)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			dbconn = DriverManager.getConnection(url, user, pwd);
		}
		
		return dbconn;
		
		
	}
	
	
	public static void close() throws SQLException
	{
		
		if(dbconn != null)
		{
			if(!dbconn.isClosed())
			{
				dbconn.close();
			}
		}
		
		dbconn = null;
			
		
	}
	
	
	
	

}
