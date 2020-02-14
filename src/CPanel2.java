import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class CPanel2 {
	
	static String desc = "";
	
	static void  C_getSales (DefaultListModel listModel2){
		
		ResultSet sls;
		try {
			sls = Model.query_getSales();
			while(sls.next()){
				listModel2.addElement(sls.getInt("code") + " " + sls.getString("perName") + " " + sls.getString("perSName"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	

	static class CsalelistListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(VPanel2.listModel2.size() == 0){
			
			}else{
				if (e.getClickCount() == 2 ){
					
					VPanel2.VnewSalePanel();
					
				}else{
					//VPanel2.setImage(i);
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



	public static String getSaleDescription() {
		// TODO Auto-generated method stub
		String Psale = VPanel2.sales.getSelectedValue().toString();
		desc = findSale(Psale);
		System.out.println(desc);
		return desc;
	}

	static String findSale(String psale) {
		// TODO Auto-generated method stub
		String info = "";
		try {
			StringTokenizer st = new StringTokenizer(psale);
			int code = Integer.parseInt(st.nextToken());
			ResultSet description = Model.query_getSale(code);
		
			while(description.next()){
				
				info = "<html>" +
						"Code: " + description.getInt("code") + "<br>" +
						"Name: " + description.getString("perName") + "<br>" +
						"Surname: " + description.getString("perSName") + "<br>" +
						"City: " + description.getString("perCity") + "<br>" +
					    "Address: " + description.getString("perAddress") + "<br>" +
						"Phone: " + description.getInt("perPhone") + "<br>" +
						"Time: " + description.getString("perTime") + "<br>" +
						"Description: " + description.getString("saleDesc") + "<br>" +
				        "</html>";
			}
			
			return info;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	
		
	}
}


