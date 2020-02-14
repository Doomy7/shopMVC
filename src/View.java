import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class View extends JFrame{

	private JTabbedPane tabbedPane;
	private VPanel1 panel1;
	private VPanel2 panel2;
	
	String message;
	static boolean productswriten,saleswriten,orderswriten;
	
	View(Model shop){		
		tabbedPane = new JTabbedPane();
		add(tabbedPane);
		//-----------------------------------------//
		//----------------PANEL 1------------------//
		//-----------------------------------------//		
		panel1 = new VPanel1();
		tabbedPane.addTab("Products",null,panel1,"First Panel");	
		
		//-----------------------------------------//	
		//-----------------------------------------//
		//----------------PANEL 2------------------//
		//-----------------------------------------//
		panel2 = new VPanel2();
		tabbedPane.addTab("Sales",null,panel2,"Second Panel");
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,500);		
	}	
}
