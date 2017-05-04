package assgnINVobsvr;

import java.io.IOException;

public class InvOController
{
	
	private InvOView theView;
	private InvOModel theModel;
	
	// constructor
	public InvOController(){}
	
	
	///// Methods///////
	public void getItemNumber() {
		
//		System.out.println("DEBUG!!!!");

		theModel.getItemNumber();
		
	}
	
	public void getInventoryALL() throws Exception {
		theModel.getInventoryALL();
		
	}


	public void getInventorySingle(String itemNum) throws Exception {
		theModel.getInventorySingle(itemNum);
		
	}

	public void testObserver(int number){
		theModel.testObserver(number);
	}
	
	public void testObserverString(String valueString){
		theModel.testObserverString(valueString);
	}
	
	
	
	// MVC setters and getters
	public void setTheView(InvOView theView) {
		this.theView = theView;	
	}
	
	public InvOView getTheView(){
		return theView;
	}

	public void setTheModel(InvOModel theModel) {
		this.theModel = theModel;		
	}
	
	public InvOModel getTheModel(){
		return theModel;
	}




	
}