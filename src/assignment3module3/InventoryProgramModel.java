package assignment3module3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class InventoryProgramModel extends Subject implements InventoryProgramStoreOperations
{
	
	private InventoryProgramView theView;
	private InventoryProgramController theController;
//	private InventoryProgramPersistance thePersistance;
	private InventoryProgramDatabaseInterface thePersistance;
	
//	private List<Observer> observers = new ArrayList<>();
//  private int state;
  	
//	private String listInventoryViewALL;		
//	private String listInventoryViewSingle;		
	



	// constructor
	public InventoryProgramModel() throws Exception {
		super();
		thePersistance = new InventoryProgramDatabaseInterface();
	}
	
	
	///// Methods for Inventory Store Operations///////
	
	public InventoryProgramDatabaseInterface getTableModel() {
		return thePersistance;
	}
	
	@Override
	public void getItems() throws Exception {
		thePersistance.getInventoryALL();
		observerNotifyViewChanged();
	}


	@Override
	public void getItem(String itemNum) throws Exception {
		thePersistance.getInventorySingle(itemNum);	
		observerNotifyViewChanged();
	}


	@Override
	public void addItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception {
		thePersistance.createNewInventorySelectType(itemType, title, artist, productCode, quantity);
		observerNotifyViewChanged();
	}


	@Override
	public void editItem(String itemNum, String artist) throws Exception {
		thePersistance.updateArtistInventoryItem(itemNum, artist);
		observerNotifyViewChanged();
	}


	@Override
	public void deleteItem(String itemNum) throws Exception {
		thePersistance.deleteItemFromInventory(itemNum);
		observerNotifyViewChanged();
		
	}
	

	
//	// Observer notify view changed
	public void observerNotifyViewChanged() {
		this.setObserverState();
	}
	
	/*
	/// These are obsolete from the old code
	public void listInventoryViewALL(String listInventoryViewALL) {
//		this.listInventoryViewALL = listInventoryViewALL;	
		this.setObserverState(listInventoryViewALL);
	}
	
	public void listInventoryViewSingle(String listInventoryViewSingle) {
//		this.listInventoryViewSingle = listInventoryViewSingle;
		this.setObserverState(listInventoryViewSingle);
	}
	*/
	



	///////////////////////////////
	// MVC setters and getters
	public void setTheController(InventoryProgramController theController) {
		this.theController = theController;
	}
	
	public InventoryProgramController getTheController(){
		return theController;
	}
	
	public void setTheView(InventoryProgramView theView) {
		this.theView = theView;	
	}
	
	public InventoryProgramView getTheView(){
		return theView;
	}
	
	/*
	// Database Layer setters and getters
	public InventoryProgramDatabaseInterface getThePersistance() {
		return thePersistance;
	}


	public void setThePersistance(InventoryProgramDatabaseInterface thePersistance) {
		this.thePersistance = thePersistance;
	}
	*/

}