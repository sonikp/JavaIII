package assignment3module3;






public class InventoryProgramModel extends Subject implements InventoryProgramStoreOperations
{
	
	private InventoryProgramView theView;
	private InventoryProgramController theController;
	private InventoryProgramDatabaseInterface thePersistance;
	
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
	

	
	// Observer notify view changed
	public void observerNotifyViewChanged() {
		this.setObserverState();
	}
	

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
	


}