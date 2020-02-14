package test;
import java.sql.*;

public class createTables {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/SHOPMVC";
	static final String USER = "username";
	static final String PASS = "password";
	
	
	public static void main(String [] args){
		
		String sql = "";
		Connection conn = null;
		Statement stmt = null;
		
		try{
			//CONNECT TO DATABASE
			Class.forName(JDBC_DRIVER);
			
			System.out.println("Connecting to a selected database");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected to database successfully");
			
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();
			
			sql = "DROP TABLE CATEGORIES";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE TV";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE BLUERAYDVD";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE CAMERA";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE CONSOLES";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE FRIDGES";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE WASHINGMASHINES";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE PICTURES";
			stmt.executeUpdate(sql);
			sql = "DROP TABLE SALES";
			stmt.executeUpdate(sql);
			
			//CREATE TABLE CATEGORIES
			sql = "CREATE TABLE CATEGORIES " +
						 "(id INTEGER not NULL, " +
						 "Category VARCHAR(20)," +
						 "PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);	
			System.out.println("Created table CATEGORIES successfully");
			
			
			//CREATE TABLE TV
			//====================================================
			sql = "CREATE TABLE TV " +
					  "(code INTEGER not NULL, " +
					  "manufacturer VARCHAR(30), " +
					  "modelname VARCHAR(30), " +
					  "type VARCHAR(5), " +
					  "modelyear INTEGER(4), " +
					  "inches INTEGER(3), " +
					  "resolution VARCHAR(9), " +
					  "hdmi INTEGER(1), " +
					  "dvi INTEGER(1), " +
					  "composite INTEGER(1), " +
					  "price INTEGER(8), " +
					  "Availability FLOAT(3), " +
					  "PRIMARY KEY( code ))";
			stmt.executeUpdate(sql);		
			System.out.println("Created table TV successfully");
			//====================================================
			
			
			//CREATE TABLE BLUERAYDVD
			//====================================================
			sql = "CREATE TABLE BLUERAYDVD " +
				  "(code INTEGER not NULL, " +
				  "manufacturer VARCHAR(30) not NULL, " +
				  "modelname VARCHAR(30) not NULL, " +
				  "modelyear INTEGER(4), " +
				  "type VARCHAR(10), " +
				  "resolution VARCHAR(9), " +
				  "formatplayback VARCHAR(100), " +
				  "price FLOAT(8), " +
				  "availability INTEGER(3), " +
				  "PRIMARY KEY(code))";
			stmt.executeUpdate(sql);		
			System.out.println("Created table BLUERAYDVD successfully");
			//====================================================
			
			
			//CREATE TABLE CAMERA
			//====================================================
			sql = "CREATE TABLE CAMERA " +
				  "(code INTEGER not NULL, " +
				  "manufacturer VARCHAR(30) not NULL, " +
				  "modelname VARCHAR(30) not NULL, " +
				  "modelyear INTEGER(4), " +
				  "type VARCHAR(12), " +
				  "megapixel FLOAT(4), " +
				  "screensize FLOAT(4), " +
				  "optzoom FLOAT(5), " +
				  "digzoom FLOAT(5), " +
				  "price FLOAT(8), " +
				  "availability INTEGER(3), " +
				  "PRIMARY KEY(code))";
			stmt.executeUpdate(sql);		
			System.out.println("Created table CAMERA successfully");
			//====================================================
			
			
			//CREATE TABLE CONSOLES
			//====================================================
			sql = "CREATE TABLE CONSOLES " +
				  "(code INTEGER not NULL, " +
				  "manufacturer VARCHAR(30) not NULL, " +
				  "modelname VARCHAR(30) not NULL, " +
				  "modelyear INTEGER(4), " +
				  "type VARCHAR(10), " +
				  "cpu VARCHAR(30), " +
				  "gpu VARCHAR(30), " +
				  "hdd VARCHAR(30), " +
				  "sound VARCHAR(30), " +
				  "price FLOAT(8), " +
				  "availability INTEGER(3), " +
				  "PRIMARY KEY(code))";
			stmt.executeUpdate(sql);		
			System.out.println("Created table CONSOLES successfully");
			//====================================================
			
			
			//CREATE TABLE FRIDGES
			//====================================================
			sql = "CREATE TABLE FRIDGES " +
				  "(code INTEGER not NULL, " +
				  "manufacturer VARCHAR(30) not NULL, " +
				  "modelname VARCHAR(30) not NULL, " +
				  "modelyear INTEGER(4), " +
				  "type VARCHAR(10), " +
				  "retcapacity INTEGER(4), " +
				  "frecapacity INTEGER(4), " +
				  "energyclass VARCHAR(6), " +
				  "price FLOAT(8), " +
				  "availability INTEGER(3), " +
				  "PRIMARY KEY(code))";
			stmt.executeUpdate(sql);		
			System.out.println("Created table FRIDGES successfully");
			//====================================================
			
			
			//CREATE TABLE WASHINGMASHINES
			//====================================================
			sql = "CREATE TABLE WASHINGMASHINES " +
				  "(code INTEGER not NULL, " +
				  "manufacturer VARCHAR(30) not NULL, " +
				  "modelname VARCHAR(30) not NULL, " +
				  "modelyear INTEGER(4), " +
				  "capacity FLOAT(3), " +
				  "rotation INTEGER(5), " +
				  "energyclass VARCHAR(6), " +
				  "price FLOAT(8), " +
				  "availability INTEGER(3), " +
				  "PRIMARY KEY(code))";
			stmt.executeUpdate(sql);		
			System.out.println("Created table WASHINGMASHINES successfully");
			//====================================================
			
			
			//CREATE TABLE PICTURES
			//====================================================
			sql = "CREATE TABLE PICTURES " +
					  "(id INTEGER not NULL, " +
					  "modelname VARCHAR(30) not NULL, " +					  
					  "abspath INTEGER(255), " +
					  "PRIMARY KEY(id))";
			stmt.executeUpdate(sql);		
			System.out.println("Created table PICTURES successfully");
			//====================================================
				
				
			//CREATE TABLE SALES
			//====================================================
			sql = "CREATE TABLE SALES " +
					  "(code INTEGER not NULL, " +
					  "perName VARCHAR(30)," +
					  "perSName VARCHAR(30), " +
					  "perCity VARCHAR(15), " +
					  "perAddress VARCHAR(30), " +
					  "perPhone INTEGER(15), " +
					  "perTime VARCHAR(30), " +  
					  "PRIMARY KEY(code) )";
			stmt.executeUpdate(sql);		
			System.out.println("Created table SALES successfully");
			//====================================================
			
			
			
			
		}catch(SQLException se){
		    //Handle errors for JDBC
		    se.printStackTrace();
		 }catch(Exception e){
		    //Handle errors for Class.forName
		    e.printStackTrace();
		 }finally{
		    //finally block used to close resources
		    try{
		       if(stmt!=null)
		          conn.close();
		    }catch(SQLException se){
		    }// do nothing
		    try{
		       if(conn!=null)
		          conn.close();
		    }catch(SQLException se){
		       se.printStackTrace();
		    }//end finally try
		 }//end try
		 System.out.println("Goodbye!");
	}
	
}

