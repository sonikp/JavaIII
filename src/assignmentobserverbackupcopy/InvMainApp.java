package assignmentobserverbackupcopy;




public class InvMainApp
{
	public static void main (String[] args) throws Exception
	{
		// create objects
		InvModel theModel = new InvModel();
		InvController theController = new InvController();	
		InvView theView = new InvView();	
		
		// link the objects
		theController.setTheView(theView);
		theController.setTheModel(theModel);
		
		theModel.setTheView(theView);
		theModel.setTheController(theController);

		theView.setTheModel(theModel);
		theView.setTheController(theController);
		
		// start application
		theView.start();
		



	}
}