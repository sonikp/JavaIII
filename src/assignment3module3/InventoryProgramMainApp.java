package assignment3module3;

	/**
	 * Assignment #3 Description: 
	 * 
	 * 
	 * Project Change Description
	 * 
	 * Replace the “Model” component of your application with a new model.  The new model will make use of JDBC to connect to an 
	 * underlying relational database.   MySQL is a simple and free choice for your database.  You must design a model that supports 
	 * the functionality of the previous “Model” component.  The new “Model” component will interface with the “View” component in 
	 * the same manner as the previous “View” component.  In addition, your code will  make use of exception handling to deal with 
	 * SQLExceptions. Additionally, your View will make use of a JTable to display the results of your queries upon the Model.
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