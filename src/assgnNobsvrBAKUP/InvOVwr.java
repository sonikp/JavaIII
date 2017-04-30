package assgnNobsvrBAKUP;


public class InvOVwr
{

	private InvOCtrlr theController;
	private InvOMdl theModel;
	
	// default constructor
	public InvOVwr(){}
	
	
	public void start() {
		System.out.println("Figuring out the Observer Pattern");
		

		
	}

	public void setTheModel(InvOMdl theModel) {
		this.theModel = theModel;
	}
	
	public InvOMdl getTheModel() {
		return theModel;	
	}

	public void setTheController(InvOCtrlr theController) {
		this.theController = theController;	
	}
	
	public InvOCtrlr getTheController() {
		return theController;	
	}


	
}