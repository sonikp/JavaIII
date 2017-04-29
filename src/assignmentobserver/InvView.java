package assignmentobserver;

import java.util.HashMap;
import java.util.Map;
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
	
	

	private InvController theController;
	private InvModel theModel;
	
	// constructor
	public InvView()
	{
		System.out.print("view:");
	}
	

	public void start() throws Exception
	{
		
		/*
		 * This will be the UI, "Hi welcome to the inventory system...."
		 * (while loop X = true continue) = needs to close out and write to disk
		 * Welcome, would you like to 
		 * (1) List/(view) inventory, CD, DVD, BOOKS, ALL
		 * (2) edit
		 * 
		 * C - Create => V
		 * R - Read	=> V
		 * U - Update
		 * D - Delete => V
		 */
		
//		this.searchForItemDetails();	//
//		this.deleteItemFromInventory();
//		this.createNewInventoryItem();
//		this.updateArtistInventoryItem();
//		this.getInventoryList();

	}	
	
	public void startUIGreeting()
	{
		System.out.println("Welcome to the inventory system....");

	}
	
	public enum ItemType { CD,DVD,BOOKS,ALL	};
	
	public void getInventoryList()
	{
		Scanner input = new Scanner(System.in);

		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("LIST items Press 1,2,3,4 to view inventory items" 
				+ "\nCD list, DVD list, BOOK, List ALL"
				+ "\nPlease enter NAME & hit <enter>\nItem Type: ");
		

		ItemType itemType = ItemType.valueOf(input.next().toUpperCase().toString());
		System.out.println(itemType);
		this.chooseType(itemType);
		
	}
	
	public void chooseType(ItemType itemType)
	{
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

		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("UPDATE the TITLE for item number."
				+ "\nPlease enter item number & hit <enter>\nItem Number: ");
		
		String itemNum = scanner.nextLine();
		
		theController.searchForItemDetails(itemNum);
		this.displayResults();
		System.out.println("Enter the new ARTIST name you wish to update: ");
		String artist = scanner.nextLine();
		theController.updateArtistInventoryItem(itemNum, artist);
		
	}
	
	// CREATE:
	public void createNewInventoryItem() throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("CREATE a NEW number in the inventory."
				+ "\nPlease enter the item details & hit <enter>\nItem Type: "
				+ "1 for CD, 2 for DVD, 3 for BOOK");	// TODO: implement ENUMS here
		String itemType = scanner.nextLine();
		
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
		itemNum = theModel.itemNum;
		itemType = theModel.itemType;
		title = theModel.title;
		artist = theModel.artist;
		productCode = theModel.productCode;
		quantity = theModel.quantity;
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