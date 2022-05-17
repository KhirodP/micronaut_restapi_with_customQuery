package com.khirod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constants {
	
	public static Connection getConnectoins() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-O79920D\\MSSQLSERVER1:1434;encrypt=true;trustServerCertificate=true","Anemoi","Anemoi@123");
		if(conn!=null)
		{
			return conn;
		}
		return null;
	}

}
