package zTBDassignmentobserver1;

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
	static private boolean anotherChoice = true;
	static private boolean exit = false;
	private Scanner scanner;

	private InvController theController;
	private InvModel theModel;
	
	// constructor
	public InvView()
	{
		System.out.print("view:");
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

			
			if (anotherChoice == true)
			{
//				this.menuPanel();
				System.out.print("Enter Selection: ");
				menuOption = scanner.nextInt();

				
				if (menuOption < 0 || menuOption > 6) 
				{
					
					System.out.println("\n\nATTENTION: \nThe option \"" + menuOption + "\" you selected is not a valid selection" + "\nTry again.");
					anotherChoice = true;
				}
				else
				{
					
					
					switch(menuOption)	
					{
						case 1:
						{
							this.createNewInventoryItem();
							break;
						}
						case 2:
						{
							System.out.println("\nRetrieve (List) ALL " + menuOption);
							this.getInventoryList();
							break;
						}
						case 3:
						{
							System.out.println("\nRetrieve (List) ONE " + menuOption);
							this.getDetailsInventoryItem();
							break;
						}
						case 4:
						{
							System.out.println("\nUpdate " + menuOption);
							this.updateArtistInventoryItem();
							break;
						}
						case 5:
						{
							System.out.println("\nDelete " + menuOption);
							this.deleteItemFromInventory();
							break;
						}
						case 6:
						{
							System.out.println("\nQuit " + menuOption);
							exit = true;
							break;
						}
					
					}
					
					
				}

			}
			
		} while ( exit == false);

		
	}
	
	public void menuPanel()
	{
		 System.out.println("\n\n------------------------------------");
	        System.out.println("|    Inventory CRUD System     !    |");
	        System.out.println("|-----------------------------------|");
	        System.out.println("|                                   |");
	        System.out.println("| Main Menu:                        |");
	        System.out.println("| ----------                        |");
	        System.out.println("|                                   |");
	        System.out.println("| 1.) Create a record!              |");
	        System.out.println("| 2.) Retrieve(List) 'all' items!   |");
	        System.out.println("| 3.) Retrieve(List) 'one' item!    |");
	        System.out.println("| 4.) Update a record!              |");
	        System.out.println("| 5.) Delete a record!              |");
	        System.out.println("| 6.) Exit!                         |");
	        System.out.println("|                             v 1.0 |");
	        System.out.println("-------------------------------------");
	}
	

	

	
	public void getDetailsInventoryItem() throws Exception
	{
		System.out.println("List an individual record."
				+ "\nPlease enter the item number & hit <enter> \n");	
		String itemType = scanner.nextLine();
		itemNum = scanner.nextLine();
		theController.searchForItemDetails(itemNum);
	}
	
	public void getInventoryList() throws IOException
	{
		theController.getInventoryList();
		System.out.println(theModel.listInventoryView);
		/*
		Scanner input = new Scanner(System.in);

		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("LIST items Press 1,2,3,4 to view inventory items" 
				+ "\nCD list, DVD list, BOOK, List ALL"
				+ "\nPlease enter NAME & hit <enter>\nItem Type: ");
		

		ItemType itemType = ItemType.valueOf(input.next().toUpperCase());
		System.out.println(itemType);
		this.chooseType(itemType);
		*/
	}
	
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
	
	
	// UPDATE:
	public void updateArtistInventoryItem() throws Exception
	{
		// TODO: change to I can also update title
		Scanner scanner = new Scanner(System.in);

		System.out.println("UPDATE the TITLE for item number."
				+ "\nPlease enter item number & hit <enter>\nItem Number: ");
		
		String itemNum = scanner.nextLine();
		
		theController.searchForItemDetails(itemNum);
//		this.displayResults();
//		System.out.println("Enter the new ARTIST name you wish to update: ");
//		String artist = scanner.nextLine();
//		theController.updateArtistInventoryItem(itemNum, artist);
		
	}
	
	// CREATE:
	public void createNewInventoryItem() throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("CREATE a NEW number in the inventory."
				+ "\nPlease enter the item details & hit <enter> for each item\n"
				+ "For Item Type, enter, CD, DVD, BOOK\nItem Type: ");	// TODO: implement ENUMS here
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
		
	}
	
	// DELETE:
	public void deleteItemFromInventory() throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("DELETE an item number from the inventory."
				+ "\nPlease enter item number & hit <enter>\nItem Number: ");
		
		String input = scanner.nextLine();
		
//		String input = "300";
		System.out.println("\nInvView:start()deleteItemFromInventory:input = " + input);
		theController.deleteItemFromInventory(input);
	}
	
	// READ:
	public void searchForItemDetails() throws Exception
	{
		
		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("READ: Search for item number to get item details."
				+ "\nPlease enter item number & hit <enter>\nItem Number: ");
		Scanner scanner = new Scanner(System.in);
		String itemNum = scanner.nextLine();
		
//		String input = "101";
		System.out.println("\nInvView:start()searchForItemDetails:input = " + itemNum);
		theController.searchForItemDetails(itemNum);
		this.displayResults();
	}
	
	public void displayResults()
	{
		itemNum = theModel.getItemNum();
		itemType = theModel.getItemType();
		title = theModel.getTitle();
		artist = theModel.getArtist();
		productCode = theModel.getProductCode();
		quantity = theModel.getQuantity();
		System.out.println("**VIEW**ItemNumber: " + itemNum + ", ItemType: " + itemType + ", Title: " + title + ", Artist: " + artist + ", ProductCode: " + productCode + ", Quantity: " + quantity);
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
	
	
	
	


	
}