package zTBDassignmentobserverbackupcopy1;


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

	
	

}