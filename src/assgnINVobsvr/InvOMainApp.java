package assgnINVobsvr;

// https://sourcemaking.com/design_patterns/observer/java/1



public class InvOMainApp
{
	public static void main(String[] args)
	{
		// Create objects
		InvOModel theModel = new InvOModel();
		InvOController theController = new InvOController();
		InvOView theView = new InvOView();
		
		// Link objects
		theController.setTheView(theView);
		theController.setTheModel(theModel);
		
		theModel.setTheView(theView);	// So the model does not know about the view  REMEMBER, remove the methods inside the classes
		theModel.setTheController(theController);
		theModel.add(theView);
		
		theView.setTheModel(theModel);	// So the view does not know about the model REMEMBER, remove the methods inside the classes
		theView.setTheController(theController);
		
		theView.start();
		
	}
}