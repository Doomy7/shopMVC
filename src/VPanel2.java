import java.awt.*;
import javax.swing.*;

public class VPanel2 extends JPanel{
	static JButton p2but1,p2but2;
	static JLabel photo;
	static JScrollPane deviceScroller;
	static JList sales;
	public static DefaultListModel listModel2;
	public static Object panel2;
	GridBagConstraints constraints;
	GridBagLayout layout2;
	static ImageIcon ico;
	static Image img;
	static Image newimg;
	static JFrame details;
	public static Object pdet;
	public static Object det;
	
	VPanel2(){
		
		
		layout2 = new GridBagLayout();
		setLayout(layout2);
		listModel2 = new DefaultListModel();	
		sales = new JList(listModel2);
		
		CPanel2.C_getSales(listModel2);
		
		photo = new JLabel();
		photo.setPreferredSize(new Dimension(400,300));
		photo.setBackground(Color.WHITE);
		constraints = new GridBagConstraints();
	
		constraints.fill = GridBagConstraints.BOTH;
		
		deviceScroller = new JScrollPane(sales);
		deviceScroller.setPreferredSize(new Dimension(350, 100));
		
		addComponent(photo,layout2,3,3,3,3);
		sales.addMouseListener(new CPanel2.CsalelistListener());
		addComponent(deviceScroller,layout2,3,0,3,3);
		
		
		

	}
	
	private void addComponent(Component component,GridBagLayout layout, int row, int column, int width, int height){
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
	}
	
	static void VnewSalePanel(){
		
		details = new JFrame();
		JLabel det = new JLabel("", SwingConstants.CENTER);
		det.setPreferredSize(new Dimension(300,300));
		details.setLayout(new GridBagLayout());
		det.setText(CPanel2.getSaleDescription());
		
		details.add(det);
		
		details.setSize(800,600);
		details.setTitle("Product details");				
		details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		details.setVisible(true);
		
	}

}
