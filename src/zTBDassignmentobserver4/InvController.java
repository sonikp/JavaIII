package zTBDassignmentobserver4;


public class InvController
{
	
	private InvModel theModel;
	private InvView theView;
	
	// constructor
	public InvController()
	{
		System.out.print("controller:");
	}
	
	// LIST_ALL:
	public void getInventoryList()
	{
		theModel.getInventoryList();
	}
	
	// CREATE:
	public void createNewInventoryItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		theModel.createNewInventoryItem(itemType, title, artist, productCode, quantity);
	}
	
	// UPDATE:
	public void updateArtistInventoryItem(String itemNum, String artist) throws Exception 
	{
		System.out.println("DBug:Ctrlr:updateArtistInventoryItem:itemNum&artist;  " + itemNum + ", " + artist);
		theModel.updateArtistInventoryItem(itemNum, artist);
		
	}
	
	
	// READ:
	public void searchForItemDetails(String itemNum) throws Exception 
	{
		System.out.println("DBug:Ctrlr:getStoredValue:input;  " + itemNum);
		theModel.searchForItemDetails(itemNum);
		
	}
	
	//DELETE:
	public void deleteItemFromInventory(String input) throws Exception 
	{
		System.out.println("DBug:Ctrlr:deleteItemFromInventory():input;  " + input);
		theModel.deleteItemFromInventory(input);
		
	}
	
	// setters and getters for the MVC objects
	public InvModel getTheModel() {
		return theModel;
	}


	public void setTheModel(InvModel theModel) {
		this.theModel = theModel;
	}


	public InvView getTheView() {
		return theView;
	}


	public void setTheView(InvView theView) {
		this.theView = theView;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//==========================Old Shit=============================
	/*
	
	public enum ItemType 
	{
		Angie_Stone ("cd", "Black Diamond", "LS5784", 15.22, 7), 
		Alice_Russell ("dvd", "Fly In The Hand", "TBM345984", 13.67, 9),
		Bill_Withers ("cd", "Still Bill", "T-39GG5784", 11.21, 1),
		Bootsy_Collins ("book", "Play With Bootsy", "ERT945864", 17.96, 5),
		James_Brown ("cd", "Cold Sweat", "WW4095604", 23.96, 6);
	

		private String itemType;
		private String title;
		private String productID; 
		private double unitPrice;
		private int unitsInStock;

		private ItemType(String itemType, String title, String productID, double unitPrice, int unitsInStock) 
		{
			this.itemType = itemType;
			this.title = title;
			this.productID = productID;
			this.unitPrice = unitPrice;
			this.unitsInStock = unitsInStock;
		}

	}
	
	*/
	
	
	
	
	/*
	public InvController()
	{
		// empty constructor
	}
	*/
	

	
	

/*
	class AddItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String prodNumber;
			try
			{
//				prodNumber = theView.getProdNumber();
//				theModel.setNumber(prodNumber);
				//theModel.setNumber(theView.getProdNumber()); //removed listener not implemented for a commandline app
//				System.out.println("Debug:Controller+addListener: " + prodNumber);
			}
			catch (NumberFormatException ex)
			{
				System.out.println(ex);
				
			}
		}
	}
	*/

}