package zTBDassignmentobserverbackupcopy2;

import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;

import testing.TestingEnums.ItemType;



public class InvView implements Observer
{
	
	
	static String itemNum;
	static String itemType;
	static String title;
	static String artist;
	static String productCode;
	static String quantity;
	
	static private int menuOption = 0;
	static private boolean showPanel = true;
	static private boolean showMiniPanel = false;
	static private boolean exit = false;
	private Scanner scanner;

	private InvController theController;
	private InvModel theModel;
	
	// constructor
	public InvView()
	{
		
	}
	

	public void start() throws Exception
	{
		scanner = new Scanner(System.in);
		this.startMainMenu();
		

	}	
	
	public void startMainMenu() throws Exception
	{
	
		do 
		{

			// Logic for displaying LARGE or SMALL menu
			if (showPanel == true && showMiniPanel == false)	
			{
				this.menuPanel();
			}
			else if ( showPanel == false && showMiniPanel == true )
			{
				this.miniMenuPanel();

			}
			
			System.out.print("Enter Selection: ");
			menuOption = scanner.nextInt();

			
			if (menuOption < 0 || menuOption > 6 ) 
			{
				
				System.out.println("\n\nATTENTION: \nThe option \"" + menuOption + "\" you selected is not a valid selection" + "\nTry again.");
				
			}
			else
			{
				
				
				switch(menuOption)	
				{
					case 1:
					{
						// Toggle for LARGE or SMALL menu
						if ( showPanel == true )
						{
							showPanel = false;
							showMiniPanel = true;
						}
						else if ( showPanel == false )
						{
							showPanel = true;
							showMiniPanel = false;
						}
						
						// Retrieve complete inventory list
						this.getInventoryList();
						break;
						

					}
					case 2:
					{
						// Retrieve list for single items search
						this.searchForItemDetails();
						break;

					}
					case 3:	// 
					{
						// Create a new inventory item
						this.createNewInventoryItem();
						break;
					}
					case 4:
					{
						// Update the ARTIST in a single inventory item TODO next feature is to update other fields
						this.updateArtistInventoryItem();
						break;
					}
					case 5:
					{
						// Delete an item from inventory
						this.deleteItemFromInventory();
						break;
					}

					case 6:
					{
						// Select to QUIT application
						exit = true;
						break;
					}
				
				}
							
			}
	
		} while ( exit == false);

	}
	
	public void menuPanel()
	{
		// LARGE Menu option
		 System.out.println("\n\n------------------------------------");
	        System.out.println("|    Inventory CRUDi System    !    |");
	        System.out.println("|-----------------------------------|");
	        System.out.println("|                                   |");
	        System.out.println("| Main Menu:                        |");
	        System.out.println("| ----------                        |");
	        System.out.println("|                                   |");
	        System.out.println("| 1.) Retrieve(List) 'all' items!   |");
	        System.out.println("| 2.) Retrieve(List) 'one' item!    |");	
	        System.out.println("| 3.) Create a record!              |");
	        System.out.println("| 4.) Update a record!              |");
	        System.out.println("| 5.) Delete a record!              |");
	        System.out.println("| 6.) Exit!                         |");
	        System.out.println("|                             v 1.0 |");
	        System.out.println("-------------------------------------");
	}
	
	public void miniMenuPanel()
	{
		// SMALL Menu option
		System.out.println("\n-----------------------------------------------");
		System.out.println("| 1.) Display Main Menu\t 2.) List single item ! |");
		System.out.println("| 3.) Create a record! \t 4.) Update a record!   |");
		System.out.println("| 5.) Delete a record! \t 6.) Exit!              |");
		System.out.println("-------------------------------------------------");

	}
	
	

	

	// Retrieve a single item using item number
	public void getDetailsInventoryItem() throws Exception
	{
		System.out.println("List an individual record."
				+ "\nPlease enter the item number & hit <enter> \n");	
		
		String itemType = scanner.nextLine();
		itemNum = scanner.nextLine();
		theController.searchForItemDetails(itemNum);
	}
	
	// READ: List ALL
	public void getInventoryList() throws IOException
	{
		theController.getInventoryList();
		System.out.println(theModel.listInventoryView);

	}
	

	
	
	// UPDATE:
	public void updateArtistInventoryItem() throws Exception
	{
		// TODO: change to I can also update title
		Scanner scanner = new Scanner(System.in);

		System.out.println("UPDATE the ARTIST for item number."
				+ "\nPlease enter item number & hit <enter>\nItem Number: ");
		
		String itemNum = scanner.nextLine();
		
		theController.searchForItemDetails(itemNum);
		System.out.println(InvModel.listInventoryView);
		
//		this.displayResults();
		
		System.out.println("Enter the new ARTIST name you wish to update: ");
		String artist = scanner.nextLine();
		theController.updateArtistInventoryItem(itemNum, artist);
		System.out.println(InvModel.listInventoryView);

		
	}
	
	// CREATE:
	public void createNewInventoryItem() throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("CREATE a NEW inventory record."
				+ "\nEnter the item details & hit <enter> for each item\n"
				+ "To start, enter type of item: CD, DVD, BOOK\nItem Type: ");	// TODO: implement ENUMS here
		String itemType = scanner.nextLine().toUpperCase();
		
		System.out.println("Title: ");
		String title = scanner.nextLine();
		
		System.out.println("Artist: ");
		String artist = scanner.nextLine();
		
		System.out.println("ProductCode: ");
		String productCode = scanner.nextLine();
		
		System.out.println("Quantity:");
		String quantity = scanner.nextLine();
		
		theController.createNewInventoryItem(itemType, title, artist, productCode, quantity);
		System.out.println(theModel.listInventoryView);
		
	}
	
	// DELETE:
	public void deleteItemFromInventory() throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("DELETE an item number from the inventory."
				+ "\nEnter item number & hit <enter>\nItem Number: ");
		
		String itemNum = scanner.nextLine();

		theController.deleteItemFromInventory(itemNum);
		System.out.println(theModel.listInventoryView);
	}
	
	// READ: List Single
	public void searchForItemDetails() throws Exception
	{
		
		System.out.println("READ: Search for item number to get item details."
				+ "\nPlease enter item number & hit <enter>\nItem Number: ");
		Scanner scanner = new Scanner(System.in);
		String itemNum = scanner.nextLine();
		
		theController.searchForItemDetails(itemNum);
		this.displayResults();
	}
	




	@Override
	public void update(String name, String title, String number) {
		// TODO Auto-generated method stub
		
	}
	
	// setters and getters for the MVC objects
	public InvController getTheController() {
		return theController;
	}

	public void setTheController(InvController theController) {
		this.theController = theController;
	}

	public InvModel getTheModel() {
		return theModel;
	}

	public void setTheModel(InvModel theModel) {
		this.theModel = theModel;
	}
	
	/////////////////////////////////////////////////////////////////////////
	//// Unused methods for Next Generation of this app /////////////////////
	/////////////////////////////////////////////////////////////////////////
	
	// NOT USED
	public void chooseType(ItemType itemType) throws IOException
	{
        // TODO Create a menu options for selecting specific content 
		switch (itemType)
        {
        	case CD : 
        		System.out.println("Chose: CD: \t" + "MVP: not yet implemented");
        		theController.getInventoryList();
			    System.out.println(theModel.listInventoryView);
        	break;
        	case DVD : 
        		System.out.println("Chose: DVD: \t" + "MVP: not yet implemented");
        		theController.getInventoryList();
			    System.out.println(theModel.listInventoryView);
        	break;
        	case BOOKS : 
        		System.out.println("Chose: Books: \t" + "MVP: not yet implemented");
        		theController.getInventoryList();
			    System.out.println(theModel.listInventoryView);
        	break;
        	case ALL : 
        		System.out.println("Chose: ALL: \t" + "MVP: not yet implemented");
			    theController.getInventoryList();
			    System.out.println(theModel.listInventoryView);
    		break;
        }
        
	}
	

	// used to retrieve and display results from theModel instance variables
	public void displayResults()
	{
		itemNum = theModel.getItemNum();
		itemType = theModel.getItemType();
		title = theModel.getTitle();
		artist = theModel.getArtist();
		productCode = theModel.getProductCode();
		quantity = theModel.getQuantity();

	}


	
}