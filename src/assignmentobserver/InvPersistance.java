package assignmentobserver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import testing.TestingEnums.ItemType;


public class InvPersistance extends Properties 
{
	static private String itemType;
	static private String title;
	static private String artist;
	static private String productCode;
	static private String quantity;
	static private String cdNextItemNum;
	static private String dvdNextItemNum;
	static private String bookNextItemNum;
	
	public enum ItemType { CD,DVD,BOOK };
	
	
	static String itemDetails[];
	static String listInventoryView;
	
	private static InvModel theModel;
	private static Properties propertiesTable;
	private static String propertiesFilename = "StoredInventory.properties";
	private StringBuilder listBuffer;



	// constructors
	public InvPersistance() throws Exception
	{
		
		propertiesTable = new Properties();
		
		// Check to see if properties file already exists, if not create it
		File fileExistsOnDisk = new File(propertiesFilename);
		
		if (!fileExistsOnDisk.exists())
		{
			OutputStream outputFile = new FileOutputStream(propertiesFilename);
				
			// data inventory items written to disk
			propertiesTable.setProperty("100", "CD,Black Diamond,Angie Stone,LS5784,5");
			propertiesTable.setProperty("101", "CD,Fly In The Hand,Alice Russell,TBM345984,3");
			propertiesTable.setProperty("102", "CD,Still Bill,Bill Withers,T-39GG5784,4");
			propertiesTable.setProperty("103", "CD,Play With Bootsy,Bootsy Collins,ERT945864,5");
			propertiesTable.setProperty("104", "CD,Cold Sweat,James Brown,WW4095604,7");
			propertiesTable.setProperty("cdNextItemNum", "105");
			propertiesTable.setProperty("300", "DVD,Star Wars - Complete Saga,Lucas Films,024543742180,2");
			propertiesTable.setProperty("301", "DVD,The Godfather Trilogy,Coppola Restoration,097361386461,3");
			propertiesTable.setProperty("302", "DVD,Kill Bill Vol. 1 & 2,Miramax Films,031398134350,1");
			propertiesTable.setProperty("303", "DVD,12 Monkeys,Universal Picture,025192032141,4");
			propertiesTable.setProperty("304", "DVD,Kingsman - The Secret Service,Marv Films,024543980216,2");
			propertiesTable.setProperty("dvdNextItemNum", "305");
			propertiesTable.setProperty("500", "BOOK,The Hobbit,J. R. R. Tolkien,9780788789823,2");
			propertiesTable.setProperty("501", "BOOK,Harry Potter Paperback Boxset,J.K. Rowling,9780545162074,2");
			propertiesTable.setProperty("502", "BOOK,The Lord of the Rings 3 Volume Book Set,Tolkien,031398134350,1");
			propertiesTable.setProperty("503", "BOOK,1984,George Orwell,9780451518651,3");
			propertiesTable.setProperty("504", "BOOK,The Little Prince,Antoine de Saint-Exupéry,9788998469863,5");
			propertiesTable.setProperty("bookNextItemNum", "505");
			
			// write to disk
			propertiesTable.store(outputFile, "new file");
			outputFile.close();
		}
		
		
		// if/when the file exists, load contents of file into the propertiesTable
		FileInputStream inputFile = new FileInputStream(propertiesFilename); 
		
		// load property file
		propertiesTable.load(inputFile);
		
		// 
		
		
		cdNextItemNum = propertiesTable.getProperty("cdItemNum");
		dvdNextItemNum = propertiesTable.getProperty("dvdItemNum");
		bookNextItemNum = propertiesTable.getProperty("bookItemNum");

		/*
		// list table properties
		System.out.println("\nData stored in properties file on disk\n");
		propertiesTable.list(System.out);
		*/

	}
	
	public InvPersistance(InvModel theModel) throws Exception
	{
		this();	// calls empty constructor to set up the data
		this.theModel = theModel;
	}
	
	public void testMessage()
	{
		System.out.println("testmessage");
	}
	
	/*
	public static void main(String[] args) throws Exception
	{
		InvPersistance pt = new InvPersistance();
		pt.testMessage();
		pt.listAllInventoryItems();
		
		
//		pt.searchForItemDetails("101");
//		System.out.println("ItemNumber: " + itemNum + ", ItemType: " + itemType + ", Title: " + title + ", Artist: " + artist + ", ProductCode: " + productCode + ", Quantity: " + quantity);
//		
		/*

		http://stackoverflow.com/questions/216894/get-an-outputstream-into-a-string
		http://stackoverflow.com/questions/1760654/java-printstream-to-string
		https://www.google.com/search?q=java+stringbuilder+with+printstream

		*/
		/*
	}
	*/
	

	

	
	
	// LIST 'all' items in inventory
	public void listAllInventoryItems()
	{
		StringBuilder listItemsToBuffer = new StringBuilder(this.getPropertyAsString(propertiesTable));
		InvModel.listInventoryView = listItemsToBuffer.toString();

	}
	
	// write properties table as string to buffer
	public String getPropertyAsString(Properties property) 
	{    
		StringWriter writer = new StringWriter();
		property.list(new PrintWriter(writer));
		return writer.getBuffer().toString();
	}
	

	// List 'one' item in inventory 
	public static void searchForItemDetails(String itemNum) throws Exception
	{
		
		if (propertiesTable.getProperty(itemNum) == null)
		{
			System.out.println("Item Number " + itemNum + " not found");
		}
		else
		{

			System.out.println("Your Search term: " + itemNum + " : "+ propertiesTable.getProperty(itemNum));
			
			itemDetails = propertiesTable.getProperty(itemNum).split(",");
			itemType = itemDetails[0];
			title  = itemDetails[1];
			artist  = itemDetails[2];
			productCode  = itemDetails[3];
			quantity  = itemDetails[4];
			
			System.out.println("!!!!"+ itemNum + itemType + title + artist + productCode + quantity);
			
			updateModelWithSearchResults(itemNum, itemType, title, artist, productCode, quantity);

		}

	}
	


	// UPDATE:
	public void updateArtistInventoryItem(String itemNum, String artist) throws Exception 
	{
		// untested: currently creates new itemNum when using the create(), need to figure out a way 

		System.out.println("DBug:Pers:updateArtistInventoryItem:artist;  " + artist);
		String updatedArtist = InvPersistance.toTitleCase(artist);
		this.createInventoryEntry(itemNum,itemType, title, artist, productCode, quantity);
		this.searchForItemDetails(itemNum);
		this.updateModelWithSearchResults(itemNum, itemType, title, artist, productCode, quantity);

	}
	
	
	public void createNewInventorySelectType(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		

		ItemType typeEnum = ItemType.valueOf(itemType);
		
        switch (typeEnum)

        
        {


			case CD : 
        		System.out.println("Chose: CD: \t");
        		
        		itemNum = cdNextItemNum;
        		itemType = "CD";
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
        		cdNextItemNum = String.valueOf(Integer.parseInt(cdNextItemNum) + 1);
        		break;
        		
        	case DVD : 
        		System.out.println("Chose: DVD: \t");
        		itemNum = dvdNextItemNum;
        		itemType = "DVD";
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
        		dvdNextItemNum = String.valueOf(Integer.parseInt(dvdNextItemNum) + 1);
        		break;
        		
        	case BOOK : 
        		System.out.println("Chose: Books: \t");
        		itemNum = bookNextItemNum;
        		itemType = "BOOK";
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
        		bookNextItemNum = String.valueOf(Integer.parseInt(bookNextItemNum) + 1);
        		break;
        	
        }
        
	}
	
	/*
	public void updateCDNextItemNum(String cdNextItemNum)
	{
		this.cdNextItemNum = String.valueOf(Integer.parseInt(cdNextItemNum) + 1);
	}
	*/

	// CREATE
	public void createInventoryEntry(String itemNum, String itemType, String title, String artist, String productCode, String quantity)throws Exception
	{
		OutputStream outputFile = new FileOutputStream(propertiesFilename);
		String updatedTitle = InvPersistance.toTitleCase(title);
		String updatedArtist = InvPersistance.toTitleCase(artist);
		
		System.out.println(updatedTitle + " " + updatedArtist);

		
		String joinedUpdate = String.join(",", itemType.toUpperCase(),updatedTitle,updatedArtist,productCode,quantity);
		

		propertiesTable.put(itemNum, joinedUpdate);
		propertiesTable.store(outputFile, "updated");	
		propertiesTable.list(System.out);
	}
	
	// Ensure all input has correct display formatting 
	public static String toTitleCase(String givenString) 
	{
		  char[] chars = givenString.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++) 
		  {
		    if (!found && Character.isLetter(chars[i])) 
		    {
		      chars[i] = Character.toUpperCase(chars[i]);
		      found = true;
		    } 
		    else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') 
		    { 
		      found = false;
		    }
		  }
		  return String.valueOf(chars);
	}  
	
	
	
	
	// DELETE
	public void deleteItemFromInventory(String input) throws Exception
	{

		System.out.println("DBug:Pers:deleteItemFromInventory():input; " + input);
		
		if (propertiesTable.getProperty(input) == null)
		{
			System.out.println("Item not found");
		}
		else
		{
			OutputStream outputFile = new FileOutputStream(propertiesFilename);
			System.out.println("DBug:Pers:deleteItemFromInventory():input; " + input + " SUCCESS!!");
			propertiesTable.remove(input);
			propertiesTable.store(outputFile, "updated");
			propertiesTable.list(System.out);

		}
	}
	
	
	public static void updateModelWithSearchResults(String itemNum, String itemType, String title, String artist, String productCode, String quantity ) throws Exception
	{
		
		System.out.println("DEBUG*** UPDATE*** " + itemNum);
		
		
		theModel.setItemNum(itemNum);
		/*
		theModel.setItemType(itemType);
		theModel.setTitle(title);
		theModel.setArtist(artist);
		theModel.setProductCode(productCode);
		theModel.setQuantity(quantity);
		*/
		
		
	}
	

	
	// setters and getters for the MVC objects
	public InvModel getTheModel() 
	{
		return theModel;
	}

	public void setTheModel(InvModel theModel) 
	{
		this.theModel = theModel;
	}
	
	
	static private String itemNum; 
	public static String getItemNum() {
		return itemNum;
	}

	public static void setItemNum(String itemNum) {
		InvPersistance.itemNum = itemNum;
	}

	public static String getItemType() {
		return itemType;
	}

	public static void setItemType(String itemType) {
		InvPersistance.itemType = itemType;
	}

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		InvPersistance.title = title;
	}

	public static String getArtist() {
		return artist;
	}

	public static void setArtist(String artist) {
		InvPersistance.artist = artist;
	}

	public static String getProductCode() {
		return productCode;
	}

	public static void setProductCode(String productCode) {
		InvPersistance.productCode = productCode;
	}

	public static String getQuantity() {
		return quantity;
	}

	public static void setQuantity(String quantity) {
		InvPersistance.quantity = quantity;
	}

	public static String[] getItemDetails() {
		return itemDetails;
	}

	public static void setItemDetails(String[] itemDetails) {
		InvPersistance.itemDetails = itemDetails;
	}


	

	


}
	
	
	
	