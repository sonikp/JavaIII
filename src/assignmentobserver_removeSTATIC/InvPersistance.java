package assignmentobserver_removeSTATIC;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;




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
	
	private InvModel theModel;
	private static Properties propertiesTable;
	private static String propertiesFilename = "StoredInventory.properties";
	private static OutputStream outputFile;
	private static FileInputStream inputFile; 
	private static StringBuilder listItemsToBuffer;



	// constructors
	public InvPersistance() throws Exception
	{
		
		propertiesTable = new Properties();
		
		// Check to see if properties file already exists, if not create it
		File fileExistsOnDisk = new File(propertiesFilename);
		
		if (!fileExistsOnDisk.exists())
		{
//			OutputStream outputFile = new FileOutputStream(propertiesFilename);
			outputFile = new FileOutputStream(propertiesFilename);
				
			// data inventory items written to disk
			propertiesTable.setProperty("100", "CD,Black Diamond,Angie Stone,LS5784,5");
			propertiesTable.setProperty("101", "CD,Fly In The Hand,Alice Russell,TBM345984,3");
			propertiesTable.setProperty("102", "CD,Still Bill,Bill Withers,T-39GG5784,4");
			propertiesTable.setProperty("103", "CD,Play With Bootsy,Bootsy Collins,ERT945864,5");
			propertiesTable.setProperty("104", "CD,Cold Sweat,James Brown,WW4095604,7");
			propertiesTable.setProperty("cdItemNum", "105");
			propertiesTable.setProperty("300", "DVD,Star Wars - Complete Saga,Lucas Films,024543742180,2");
			propertiesTable.setProperty("301", "DVD,The Godfather Trilogy,Coppola Restoration,097361386461,3");
			propertiesTable.setProperty("302", "DVD,Kill Bill Vol. 1 & 2,Miramax Films,031398134350,1");
			propertiesTable.setProperty("303", "DVD,12 Monkeys,Universal Picture,025192032141,4");
			propertiesTable.setProperty("304", "DVD,Kingsman - The Secret Service,Marv Films,024543980216,2");
			propertiesTable.setProperty("dvdItemNum", "305");
			propertiesTable.setProperty("500", "BOOK,The Hobbit,J. R. R. Tolkien,9780788789823,2");
			propertiesTable.setProperty("501", "BOOK,Harry Potter Paperback Boxset,J.K. Rowling,9780545162074,2");
			propertiesTable.setProperty("502", "BOOK,The Lord of the Rings 3 Volume Book Set,Tolkien,031398134350,1");
			propertiesTable.setProperty("503", "BOOK,1984,George Orwell,9780451518651,3");
			propertiesTable.setProperty("504", "BOOK,The Little Prince,Antoine de Saint-Exupéry,9788998469863,5");
			propertiesTable.setProperty("bookItemNum", "505");
			
			// write to disk
			propertiesTable.store(outputFile, "new file");
			outputFile.close();
		}
		

		// if/when the file exists, load contents of file into the propertiesTable
//		FileInputStream inputFile = new FileInputStream(propertiesFilename); 
		inputFile = new FileInputStream(propertiesFilename); 
		
		// load property file
		propertiesTable.load(inputFile);
		
	
		// retrieve next available item numbers from disk
		cdNextItemNum = propertiesTable.getProperty("cdItemNum");
		dvdNextItemNum = propertiesTable.getProperty("dvdItemNum");
		bookNextItemNum = propertiesTable.getProperty("bookItemNum");
		
		// DEBUG: list table properties
//		System.out.println("\nData stored in properties file on disk\n");
//		propertiesTable.list(System.out);
		this.listInventoryView = new String();
		this.listItemsToBuffer = new StringBuilder();
	}
	


	public InvPersistance(InvModel theModel) throws Exception
	{
		this();	// calls empty constructor to set up the data
		this.theModel = theModel;
	}
	
	/*
	// test code
	public void testMessage()
	{
		System.out.println("testmessage");
	}
	
	public void setModelTitle(String title)
	{
		theModel.setTitle(title);
	}
	*/
	
	/*
	// DEBUG: local 'main' method for testing 
	public static void main(String[] args) throws Exception
	{
		InvPersistance pt = new InvPersistance();
		
		itemNum = "500";
		
		pt.searchForItemDetails(itemNum);
		
		artist = "Another Knob";
		
		pt.updateArtistInventoryItem(itemNum, artist);	//String itemNum, String artist
		
		System.out.println(theModel.listInventoryView);
		
//		pt.searchForItemDetails(itemNum);
//		
//		pt.searchForItemDetails("505");
	}
	*/
	
	
	// LIST 'all' items in inventory
	public void listAllInventoryItems() throws IOException
	{
//		FileInputStream inputFile = new FileInputStream(propertiesFilename); 
//		StringBuilder listItemsToBuffer = new StringBuilder();
				
		inputFile = new FileInputStream(propertiesFilename); 
		listItemsToBuffer = new StringBuilder();
		
		// clear previous buffer info
		listItemsToBuffer.setLength(0);
		
		
		try 
		{

			
			propertiesTable.load(new FileInputStream(propertiesFilename));
			listItemsToBuffer.setLength(0);		// clear previous buffer
		    Map<String, String> sortedMap = new TreeMap(propertiesTable);

		    //output sorted properties (key=value)
		    for (String key : sortedMap.keySet()) 
		    {
		    	listItemsToBuffer.append(key + "=" + sortedMap.get(key) + "\n");
		    }
//		   DELETE InvModel.listInventoryView = listItemsToBuffer.toString();
		    this.theModel.setListInventoryView(listItemsToBuffer.toString());	//Improved line

		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public void listSingleInventoryItem(String itemNum) throws IOException //return String
	{
//		inputFile = new FileInputStream(propertiesFilename); 
//		listItemsToBuffer = new StringBuilder();
		
		// this needs to be an object of some sort, I could not figure this out
		
		// clear previous buffer info
//		propertiesTable.getProperty(itemNum);
		listItemsToBuffer.setLength(0);
		
		try 
		{
			
			
			listItemsToBuffer.append(itemNum + " : " + propertiesTable.getProperty(itemNum));
			//InvModel.listInventoryView = listItemsToBuffer.toString();
			theModel.setListInventoryView(listItemsToBuffer.toString());


		} catch (Exception e) {
		    e.printStackTrace();
		}
		
//		return itemNum + " : " + propertiesTable.getProperty(itemNum);
		
	}
	

	
	// write properties table as string to buffer
	public String getPropertyAsString(Properties property) 
	{    
		StringWriter writer = new StringWriter();
		property.list(new PrintWriter(writer));
		return writer.getBuffer().toString();
	}
	

	// List 'one' item in inventory 
	public void searchForItemDetails(String itemNum) throws Exception
	{
		
		if (propertiesTable.getProperty(itemNum) == null)
		{
			System.out.println("Item Number " + itemNum + " not found");
		}
		else
		{

			System.out.println("\nYour Search term: \n\n" + itemNum + " : "+ propertiesTable.getProperty(itemNum));
			
			itemDetails = propertiesTable.getProperty(itemNum).split(",");
			itemType = itemDetails[0];
			title  = itemDetails[1];
			artist  = itemDetails[2];
			productCode  = itemDetails[3];
			quantity  = itemDetails[4];
			
			try 
			{
				
//				System.out.println(propertiesTable.getProperty(itemNum));
				// ROBERT: Error for NULL 
				listItemsToBuffer.setLength(0);
				listItemsToBuffer.append(itemNum + " : " + propertiesTable.getProperty(itemNum));
//				InvModel.listInventoryView = listItemsToBuffer.toString();
				theModel.setListInventoryView(listItemsToBuffer.toString());
				
			     


			} catch (Exception e) {
			    e.printStackTrace();
			}
			
//			this.updateArtistInventoryItem(itemNum, artist);
			
//			updateModelWithSearchResults(itemNum, itemType, title, artist, productCode, quantity);

		}

	}
	
	
	


	// UPDATE: single item ARTIST
	public void updateArtistInventoryItem(String itemNum, String artist) throws Exception 
	{
		// untested: currently creates new itemNum when using the create(), need to figure out a way 


		String updatedArtist = InvPersistance.toTitleCase(artist);
		this.createInventoryEntry(itemNum,itemType, title, artist, productCode, quantity);
//		this.searchForItemDetails(itemNum);
//		this.updateModelWithSearchResults(itemNum, itemType, title, artist, productCode, quantity);
		
		// ********update as a buffer
//		this.listSingleInventoryItem();
		
		
		try 
		{
//			propertiesTable.load(new FileInputStream(propertiesFilename));
			
			propertiesTable.getProperty(itemNum);
			listItemsToBuffer.setLength(0);
			listItemsToBuffer.append(itemNum + " : " + propertiesTable.getProperty(itemNum));
//			InvModel.listInventoryView = listItemsToBuffer.toString();
			theModel.setListInventoryView(listItemsToBuffer.toString());
			
		     


		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		

	}
	
	// CREATE: inventory item
	public void createNewInventorySelectType(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		
		ItemType typeEnum = ItemType.valueOf(itemType);
		
        switch (typeEnum)
        {
			case CD : 
        		
        		itemNum = cdNextItemNum;
        		itemType = "CD";
        		// incrementing the next available item number
        		cdNextItemNum = String.valueOf(Integer.parseInt(cdNextItemNum) + 1);
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );      		
        		break;
        		
        	case DVD : 
        		
        		itemNum = dvdNextItemNum;
        		itemType = "DVD";
        		// incrementing the next available item number
        		dvdNextItemNum = String.valueOf(Integer.parseInt(dvdNextItemNum) + 1);
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
        		break;
        		
        	case BOOK : 
        		
        		itemNum = bookNextItemNum;
        		itemType = "BOOK";
        		// incrementing the next available item number
        		bookNextItemNum = String.valueOf(Integer.parseInt(bookNextItemNum) + 1);
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
        		break;	
        }

	}
	

	// CREATE: item by writing it to disk
	public void createInventoryEntry(String itemNum, String itemType, String title, String artist, String productCode, String quantity)throws Exception
	{
		OutputStream outputFile = new FileOutputStream(propertiesFilename);
	
		String updatedTitle = InvPersistance.toTitleCase(title);
		String updatedArtist = InvPersistance.toTitleCase(artist);
		
		String joinedUpdate = String.join(",", itemType.toUpperCase(),updatedTitle,updatedArtist,productCode,quantity);
		
		// writing new to propertiesTable
		propertiesTable.put(itemNum, joinedUpdate);

		propertiesTable.put("cdItemNum", cdNextItemNum.toString());
		propertiesTable.put("dvdItemNum", dvdNextItemNum.toString());
		propertiesTable.put("bookItemNum", bookNextItemNum.toString());
		propertiesTable.store(outputFile, "updated");
		outputFile.close();

		inputFile = new FileInputStream(propertiesFilename); 
		listItemsToBuffer = new StringBuilder();
		
		// load property file
		propertiesTable.load(inputFile);
		
		try 
		{
			propertiesTable.load(new FileInputStream(propertiesFilename));
		      
		    Map<String, String> sortedMap = new TreeMap(propertiesTable);

		    //output sorted properties (key=value)
		    for (String key : sortedMap.keySet()) 
		    {
		    	listItemsToBuffer.append(key + "=" + sortedMap.get(key) + "\n");
		    }
//		    InvModel.listInventoryView = listItemsToBuffer.toString();
		    theModel.setListInventoryView(listItemsToBuffer.toString());

		} catch (Exception e) {
		    e.printStackTrace();
		}
		

	}
	
	// Method ensures all input has correct display formatting 
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
	public void deleteItemFromInventory(String itemNum) throws Exception
	{

//		System.out.println("DBug:Pers:deleteItemFromInventory():input; " + input);
		
		
		
		if (propertiesTable.getProperty(itemNum) == null)
		{
			System.out.println("Item not found");
		}
		else
		{
			
			System.out.println("DEBUG!!!! =>" + itemNum);
//			OutputStream outputFile = new FileOutputStream(propertiesFilename);
			outputFile = new FileOutputStream(propertiesFilename);

			propertiesTable.remove(itemNum);
			propertiesTable.store(outputFile, "updated");

			
			
			try 
			{
				propertiesTable.load(new FileInputStream(propertiesFilename));
			      
			    Map<String, String> sortedMap = new TreeMap(propertiesTable);

			    //output sorted properties (key=value)
			    for (String key : sortedMap.keySet()) 
			    {
			    	listItemsToBuffer.append(key + "=" + sortedMap.get(key) + "\n");
			    }
//			    InvModel.listInventoryView = listItemsToBuffer.toString();
			    theModel.setListInventoryView(listItemsToBuffer.toString());

			} catch (Exception e) {
			    e.printStackTrace();
			}

		}
	}
	
	/*
	// Not Used
	public static void updateModelWithSearchResults(String itemNum, String itemType, String title, String artist, String productCode, String quantity ) throws Exception
	{
		
		System.out.println("DEBUG*** UPDATE*** " + itemNum);
		
		
		theModel.setItemNum(itemNum);	
		theModel.setItemType(itemType);
		theModel.setTitle(title);
		theModel.setArtist(artist);
		theModel.setProductCode(productCode);
		theModel.setQuantity(quantity);
		
		
		
	}
	*/

	
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
	
	
	
	