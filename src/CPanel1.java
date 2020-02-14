import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class CPanel1 {
	
	 static double cat1dis = 0.15;
	 static double cat2dis = 0.20;
	 static double cat3dis = 0.10;
	 static int days;
	 static String time;
	 static String dtime;
	 static Random rand = new Random();
	 static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	 static Calendar c = Calendar.getInstance();

	 static JFrame id;
	 static JFrame details;
	 static String cl_cat = "";
	 static String name;
	 //GETTING CATEGORIES
	static void C_getCategories (DefaultListModel catlist){
		
		ResultSet cat = Model.query_getCategories();
		try {
			while(cat.next()){
				catlist.addElement(cat.getString("Category"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//CATEGORY LIST LISTENER
	static class CcatlistListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent click) {			
			// TODO Auto-generated method stub							
			if (click.getClickCount() == 2){
				// TODO Auto-generated method stub
				VPanel1.listModel1.clear();
				cl_cat = VPanel1.cat.getSelectedValue().toString();			
					ResultSet catName = Model.query_getModelNames(cl_cat);
					try {
						while(catName.next()){
							VPanel1.listModel1.addElement(catName.getString("modelname"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(VPanel1.listModel1.size() == 0){
						VPanel1.listModel1.addElement("No products available!");
					}				
				}					
			}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
	
	static class CdeviceListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			//============================================//
			//PARATHIRO LEPTOMERIWN SHSKEYHS//
			//============================================//

			String name = VPanel1.device.getSelectedValue().toString();
			if (e.getClickCount() == 2 ){	
				String pathimage = getDeviceImage(cl_cat,name);
				boolean available = getDeviceAvail(cl_cat,name);
				VPanel1.VnewDevicePanel(pathimage,name, available);	
			//============================================//
			//============================================//
			}else{
				//============================================//
				//PROBOLH EIKONAS EPILEGMENHS SHSKEYHS
				//============================================//
				if (VPanel1.device.getSelectedIndex() != -1) {
					String pathimage = getDeviceImage(cl_cat,name);
					VPanel1.VnewDeviceIcon(pathimage);
				}
				//============================================//
				//============================================//
			}
			
		}
		

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}
		
	static class CbuttonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == VPanel1.devbut1){
				//============================================//
				//PARATHIRO PWLHSHS//
				//============================================//
				VPanel1.VnewSalePanel();
					
			}else if(e.getSource() == VPanel1.oksale){	
				int sale_code = 0;
				try {
					ResultSet size = Model.query_getSize();
					while(size.next()){
						sale_code = size.getInt(1) + 1;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String name = VPanel1.device.getSelectedValue().toString();
				time = getDateTime();				
				String saleDesc = getDeviceinfo(name);
				AddSale(sale_code,VPanel1.finame.getText(),VPanel1.laname.getText(),VPanel1.ccity.getText(),VPanel1.addre.getText(),Integer.parseInt(VPanel1.pphone.getText()),time,saleDesc);
				updateAvailability(cl_cat,name);

				JOptionPane.showMessageDialog(null, "Sale Added Successfully.");
				VPanel1.id.dispose();
				VPanel1.details.dispose();
			 
				
				
			}else if(e.getSource() == VPanel1.cancelsale){
				VPanel1.id.dispose();

			}else if(e.getSource() == VPanel1.p1but1){
				VPanel1.listModel1.clear();
			}
		}
	
	}
	
	private static String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	static String getDeviceinfo(String name){
		String info = "";
		ResultSet query = Model.query_getModelInfo(cl_cat,name);
	
		if(cl_cat.equals("TV")){
			try {
				while(query.next()){
					return "<html>" +
							"Code: " + query.getInt("code") + "<br>" +
							"Manufacturer: " + query.getString("manufacturer") + "<br>" +
							"Modelname: " + query.getString("modelname") + "<br>" +
							"Type: " + query.getString("type") + "<br>" +
						    "Modelyear: " + query.getInt("modelyear") + "<br>" +
							"Inches: " + query.getInt("inches") + "<br>" +
							"Resolution: " + query.getString("resolution") + "<br>" +
							"HDMI: " + query.getInt("hdmi") + "<br>" +
					    	"DVI: " + query.getInt("dvi") + "<br>" +
					    	"Composite: " + query.getInt("composite") + "<br>" +
					        "Price: " + query.getFloat("price") +  "<br>" +
					        "Availability: " + query.getInt("availability") + "<br>" +
					        "</html>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cl_cat.equals("Cameras")){
			try {
				while(query.next()){
					return "<html>" +
							"Code: " + query.getInt("code") + "<br>" +
					       "Manufacturer: " + query.getString("manufacturer") + "<br>" +
						   "Modelname: " + query.getString("modelname") + "<br>" +
					       "Type: " + query.getString("type") + "<br>" +
					       "Modelyear: " + query.getInt("modelyear") + "<br>" +
					       "Megapixel: " + query.getFloat("megapixel") + "<br>" +
				           "Screensize: " + query.getFloat("screensize") + "<br>" +
						   "Optzoom: " + query.getFloat("optzoom") + "<br>" +
					       "Digzoom: " + query.getFloat("digzoom") + "<br>" +        
						   "Price: " + query.getFloat("price") + "<br>" +
						   "Availability: " + query.getInt("availability") + "<br>" +
						   "</html>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cl_cat.equals("Consoles")){
			try {
				while(query.next()){
					return "<html>" +
							"Code: " + query.getInt("code") + "<br>" +
				       	   "Manufacturer: " + query.getString("manufacturer") + "<br>" +
				       	   "Modelname: " + query.getString("modelname") + "<br>" +
				           "Type: " + query.getString("type") + "<br>" +
				           "Modelyear: " + query.getInt("modelyear") + "<br>" +
				       	   "Cpu: " + query.getString("cpu") + "<br>" +
				    	   "Gpu: " + query.getString("gpu") + "<br>" +
				    	   "HDD: " + query.getString("hdd") + "<br>" +
				    	   "Sound: " + query.getString("sound") + "<br>" +
			    		   "Price: " + query.getFloat("price") + "<br>" +
						   "Availability: " + query.getInt("availability") + "<br>" + 	
						   "</html>"; 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return info;
	}
	
	static String getDeviceImage(String cl_cat, String name){
		String path = "";
		ResultSet imagepath = Model.query_getDeviceImage(cl_cat,name);
		try {
			while(imagepath.next()){
				path = imagepath.getString("imagepath");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	static boolean getDeviceAvail(String cl_cat, String name){
		boolean av = false;
		ResultSet availability = Model.query_getAvailability(cl_cat,name);
		try {
			while(availability.next()){
				av = (availability.getInt("availability") > 0 ? true : false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return av;
	}

	static void updateAvailability(String cl_cat, String name){
		try {
			Model.update_reduceAvailability(cl_cat,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void AddSale(int code, String perName, String perSName, String perCity, String perAddress, int perPhone, String time, String saleDesc){		
		try {
			Model.update_AddSale(code,perName,perSName,perCity,perAddress,perPhone,time,saleDesc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

