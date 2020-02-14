import java.sql.*;

public class Model {
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private final static String DB_URL = "jdbc:mysql://localhost/SHOPMVC";
	private final static String USER = "username";
	private final static String PASS = "password";
	private static String sql = "";
	private static ResultSet query;
	private static Connection conn = null;
	private static Statement stmt = null;
	private ResultSet result;
	
	Model(){
		connectToDatabase();
	}
	
	private static void connectToDatabase(){
		try{		      
		      Class.forName(JDBC_DRIVER);     
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      stmt = conn.createStatement();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	}
	
	static ResultSet query_getCategories(){
			
		sql = "SELECT Category FROM CATEGORIES";
		try {
			query = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return query;
	}
	
	private static void closeConnection(){
		 try{
		     if(conn!=null)
		          conn.close();
		     }catch(SQLException se){
		        se.printStackTrace();
		     }//end finally try
	}

	static ResultSet query_getModelNames(String cl_cat) {
		// TODO Auto-generated method stub
		sql = "SELECT modelname FROM " +  cl_cat;
		System.out.println(sql);
		try {
			query = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}

	static ResultSet query_getModelInfo(String cl_cat, String name){
		
		sql = "SELECT * FROM "+cl_cat+" WHERE modelname = '" + name + "'";
		try {
			query = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}

	static ResultSet query_getDeviceImage(String cl_cat, String name) {
		
		sql = "SELECT imagepath FROM "+cl_cat+" WHERE modelname = '" + name + "'";
		try {
			query = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}
	
	static ResultSet query_getAvailability(String cl_cat, String name){
		sql = "SELECT availability FROM "+cl_cat+" WHERE modelname = '" + name + "'";
		try {
			query = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}

	static ResultSet query_getSize() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet size = stmt.executeQuery("select count(*) from SALES");

		return size;
	}

	static void update_reduceAvailability(String cl_cat, String name) throws SQLException {
		// TODO Auto-generated method stub
		sql = "UPDATE " + cl_cat +
				" SET availability = availability - 1 WHERE modelname = '"+name+"'";
		stmt.executeUpdate(sql);
	}

	static void update_AddSale(int code, String perName, String perSName, String perCity, String perAddress, int perPhone, String time, String saleDesc) throws SQLException {
		// TODO Auto-generated method stub
		sql = "INSERT INTO SALES " +
				"VALUES ("+code+",'"+perName+"','"+perSName+"','"+perCity+"','"+perAddress+"',"+perPhone+",'"+time+"','"+saleDesc+"')";
	
		stmt.executeUpdate(sql);
		
	}

	static ResultSet query_getSale(int code) throws SQLException {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM SALES " +
				"WHERE code = " + code +"";

		query = stmt.executeQuery(sql);
		return query;
	}

	static ResultSet query_getSales() throws SQLException{
		ResultSet query = stmt.executeQuery("SELECT code,perName,perSName FROM SALES");
		return query;	
	}
}
