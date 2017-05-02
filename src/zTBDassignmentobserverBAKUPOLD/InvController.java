package zTBDassignmentobserverBAKUPOLD;

import java.io.IOException;

public class InvController
{
	
	private InvModel theModel;
	private InvView theView;
	
	// constructor
	public InvController()
	{
		
	}
	
	// LIST_ALL:
	public void getInventoryList() throws IOException
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

		theModel.updateArtistInventoryItem(itemNum, artist);
		
	}
	
	
	// READ:
	public void searchForItemDetails(String itemNum) throws Exception 
	{

		theModel.searchForItemDetails(itemNum);
		
	}
	
	//DELETE:
	public void deleteItemFromInventory(String itemNum) throws Exception 
	{


		theModel.deleteItemFromInventory(itemNum);
		
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