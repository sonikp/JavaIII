package assgnINVobsvr;

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