package zTBDassignmentobserverbackupcopy2;

import java.util.Scanner;



public class InvView implements Observer
{

	private InvController theController;
	private InvModel theModel;
	
	// constructor
	public InvView()
	{}
	

	public void start() throws Exception
	{
		
		/*
		 * This will be the UI, "Hi welcome to the inventory system...."
		 * Welcome, would you like to view inventory, CD, DVD, BOOKS, ALL
		 * 
		 * C - Create
		 * R - Read
		 * U - Update
		 * D - Delete
		 */
		this.getStoredValue();
	}	
	
	public void getStoredValue() throws Exception
	{
		/*
		// hardcoded value:
		System.out.println("search for key : value pair, type \"artist\" to search for artist");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		*/
		String input = "name";
		System.out.println("\nInvView:start()getStoredValue:input = " + input);
		theController.getStoredValue(input);
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