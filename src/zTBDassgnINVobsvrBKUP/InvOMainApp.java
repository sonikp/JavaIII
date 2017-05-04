package zTBDassgnINVobsvrBKUP;

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
		
		theModel.setTheView(theView);
		theModel.setTheController(theController);
		theModel.add(theView);
		
		theView.setTheModel(theModel);
		theView.setTheController(theController);
		
		theView.start();
		
	}
}