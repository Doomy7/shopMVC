package test;
import java.sql.*;

public class loadDatabase {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/SHOPMVC";
	static final String USER = "username";
	static final String PASS = "password";
	static String sql = "";
	static Connection conn = null;
	static Statement stmt = null;
	
	public static void main (String args []) throws ClassNotFoundException, SQLException{	
		
		createConnection();
		createTables();
		loadTables();
		
		conn.close();
	}

	static void dropAll() throws SQLException{
		sql = "DROP DATABASE SHOPMVC";
		stmt.executeUpdate(sql);
		sql = "DROP TABLE CATEGORIES";
		stmt.executeUpdate(sql);
		sql = "DROP TABLE TV";
		stmt.executeUpdate(sql);
		sql = "DROP TABLE CAMERAS";
		stmt.executeUpdate(sql);
		sql = "DROP TABLE CONSOLES";
		stmt.executeUpdate(sql);	
		sql = "DROP TABLE PICTURES";
		stmt.executeUpdate(sql);
		sql = "DROP TABLE SALES";
		stmt.executeUpdate(sql);
	}
	
	static void createConnection() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		System.out.println("Connecting to a selected database");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("Connected to database successfully");
		System.out.println("Creating table in given database...");
		stmt = conn.createStatement();
	}
	
	static void createDatabase() throws SQLException{
		sql = "CREATE DATABASE SHOPMVC";
		stmt.executeUpdate(sql);
		System.out.println("Database created successfully...");
	}
	
	//CREATE TABLES
	//====================================================
	static void createTables() throws SQLException{
		createCategories();
		createTV();
		createCameras();
		createConsoles();
	}
	//====================================================
	
	//LOAD TABLES
	//====================================================
	static void loadTables() throws SQLException{
		loadCategories();
		loadTV();
		loadCameras();
		loadConsoles();		
	}
	//====================================================
	
	//CREATE TABLE CATEGORIES
	//====================================================
	static void createCategories() throws SQLException{
		
				sql = "CREATE TABLE CATEGORIES " +
							 "(id INTEGER not NULL, " +
							 "Category VARCHAR(20)," +
							 "PRIMARY KEY ( id ))";
				stmt.executeUpdate(sql);	
				System.out.println("Created table CATEGORIES successfully");
	}
	//====================================================
	
	//CREATE TABLE TV
	//====================================================
	static void createTV() throws SQLException{
		
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
						  "price FLOAT(8), " +
						  "availability INTEGER(3), " +
						  "imagepath VARCHAR(100), " +
						  "PRIMARY KEY( code ))";
				stmt.executeUpdate(sql);		
				System.out.println("Created table TV successfully");
				
	}
	//====================================================
	
	//CREATE TABLE CAMERAS
	//====================================================
	static void createCameras() throws SQLException{
		
				sql = "CREATE TABLE CAMERAS " +
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
					  "imagepath VARCHAR(100), " +
					  "PRIMARY KEY(code))";
				stmt.executeUpdate(sql);		
				System.out.println("Created table CAMERA successfully");
				
	}
	//====================================================
	
	//CREATE TABLE CONSOLES
	//====================================================
	static void createConsoles() throws SQLException{
		
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
					  "imagepath VARCHAR(100), " +
					  "PRIMARY KEY(code))";
				stmt.executeUpdate(sql);		
				System.out.println("Created table CONSOLES successfully");
				
	}
	//====================================================
	
	//CREATE TABLE SALES
	//====================================================
	static void createSales() throws SQLException{
		
		
		sql = "CREATE TABLE SALES " +
				  "(code INTEGER not NULL, " +
				  "perName VARCHAR(30)," +
				  "perSName VARCHAR(30), " +
				  "perCity VARCHAR(15), " +
				  "perAddress VARCHAR(30), " +
				  "perPhone INTEGER(15), " +
				  "perTime VARCHAR(30), " +
				  "saleDesc VARCHAR(300), " +
				  "PRIMARY KEY(code) )";
		stmt.executeUpdate(sql);		
		System.out.println("Created table SALES successfully");
		
	}
	//====================================================

	//INSERTING TO TABLE CATEGORIES
	
	static void loadCategories() throws SQLException{
		//INSERTING CATEGORIES
		sql = "INSERT INTO CATEGORIES " +
				  "VALUES (1, 'TV')";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO CATEGORIES " +
				  "VALUES (3, 'Cameras')";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO CATEGORIES " +
				  "VALUES (4, 'Consoles')";
		stmt.executeUpdate(sql);
		
		System.out.println("Inserted to Categories successfully");
	}
	//==================================================== 
	
	//INSERTING TO TABLE TV
	//====================================================
	static void loadTV() throws SQLException{
		sql = "INSERT INTO TV " +
				  "VALUES (6781, 'SHARP', 'LC-50LE758EN', 'LED', 2015, 50, '1920x1080', 4, 0, 1, 800, 0, '/images/LC-50LE758EN.jpg')";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO TV " +
				  "VALUES (781, 'SAMSUNG', '48J5200', 'LED', 2014, 48, '1920x1080', 2, 0, 1, 580, 0,'/images/48J5200.jpg')";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO TV " +
				  "VALUES (7861, 'LG', '42LF5800', 'LED', 2014, 42, '1920x1080', 3, 1, 1, 430, 2, '/images/42LF5800.jpg')";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO TV " +
				  "VALUES (17573, 'LG', '55UF8517', 'LED', 2014, 55, '3840x2160', 3, 0, 2, 1400, 4, '/images/55UF8517.jpeg')";
		stmt.executeUpdate(sql);
		
	}
	//==================================================== 
		
	//INSERTING TO TABLE CAMERAS
	//==================================================== 
	static void loadCameras() throws SQLException{
		sql = "INSERT INTO CAMERAS " +
				"VALUES (7861 , 'CANON', 'SX410', 2012, 'COMPACT', 20, 3, 40, 80, 250, 2, '/images/POWERSHOT SX410.jpg')";
		stmt.executeUpdate(sql);		
		sql = "INSERT INTO CAMERAS " +
				"VALUES (7561 , 'SONY', 'DSC-W810', 2012, 'COMPACT', 20.1, 2.7, 6, 12, 110, 5, '/images/CYBERSHOT DSC-W810.jpeg')";
		stmt.executeUpdate(sql);			
		sql = "INSERT INTO CAMERAS " +
				"VALUES (2131 , 'PANASONIC', 'DMC-FZ200', 2012, 'BRIDGE', 24.1, 3, 24, 48, 500, 1, '/images/LUMIX DMC-FZ200.jpeg')"; 
		stmt.executeUpdate(sql);			
		sql = "INSERT INTO CAMERAS " +
				"VALUES (172 , 'OLYMPUS', 'STYLUS SH-1', 2012, 'COMPACT', 16, 3, 24, 96, 420, 4, '/images/LUMIX DMC-FZ200.jpeg')";
		stmt.executeUpdate(sql);
	}
	//==================================================== 
	
	//INSERTING TO TABLE CONSOLES
	//==================================================== 
	static void loadConsoles() throws SQLException{
		sql = "INSERT INTO CONSOLES " + 
			 "VALUES(9873, 'Nintendo', 'Wii U', 2012, 'Wii', '1.24 GHz Tri-Core IBM PowerPC', '550 MHz AMD Radeon', '8', '5.1 Linear PCM, Analog stereo', 300, 1, '/images/Wii.jpg')";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO CONSOLES " + 
				  "VALUES(752, 'Sony', 'PLAYSTATION 3 SUPER SLIM', 2012, 'PS3', '3.2 GHz with 1 PPE & 7 SPEs', '550 MHz NVIDIA/SCEI RSX', '12', 'A/V-Multi, HDMI, TOSLINK', 205, 4, '/images/PLAYSTATION 3 SUPER SLIM.jpg')";
		stmt.executeUpdate(sql);  
		sql = "INSERT INTO CONSOLES " + 
				  "VALUES(7765, 'Microsoft', 'XBOX ONE', 2012, 'XBOX', 'MICROSOFT CUSTOM-(8-core)', '1,31 TFLOPS AMD RADEON', '1000', 'HDMI, OPTICAL S/PDIF', 205, 1, '/images/XBOX ONE.png')";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO CONSOLES " + 
				  "VALUES(876, 'Sony', 'PLAYSTATION 4', 2012, 'PS4', ' AMD Jaguar-(8-core)', '1,84 TFLOPS AMD RADEON', '1000', 'HDMI, OPTICAL', 430, 2, '/images/PS4.png')";
		stmt.executeUpdate(sql);
	}
	//==================================================== 
	
}