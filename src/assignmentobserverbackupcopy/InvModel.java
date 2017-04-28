package assignmentobserverbackupcopy;



public class InvModel implements Subject
{
	static String itemNum;
	static String itemType;
	static String title;
	static String artist;
	static String productCode;
	static String quantity;
	
	static String listInventoryView;
	
	private InvView theView;
	private InvController theController;
	private InvPersistance thePersistance; 
	private StringBuilder listBuffer;
	

	
	// BS Debug
	private String constStartModel = "constStartModel:";
	
	// constructors	
	public InvModel() throws Exception
	{
		System.out.print("model:");
		thePersistance = new InvPersistance();
		this.thePersistance = thePersistance;
	}
	
	// LIST_ALL:
		public void getInventoryList()
		{
			thePersistance.listAllInventoryItems();
		}
	
	// UPDATE:
	public void updateArtistInventoryItem(String itemNum, String artist) throws Exception 
	{
		System.out.println("DBug:Ctrlr:updateArtistInventoryItem:itemNum&artist;  " + itemNum + ", " + artist);
		thePersistance.updateArtistInventoryItem(itemNum, artist);
		
	}
	
	
	// CREATE
	public void createNewInventoryItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		thePersistance.createNewInventoryItem(itemType, title, artist, productCode, quantity);
	}
	
	// READ:
	public void searchForItemDetails(String itemNum) throws Exception 
	{
		System.out.println("DBug:Mdl:getStoredValue:input; " + itemNum);
		thePersistance.testMessage();
		thePersistance.searchForItemDetails(itemNum);

	}
	
	//DELETE:
	public void deleteItemFromInventory(String input) throws Exception 
	{
		System.out.println("DBug:Mdl:getStoredValue:input; " + input);
		thePersistance.testMessage();
		thePersistance.deleteItemFromInventory(input);

	}

	public void updateItem() 
	{
		System.out.println("updateItem()");

	}

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	// setters and getters for the MVC objects
	public InvView getTheView() {
		return theView;
	}

	public void setTheView(InvView theView) {
		this.theView = theView;
	}

	public InvController getTheController() {
		return theController;
	}

	public void setTheController(InvController theController) {
		this.theController = theController;
	}

	public InvPersistance getThePersistance() {
		return thePersistance;
	}

	public void setThePersistance(InvPersistance thePersistance) {
		this.thePersistance = thePersistance;
	}

	
	

}