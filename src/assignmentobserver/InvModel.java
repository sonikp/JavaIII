package assignmentobserver;



public class InvModel implements Subject
{
	static String itemNum;
	static String itemType;
	static String title;
	static String artist;
	static String productCode;
	static String quantity;
	
	private InvView theView;
	private InvController theController;
	private InvPersistance thePersistance; 
	

	
	// BS Debug
	private String constStartModel = "constStartModel:";
	
	// constructors	
	public InvModel() throws Exception
	{
		thePersistance = new InvPersistance();
		this.thePersistance = thePersistance;
	}
	
	// UPDATE:
	public void updateArtistInventoryItem(String artist) throws Exception 
	{
		System.out.println("DBug:Ctrlr:updateArtistInventoryItem:artist;  " + artist);
		thePersistance.updateArtistInventoryItem(artist);
		
	}
	
	
	// CREATE
	public void createInventoryItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		thePersistance.createInventoryItem(itemType, title, artist, productCode, quantity);
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//==========================Old Shit=============================
	
	
//	String valueItem;
//	private int calculationValue;

	/*
	public void deleteKeyValue(String keyName) 
	{

		try 
		{
//			System.out.println("Debug:theModel:setNum: number = " + number);
//			dataStore.writeDataStream(number);
			dataStore.readDataElement(keyName);	// testing read method
			System.out.println("Debug:theModel:searchKey: key = " + keyName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String searchKey(String keyName) 
	{

		try 
		{

			valueItem = dataStore.readDataElement(keyName);	// testing read method
			System.out.println("Debug:theModel:searchKey: key = " + keyName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Debug:theModel:searchKey: returnValue = " + valueItem);
		return valueItem;
	}
	
	public void accessRecord(String db, String number) 
	{

		try {
			System.out.println("Debug:theModel:accessRecord: db " + db + " number = " + number);
			dataStore.readDataTable(db, number);
//			dataStore.writeDataStream(number);
//			dataStore.readDataStream(number);	// testing read method
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	*/
	/*
	
	public void setNumber(String number) 
	{

		try {
			System.out.println("Debug:theModel:setNum: number = " + number);
			dataStore.writeDataStream(number);
			dataStore.readDataStream(number);	// testing read method
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNumber()
	{
		return dataStore.getProdID();
	}
	
	*/
	


	
}