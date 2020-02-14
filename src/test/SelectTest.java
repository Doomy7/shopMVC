package test;
import java.sql.*;

public class SelectTest {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/SHOPMVC";
	static final String USER = "username";
	static final String PASS = "password";
	static String sql = "";
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet result;
	
public static void main (String args []) throws ClassNotFoundException, SQLException{	
		
	Class.forName(JDBC_DRIVER);
		System.out.println("Connecting to a selected database");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("Connected to database successfully");
		stmt = conn.createStatement();
		
		sql = "DROP TABLE PICTURES";
		stmt.executeUpdate(sql);
	
		//result.close();
		
	}

	static void printCategories() throws SQLException{
		while(result.next()){
			int id = result.getInt("id");
			String cat = result.getString("Category");
			System.out.print("ID: " + id);
	        System.out.print(", Category: " + cat + "\n");
		}
	}

	static void printTV() throws SQLException{
		while(result.next()){
			int code = result.getInt("code");
			String manufacturer = result.getString("manufacturer");
			String modelname = result.getString("modelname");
			String type = result.getString("type");
			int modelyear = result.getInt("modelyear");
			int inches = result.getInt("inches");
			String resolution = result.getString("resolution");
			int hdmi = result.getInt("hdmi");
			int dvi = result.getInt("dvi");
			int composite = result.getInt("composite");
			float price = result.getFloat("price");
			int availability = result.getInt("availability");
			String imgpath = result.getString("imagepath");
			System.out.print("code: " + code);
	        System.out.print(", manufacturer: " + manufacturer);
	    	System.out.print(", modelname: " + modelname);
	        System.out.print(", type: " + type);
	        System.out.print(", modelyear: " + modelyear);
	    	System.out.print(", inches: " + inches);
	        System.out.print(", resolution: " + resolution);
	    	System.out.print(", hdmi: " + hdmi);
	        System.out.print(", dvi: " + dvi);
	        System.out.print(", composite: " + composite);
	        System.out.print(", price: " + price);
	        System.out.print(", availability: " + availability + "\n");
	        System.out.print(", imgpath: " + imgpath + "\n");
		}
	}
	
	static void printCameras() throws SQLException{
		while(result.next()){
			int code = result.getInt("code");
			String manufacturer = result.getString("manufacturer");
			String modelname = result.getString("modelname");
			int modelyear = result.getInt("modelyear");
			String type = result.getString("type");
			float megapixel = result.getFloat("megapixel");
			float screensize = result.getFloat("screensize");
			float optzoom = result.getFloat("optzoom");
			float digzoom = result.getFloat("digzoom");
			float price = result.getFloat("price");
			int availability = result.getInt("availability");
			String imgpath = result.getString("imagepath");
			System.out.print("code: " + code);
	        System.out.print(", manufacturer: " + manufacturer);
	    	System.out.print(", modelname: " + modelname);
	    	System.out.print(", modelyear: " + modelyear);
	    	System.out.print(", type: " + type);
	    	System.out.print(", megapixel: " + megapixel);
	    	System.out.print(", screensize: " + screensize);
	    	System.out.print(", optzoom: " + optzoom);
	    	System.out.print(", digzoom: " + digzoom);
	        System.out.print(", price: " + price);
	        System.out.print(", availability: " + availability + "\n");	  		
	        System.out.print(", imgpath: " + imgpath + "\n");	
		}
	}
	
	static void printConsoles() throws SQLException{
		while(result.next()){
			int code = result.getInt("code");
			String manufacturer = result.getString("manufacturer");
			String modelname = result.getString("modelname");
			int modelyear = result.getInt("modelyear");
			String type = result.getString("type");
			String cpu = result.getString("cpu");
			String gpu = result.getString("gpu");
			String hdd = result.getString("hdd");
			String sound = result.getString("sound");
			float price = result.getFloat("price");
			int availability = result.getInt("availability");
			String imgpath = result.getString("imagepath");
			System.out.print("code: " + code);
	        System.out.print(", manufacturer: " + manufacturer);
	    	System.out.print(", modelname: " + modelname);
	    	System.out.print(", modelyear: " + modelyear);
	    	System.out.print(", type: " + type);
	    	System.out.print(", cpu: " + cpu);
	    	System.out.print(", gpu: " + gpu);
	    	System.out.print(", hdd: " + hdd);
	    	System.out.print(", sound: " + sound);
	        System.out.print(", price: " + price);
	        System.out.print(", availability: " + availability + "\n");	  	
	        System.out.print(", imgpath: " + imgpath + "\n");		
		}
	}

	
	
}
