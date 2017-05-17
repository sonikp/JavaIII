package assignment2module2;

	/**
	 * Assignment #2 Description: 
	 * 
	 * 
	 * Project Change Description
	 * 
	 * Replace the “View” component of your application with a new view.  The new view will make use of Java Swing library classes or SWT.
	 * You must design a GUI that supports the functionality of the previous “View” component.  The new “View” component will
	 * interface with the “Model” component in the same manner as the previous “View” component.
	 * 
	 * 
	 * Deliverables:
	 * 
	 * There are two deliverables that must be submitted.  These deliverables are as follows:
	 * 1. Your source code in a .jar or .zip file format.
	 * 2. Captured images of your application in operation.
	 * 
	 * 
	 * @author 
	 */

public class InventoryProgramMainApp
{
	public static void main(String[] args) throws Exception
	{

		
		// Create objects
		InventoryProgramModel theModel = new InventoryProgramModel();
		InventoryProgramController theController = new InventoryProgramController();
		InventoryProgramView theView = new InventoryProgramView();
		
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