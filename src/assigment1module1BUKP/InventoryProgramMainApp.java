package assigment1module1BUKP;


public class InventoryProgramMainApp
{
	public static void main(String[] args) throws Exception
	{
		/**
		 * Assignment Description: 
		 * 
		 * Create an inventory system for a multimedia store such as Borders (remember Borders?).  
		 * The system will manage an inventory comprised of CDs, DVDs, and books.  The system will 
		 * allow the user to enter new items into the system, search for and edit existing items, 
		 * and delete items.  These operations are often collectively referred to as CRUD 
		 * (Create, Retrieve, Update, and Delete).  The input and output can be accomplished by using 
		 * the System.in and System.out objects.  The user interface code will be modularized as a View 
		 * (or Delegate) component, such that it can easily be swapped out for a different View component.
		 * The initial view will be a text-based console view.  It is recommended that you use the Scanner 
		 * class to manage keyboard input.  The underlying inventory representation will be modularized as 
		 * a Model component such that it can easily be swapped out for a different Model. The inventory 
		 * will be persistent, and it will be maintained using the Properties class.
		 * 
		 * Your application will make use of inheritance, polymorphism, and at least one interface definition.  
		 * It will also make use of at least one enumeration (enum type).
		 * 
		 * Your application will run as runnable jar file.
		 * 
		 * --Deliverables--
		 * There are four deliverables that must be submitted.  These deliverables are as follows:
		 * 1. A brief Software System Requirements Specification document.  This should reiterate the project 
		 * description above, and provide enough additional specifications to facilitate design and implementation.
		 * 
		 * 2. A brief Software System Design Document that identifies the key abstractions of your application, 
		 * and describes the relationships between them.
		 * 
		 * 3. Your application as a runnable jar.
		 * 
		 * 4. IMPORTANT!  Your source code as well as capture images of your application in operation within a 
		 * separate zip file.
		 * 
		 * @author 
		 */
		
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