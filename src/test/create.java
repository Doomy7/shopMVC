package test;
import java.sql.*;

public class create {

	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";
	
	static final String USER = "username";
	static final String PASS = "password";
	
	public static void main (String[] args){
	
		//CREATE DATABASE
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connection to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			System.out.println("Creating database...");
			stmt = conn.createStatement();
			
			sql = "DROP DATABASE SHOPMVC";
			stmt.executeUpdate(sql);
			
			//sql = "CREATE DATABASE SHOPMVC";
			//stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt != null){
					stmt.close();
				}
			}catch(SQLException se2){
			
			}
			try{
				if(conn != null){
					conn.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}	
	
}


   

 