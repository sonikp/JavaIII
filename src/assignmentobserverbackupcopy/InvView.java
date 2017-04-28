package assignmentobserverbackupcopy;

import java.util.Scanner;



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
	{}
	

	public void start() throws Exception
	{
		
		/*
		 * This will be the UI, "Hi welcome to the inventory system...."
		 * (while loop X = true continue) = needs to close out and write to disk
		 * Welcome, would you like to 
		 * (1) view inventory, CD, DVD, BOOKS, ALL
		 * (2) edit
		 * 
		 * C - Create => V
		 * R - Read	=> V
		 * U - Update
		 * D - Delete => V
		 */
//		this.searchForItemDetails();	//
//		this.deleteItemFromInventory();
//		this.createInventoryItem();
		this.updateArtistInventoryItem();
	}	
	
	
	// UPDATE:
	public void updateArtistInventoryItem() throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("UPDATE the TITLE for item number."
				+ "\nPlease enter item number & hit <enter>\nItem Number: ");
		
		String itemNum = scanner.nextLine();
		
		theController.searchForItemDetails(itemNum);
		this.displayResults();
		System.out.println("Enter the new ARTIST name you wish to update: ");
		String artist = scanner.nextLine();
		theController.updateArtistInventoryItem(artist);
		
	}
	
	// CREATE:
	public void createInventoryItem() throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\n--------------Inventory System--------------");
		System.out.println("CREATE a NEW number in the inventory."
				+ "\nPlease enter the item details & hit <enter>\nItem Type: "
				+ "1 for CD, 2 for DVD, 3 for BOOK");	// implement ENUMS here
		String itemType = scanner.nextLine();
		
		System.out.println("Title: ");
		String title = scanner.nextLine();
		
		System.out.println("Artist: ");
		String artist = scanner.nextLine();
		
		System.out.println("ProductCode: ");
		String productCode = scanner.nextLine();
		
		System.out.println("Quantity:");
		String quantity = scanner.nextLine();
		
		theController.createInventoryItem(itemType, title, artist, productCode, quantity);
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//==========================Old Shit=============================
	
	/*
	
	
		private JTextField prodNumber  = new JTextField(10);
	private JButton setNumberButton = new JButton("Add Number");
//	InvController theController = new InvController();
	InvModel theModel = new InvModel();
	
	
	
	
			System.out.println("access backend DB");
		System.out.println("-----------------");
//		Scanner scanner = new Scanner(System.in);
//		String keyName = scanner.nextLine();
		
		String db = "cdInfos";
		String element = "4";
		System.out.println(db + " " + element);
		theModel.accessRecord(db,element);
	
	
	*/
	
		/*
		// - Select items
		System.out.println("which inventory would you like to view");
		System.out.println("1 = CD, 2 = DVD, 3 = BOOKS, 4 = All Items");
		Scanner scanner = new Scanner(System.in);
		String keyName = scanner.nextLine();
		*/
		
		/*
		System.out.println("enter item to delete");
		Scanner scanner = new Scanner(System.in);
		String keyName = scanner.nextLine();
		System.out.println(keyName);
		theModel.searchKey(keyName);
		*/
		
		/*
		// search for a value pair with a key
		System.out.println("enter search item");
		Scanner scanner = new Scanner(System.in);
		String keyName = scanner.nextLine();
		System.out.println(keyName);
		String returnValue = theModel.searchKey(keyName);
		System.out.println("Result for search: " + returnValue);
		*/
		
		/*
		// change an item number
		System.out.println("enter number");
		Scanner scanner = new Scanner(System.in);
		String prodNumb = scanner.nextLine();
		
		System.out.println("Debug:theView:prodNum :" + prodNumb);
		theModel.setNumber(prodNumb);
		*/


	
	
	/*
	// currently not doing anytihing
	public String getProdNumber()
	{
		

		return prodNumber.getText();
	}
	*/
	
	
	/*
	void addNumberListener(ActionListener listenForAddItemButton)
	{
		
		setNumberButton.addActionListener(listenForAddItemButton);
		
	}
	*/


	
}