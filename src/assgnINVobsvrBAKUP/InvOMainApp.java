package assgnINVobsvrBAKUP;

public class InvOMainApp
{
	public static void main(String[] args)
	{
		// Create objects
		InvOMdl theModel = new InvOMdl();
		InvOCtrlr theController = new InvOCtrlr();
		InvOVwr theView = new InvOVwr();
		
		// Link objects
		theController.setTheView(theView);
		theController.setTheModel(theModel);
		
		theModel.setTheView(theView);
		theModel.setTheController(theController);
		
		theView.setTheModel(theModel);
		theView.setTheController(theController);
		
		theView.start();
		
	}
}