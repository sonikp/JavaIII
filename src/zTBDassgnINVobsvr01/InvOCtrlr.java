package zTBDassgnINVobsvr01;

public class InvOCtrlr
{
	
	private InvOVwr theView;
	private InvOMdl theModel;
	
	// constructor
	public InvOCtrlr(){}
	
	// MVC setters and getters
	public void setTheView(InvOVwr theView) {
		this.theView = theView;	
	}
	
	public InvOVwr getTheView(){
		return theView;
	}

	public void setTheModel(InvOMdl theModel) {
		this.theModel = theModel;		
	}
	
	public InvOMdl getTheModel(){
		return theModel;
	}
	
}