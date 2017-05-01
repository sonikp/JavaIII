package assignmentobserver.BKUP_Robert_static;

/**
 * The Inventory Application 
 * This is an implementation of the MVC design concept for implementing an Inventory
 * application as a JavaIII Project. Additionally this required to use the Observer 
 * design pattern.
 * Inventory System:
 * 	- manage an inventory comprised of CDs, DVDs, and books 
 * 	- enter new items, search for and edit existing items, and delete items
 * 		- Create, Retrieve, Update, and Delete
 * 	- input/output (System.in / System.out)
 * 		- Use scanner class
 * 	- User interface modularized as a View (or Delegate) component
 * 		- initially text based
 * 	- inventory representation will be modularized as a Model
 * 		- will be persistent
 * 		- will be maintained using the Properties class
 * 	- Will make use of: 
 * 		- inheritance - individual items CD, DVD, BOOK, inherit from the inventory class 
 * 		- polymorphism - InvPersistance extends Properties.class, (polymorphism) 
 * 		- interface definition
 * 	- make use of at least one enumeration (enum type) 
 * 
 * 
 * @author Michael Floerchinger
 *
 */

// https://www.youtube.com/watch?v=Lsdaztp3_lw

public class InvMainApp
{
	public static void main (String[] args) throws Exception
	{
		/**
		 * Creates the MVC Objects
		 */		
		InvModel theModel = new InvModel();
		InvController theController = new InvController();	
		InvView theView = new InvView();	
		
		/**
		 * Connects the objects
		 */
		theController.setTheView(theView);
		theController.setTheModel(theModel);
		
		theModel.setTheView(theView);
		theModel.setTheController(theController);

		theView.setTheModel(theModel);
		theView.setTheController(theController);
		
		/**
		 * Starts the application in the View component
		 */
		theView.start();


	}
}