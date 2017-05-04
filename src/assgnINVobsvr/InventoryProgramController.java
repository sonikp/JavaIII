package assgnINVobsvr;

import java.io.IOException;

public class InventoryProgramController
{
	
	private InventoryProgramView theView;
	private InventoryProgramModel theModel;
	
	// constructor
	public InventoryProgramController(){}
	
	
	///// Methods/////////OK///////

	// LIST ALL ITEMS
	public void getInventoryALL() throws Exception {
//		theModel.getInventoryALL();
		theModel.getItems();
		
	}

	// LIST SINGLE ITEM
	public void getInventorySingle(String itemNum) throws Exception {
		theModel.getItem(itemNum);
		
	}
	
	// CREATE NEW ITEM
	public void createNewInventoryItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception {
		theModel.addItem(itemType, title, artist, productCode, quantity);
	}
	
	// UPDATE ITEM WITH ARTIST 
	public void updateArtistItemByNum(String itemNum, String artist) throws Exception {
		theModel.editItem(itemNum, artist);	
	}
	

	
	// DELETE ITEM BY NUM 
	public void deleteItemByNum(String itemNum) throws Exception {
		theModel.deleteItem(itemNum);	
	}

	///// Methods/////////OK///////
	
	
	
//	public void testObserver(int number){
//		theModel.testObserver(number);
//	}
//	
//	public void testObserverString(String valueString){
//		theModel.testObserverString(valueString);
//	}
	
	
	
	// MVC setters and getters
	public void setTheView(InventoryProgramView theView) {
		this.theView = theView;	
	}
	
	public InventoryProgramView getTheView(){
		return theView;
	}

	public void setTheModel(InventoryProgramModel theModel) {
		this.theModel = theModel;		
	}
	
	public InventoryProgramModel getTheModel(){
		return theModel;
	}




	
}