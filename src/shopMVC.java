
public class shopMVC {

	public static void main (String[] args){
		Model shop = new Model();
		View view = new View(shop);
		Controller controller = new Controller(shop,view);
		//view.addWindowListener(new Cwindow.CwindowListener());
	    view.setVisible(true);
	}
}
