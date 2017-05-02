package zTBDassgnINVobsvr01;

public class InvOMdl
{
	
	private InvOVwr theView;
	private InvOCtrlr theController;
	
	// constructor
	public InvOMdl(){}
	
	
	// MVC setters and getters
	public void setTheController(InvOCtrlr theController) {
		this.theController = theController;
	}
	
	public InvOCtrlr getTheController(){
		return theController;
	}
	
	public void setTheView(InvOVwr theView) {
		this.theView = theView;	
	}
	
	public InvOVwr getTheView(){
		return theView;
	}
}