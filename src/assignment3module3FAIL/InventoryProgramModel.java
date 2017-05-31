package assignment3module3FAIL;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
  	
	private String listInventoryViewALL;		
	private String listInventoryViewSingle;	
	
	private ResultSet resultSet;
	private ResultSetMetaData metaData;

	
	private Boolean updatedView;
	
	// constructor
	public InventoryProgramModel() throws Exception {
		super();
		thePersistance = new InventoryProgramDatabaseInterface(this);
	}
	
	
	///// Methods for Inventory Store Operations///////
	
	
	@Override
	public void getItems() throws Exception {
		thePersistance.getInventoryALL();		
	}


	@Override
	public void getItem(String itemNum) throws Exception {
		thePersistance.getInventorySingle(itemNum);		
	}


	@Override
	public void addItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception {
		thePersistance.createNewInventorySelectType(itemType, title, artist, productCode, quantity);		
	}


	@Override
	public void editItem(String itemNum, String artist) throws Exception {
		thePersistance.updateArtistInventoryItem(itemNum, artist);		
	}


	@Override
	public void deleteItem(String itemNum) throws Exception {
		thePersistance.deleteItemFromInventory(itemNum);	
		
	}
	
	public void setViewUpdated()
	{
		updatedView = true;
	}
	
	public void setViewRetrieved()
	{
		updatedView = false;
	}
	
	public ResultSetMetaData getMetaData() {
		return metaData;
	}
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	// Observer return buffers
	public void notifyInventoryViewALL() {
//		this.listInventoryViewALL = listInventoryViewALL;
		if (updatedView == true)
		{
			resultSet = thePersistance.getResultSet();
			metaData = thePersistance.getMetaData();
			this.setObserverState();
			System.out.println("Model:setting resultSet " + getUpdatedView());
		}
		else
		{
			updatedView = false;
			System.out.println(getUpdatedView());
		}
		
		
	}
	
	public void listInventoryViewSingle(String listInventoryViewSingle) {
		this.listInventoryViewSingle = listInventoryViewSingle;
//		this.setObserverState(listInventoryViewSingle);
		this.setObserverState();
	}
	
	public Boolean getUpdatedView()
	{
		return updatedView;
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