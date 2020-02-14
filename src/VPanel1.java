import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VPanel1 extends JPanel{
	
	static JButton p1but1;
	private JButton p1but2;
	static JLabel photo;
	private JScrollPane deviceScroller,catScroller;
	static JList device;
	public static JList cat;
	public static DefaultListModel listModel1,catlist;
	private static GridBagConstraints constraints;
	private GridBagLayout layout1;
	static JButton devbut1,devbut2,oksale,cancelsale,okorder,cancelorder;
	static JTextField finame,laname,ccity,addre,pphone;
	static ImageIcon ico;
	static Image img;  
	static Image newimg;
	static int tr;
	static double initprice;
	
	static JFrame id;
	static JFrame details;
	
	VPanel1(){
		//PANEL1 GRAPHICS (1 of 2)
		layout1 = new GridBagLayout();
		setLayout(layout1);
		listModel1 = new DefaultListModel();
		catlist = new DefaultListModel();
		device = new JList(listModel1);
		cat = new JList(catlist);
		
		
		//GETTING CATEGORIES (LINE 46 CPANEL1)
		CPanel1.C_getCategories(catlist);
		
		//CATEGORY LISTENER (LINE 60 CPANEL1)
		cat.addMouseListener(new CPanel1.CcatlistListener());	
		
		//PANEL1 GRAPHICS (2 of 2)	
		photo = new JLabel();
		photo.setPreferredSize(new Dimension(400,300));
		photo.setBackground(Color.WHITE);
		constraints = new GridBagConstraints();	
		constraints.fill = GridBagConstraints.BOTH;	
		cat.setPreferredSize(new Dimension(200,300));
		VaddComponent(cat,layout1,2,0,1,1);	
		deviceScroller = new JScrollPane(device);
		deviceScroller.setPreferredSize(new Dimension(350, 100));
		
		VaddComponent(photo,layout1,2,4,3,3);
		device.addMouseListener(new CPanel1.CdeviceListener());
		VaddComponent(deviceScroller,layout1,2,1,3,3);
		
	}
	
	static void VnewDevicePanel(String pathimage, String name, Boolean available){
			
					
					details = new JFrame();
					JLabel det = new JLabel("", SwingConstants.CENTER);
					JLabel icon = new JLabel();
					details.setLayout(new GridBagLayout());
					icon.setIcon(new ImageIcon(pathimage));
					ico =  new ImageIcon(System.getProperty("user.dir")+ pathimage);
					img = ico.getImage() ;  
					newimg = img.getScaledInstance( 300, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
					ico = new ImageIcon( newimg );
					icon.setIcon(ico);
					
					det.setPreferredSize(new Dimension(300,200));	
					
					devbut1 = new JButton("Buy");
					devbut2 = new JButton("Order");
					if (available){
						devbut1.setEnabled(true);
						devbut2.setEnabled(false);
					}else if(!available){
						devbut1.setEnabled(false);
						devbut2.setEnabled(true);
					}
					devbut1.addActionListener(new CPanel1.CbuttonListener());
					devbut2.addActionListener(new CPanel1.CbuttonListener());
					
					det.setText(CPanel1.getDeviceinfo(name));
					
					details.add(icon);
					details.add(det);
					details.add(devbut1);
					details.add(devbut2);
					details.setSize(800,600);
					details.setTitle("Product details");				
					details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					details.setVisible(true);
					
	}
			

	static void VnewDeviceIcon(String pathimage){
		
				if (pathimage != null && pathimage.length() > 10) {
					photo.setIcon(new ImageIcon(pathimage));
					ico =  new ImageIcon(System.getProperty("user.dir")+ pathimage);
					img = ico.getImage() ;  
					newimg = img.getScaledInstance( 400, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
					ico = new ImageIcon( newimg );
					photo.setIcon(ico);
				}
				else {
					ImageIcon ico =  new ImageIcon(System.getProperty("user.dir")+ "/images/NA.jpg");
					Image img = ico.getImage() ;  
					Image newimg = img.getScaledInstance( 400, 300,  java.awt.Image.SCALE_SMOOTH ) ;  
					ico = new ImageIcon( newimg );
					photo.setIcon(ico);
				}
	}	
	
	static void VnewSalePanel(){
		id = new JFrame();
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		GridBagLayout salelay = new GridBagLayout();
		id.setLayout(salelay);
		
		JLabel fname = new JLabel("FIRST NAME: ");
		fname.setPreferredSize(new Dimension(100,30));
		
		JLabel lname = new JLabel("LAST NAME: ");
		lname.setPreferredSize(new Dimension(100,30));
		
		JLabel city = new JLabel("CITY: ");
		city.setPreferredSize(new Dimension(100,30));
		
		JLabel addr = new JLabel("ADDRESS: ");
		addr.setPreferredSize(new Dimension(100,30));
		
		JLabel phone = new JLabel("PHONE: ");
		phone.setPreferredSize(new Dimension(100,30));

		finame = new JTextField();
		finame.setPreferredSize(new Dimension(100,30));	
		
		laname = new JTextField();
		laname.setPreferredSize(new Dimension(100,30));	
		
		ccity = new JTextField();
		ccity.setPreferredSize(new Dimension(100,30));	
		
		addre = new JTextField();
		addre.setPreferredSize(new Dimension(100,30));	
		
		pphone = new JTextField();
		pphone.setPreferredSize(new Dimension(100,30));	
		
		VaddComponent(fname,id,salelay,0,0,1,1);
		VaddComponent(finame,id,salelay,0,1,1,1);
		VaddComponent(lname,id,salelay,1,0,1,1);
		VaddComponent(laname,id,salelay,1,1,1,1);
		VaddComponent(city,id,salelay,2,0,1,1);
		VaddComponent(ccity,id,salelay,2,1,1,1);
		VaddComponent(addr,id,salelay,3,0,1,1);
		VaddComponent(addre,id,salelay,3,1,1,1);
		VaddComponent(phone,id,salelay,4,0,1,1);
		VaddComponent(pphone,id,salelay,4,1,1,1);
			
		oksale = new JButton("OK");
		cancelsale = new JButton("Cancel");
		oksale.addActionListener(new CPanel1.CbuttonListener());
		cancelsale.addActionListener(new CPanel1.CbuttonListener());
		oksale.setPreferredSize(new Dimension(50,30));
		cancelsale.setPreferredSize(new Dimension(50,30));
		VaddComponent(oksale,id,salelay,5,0,1,1);			
		VaddComponent(cancelsale,id,salelay,5,1,1,1);
		id.setSize(600, 400);
		id.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		id.setVisible(true);
	}
	

	private void VaddComponent(Component component,GridBagLayout layout, int row, int column, int width, int height){
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
	}
	private static void VaddComponent(Component component,JFrame frame, GridBagLayout layout, int row, int column, int width, int height){
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		frame.add(component);
	}
	
}
