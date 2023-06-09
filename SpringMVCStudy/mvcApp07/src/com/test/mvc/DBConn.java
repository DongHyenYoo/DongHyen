package com.test.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn
{
	
	private static Connection dbconn;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		
		if(dbconn==null)
		{
			
			String url ="jdbc:oracle:thin:@211.238.142.47:1521:xe";
			String user="scott";
			String pwd="tiger";
			
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
