package zTBDassignmentobserver1;

import java.io.IOException;

public class InvModel implements Subject
{
	private static String itemNum;
	private static String itemType;
	static String title;
	private static String artist;
	private static String productCode;
	private static String quantity;
	
	static String listInventoryView;
	static String listInventoryItemView;
	
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
	public void getInventoryList() throws IOException
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
		
		thePersistance.createNewInventorySelectType(itemType, title, artist, productCode, quantity);
//		thePersistance.createNewInventoryItem(itemType, title, artist, productCode, quantity);
	}
	
	// READ:
	public void searchForItemDetails(String itemNum) throws Exception 
	{
		
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

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) 
	{
		System.out.println("DEBUG*** UPDATE*** " + itemNum);
		this.itemNum = itemNum;
	}

	public static String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public static String getTitle() {
		return title;
	}

	public void setTitle(String title) 
	{
		System.out.println("DEBUG*** UPDATE*** " + title);
		this.title = title;
	}

	public static String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public static String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public static String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	
	

}