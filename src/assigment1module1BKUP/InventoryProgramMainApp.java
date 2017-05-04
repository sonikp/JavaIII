package assigment1module1BKUP;


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