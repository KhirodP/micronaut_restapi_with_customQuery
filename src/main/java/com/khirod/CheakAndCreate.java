package com.khirod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheakAndCreate {
	public static final String CREATE_DATABASE= "create database ";
	
	public static final String  CREATESTUDENTTABLE ="CREATE TABLE dbo.student_info(student_id int,name varchar(200),parent_name varchar(200),city varchar(200),mobile_no bigint,primary key(student_id))";
	public static String USE = "use";
	public static final String CHEAK_STUDENT_TABLE= "select * from INFORMATION_SCHEMA.tables where TABLE_NAME = ? ;";
	
	public static boolean isDBExists(String DBname) throws SQLException, ClassNotFoundException 
	{
		Connection con = Constants.getConnectoins();
		Statement stmt = con.createStatement();

		if (con != null) 
		{
			System.out.println("now we are cheacking database");
			ResultSet rs = con.getMetaData().getCatalogs();
			
			while (rs.next()) 
			{	
				String Catalogs = rs.getString(1);
				
				if (DBname.equals(Catalogs)) 
				{
					System.out.println(DBname + "database found");
					return true;
				}
			}
		}
		return false;

	}

	public static void createDB(String DBname) throws Exception 
	{
		
		Connection con = Constants.getConnectoins();
		System.out.println(con+" connection....!");
		Statement stmt = con.createStatement();
		boolean isDbExiests = CheakAndCreate.isDBExists(DBname);
			if(isDbExiests==false) 
			{
				System.out.println("now creating a new database.");
				
				stmt.executeUpdate(CREATE_DATABASE+DBname);
				
				System.out.println("database is created");
				
				System.out.println("table is creating");
				
				createstudenttable(con,stmt,DBname);
				
				System.out.println("table and database both are created");
				
			}
			else
			{
				System.out.println("creating table while database is exiests");
				createstudenttable(con,stmt,DBname);
			}
	}
	private static void createstudenttable(Connection con,Statement stmt,String DBname) throws Exception 
	{	
		stmt.executeUpdate("use "+DBname);
		String tablename = "student_info";
		boolean isDTableExiests = CheakAndCreate.isTableExists(con,tablename);
		if(isDTableExiests==false)
		{
			stmt.executeUpdate(CREATESTUDENTTABLE);
			
			System.out.println("table is not avalable created a new table ");
		}
		else
		{
			System.out.println("table is already exist...!!");
		}
	}

	private static boolean isTableExists(Connection con,String tablename) throws Exception 
	{

		System.out.println("cheaking weather table is exiests or not in database");
		ResultSet rs= con.getMetaData().getTables(null, null, tablename, new String[] {"table"});
		
		while(rs.next())
		{
			String tname = rs.getString(3);
			
			if(tablename.equals(tname)) 
			{
				System.out.println(tablename+" table is alrady there in database");
				return true;
			}
		}
		return false;
		
	}
	
}
