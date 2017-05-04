package assigment1module1BKUP;

import java.util.Scanner;

import assignmentobserver.InvModel;

public class InventoryProgramView extends Observer
{

	private InventoryProgramController theController;
	private InventoryProgramModel theModel;
	
	private Scanner scanner;
	private String itemNum;
	private String itemType;
	private String title;
	private String artist;
	private String productCode;
	private String quantity;
	
	private String prompt = "\n#: ";
	
	private int menuOption = 0;
	static private boolean exit = false;
	
	
	// default constructor
	public InventoryProgramView(){}
	
	public InventoryProgramView(InventoryProgramModel theModel) {
		this.subject = theModel;
		this.theModel.add(this);
	}
	
	
	public void start() throws Exception {

		scanner = new Scanner(System.in);
		this.startMainMenu();
	}
	
	public void startMainMenu() throws Exception {
		do 
		{

			this.mainMenu();
			menuOption = scanner.nextInt();

			
			if (menuOption < 0 || menuOption > 6 ) 
			{
				
				System.out.println("\nATTENTION: The option \"" + menuOption + "\" you selected is not a valid selection" + "\nTry again.\n\n");
				
			}
			else
			{	
				switch(menuOption)	
				{
					case 1:
					{
						// Retrieve ALL inventory list
						theController.getInventoryALL();
						break;
					}
					
					case 2:
					{
						// Retrieve SINGLE inventory list
						this.getItemNumber();
						theController.getInventorySingle(itemNum);
						break;
					}
					
					case 3:	// 
					{
						// Create a new inventory item
						this.createNewInventoryItem();
						theController.createNewInventoryItem(itemType, title, artist, productCode, quantity);
						break;
					}
					
					case 4:
					{						
						// Update the ARTIST in a single inventory item TODO next feature is to update other fields
						this.getItemNumber();
						theController.getInventorySingle(itemNum);				
						this.updateArtist();
						theController.updateArtistItemByNum(itemNum, artist);
						break;
					}
					
					case 5:
					{
						// Delete an item from inventory
						this.getItemNumber();
						theController.deleteItemByNum(itemNum);
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
		System.out.println("Thank you.");

	}
	
	


	////////////////View Methods//////////////////////////////
	
	public void mainMenu(){
		System.out.println("------------------Inventory System------------------------------");
		System.out.println("| Enter Selection: 1 = LIST (ALL), 2 = LIST (Item), 3 = CREATE |");
		System.out.print("| \t\t   4 = UPDATE, 5 = DELETE, 6 = QUIT            |\n");
		System.out.print("----------------------------------------------------------------");
		System.out.print(prompt);
	}
	
	
	public String getItemNumber() {	
		scanner = new Scanner(System.in);
		System.out.print("\nPlease enter item number you wish to view");
		System.out.print(prompt);
		itemNum = scanner.nextLine();
		return itemNum;
	}
	
	// CREATE:
	public void createNewInventoryItem() throws Exception {
		scanner = new Scanner(System.in);

		System.out.println("CREATE a NEW inventory record."
				+ "\nEnter the item details & hit <enter> for each item\n"
				+ "To start, enter type of item: CD, DVD, BOOK");	// TODO: implement ENUMS here
		System.out.print(prompt);
		itemType = scanner.nextLine().toUpperCase();
		
		System.out.print("\nTitle: ");
		System.out.print(prompt);
		title = scanner.nextLine();
		
		System.out.print("\nArtist: ");
		System.out.print(prompt);
		artist = scanner.nextLine();
		
		System.out.print("\nProductCode: ");
		System.out.print(prompt);
		productCode = scanner.nextLine();
		
		System.out.print("\nQuantity:");
		System.out.print(prompt);
		quantity = scanner.nextLine();
	}
	
	// UPDATE:
	public String updateArtist() throws Exception {
		System.out.print("\nEnter the new ARTIST name you wish to update: ");
		System.out.print(prompt);
		artist = scanner.nextLine();
		return artist;
	}

	// Observer pattern update method
	public void update(){
		System.out.println("Observer Update \n" + theModel.getObserverState());
	}
	
	// MVC setters and getters
	public void setTheModel(InventoryProgramModel theModel) {
		this.theModel = theModel;
	}
	
	public InventoryProgramModel getTheModel() {
		return theModel;	
	}

	public void setTheController(InventoryProgramController theController) {
		this.theController = theController;	
	}
	
	public InventoryProgramController getTheController() {
		return theController;	
	}





	
}