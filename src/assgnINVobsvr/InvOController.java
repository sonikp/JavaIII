package assgnINVobsvr;

import java.io.IOException;

public class InvOController
{
	
	private InvOView theView;
	private InvOModel theModel;
	
	// constructor
	public InvOController(){}
	
	
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
//		System.out.println(itemType + title + artist + productCode + quantity);
		theModel.addItem(itemType, title, artist, productCode, quantity);
	}
	
	// UPDATE ARTIST ON ITEM
	public void updateArtistInventoryItem(String itemNum, String artist) throws Exception 
	{

//		theModel.updateArtistInventoryItem(itemNum, artist);
		
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
	public void setTheView(InvOView theView) {
		this.theView = theView;	
	}
	
	public InvOView getTheView(){
		return theView;
	}

	public void setTheModel(InvOModel theModel) {
		this.theModel = theModel;		
	}
	
	public InvOModel getTheModel(){
		return theModel;
	}




	
}