public class Controller {

	private Model shopModel;
	private View shopView;
	private CPanel1 cpanel1;
	private CPanel2 cpanel2;
	Controller(Model shopModel, View shopView){		
		shopModel = this.shopModel;
		shopView = this.shopView;			
	}
	
	void ControllerPanel1(CPanel1 cpanel1){
		this.cpanel1 = cpanel1;
	}
	
	void ControllerPanel1(CPanel2 cpanel2){
		this.cpanel2 = cpanel2;
	}
}
