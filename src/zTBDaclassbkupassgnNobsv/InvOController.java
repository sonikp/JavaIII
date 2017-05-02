package zTBDaclassbkupassgnNobsv;

public class InvOController
{
	
	private InvOView theView;
	private InvOModel theModel;
	
	// constructor
	public InvOController(){}
	
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