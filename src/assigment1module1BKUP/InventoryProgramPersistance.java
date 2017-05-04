package assigment1module1BKUP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import assignmentobserver.InvModel;
import assignmentobserver.InvPersistance;
import assignmentobserver.InvPersistance.ItemType;



public class InventoryProgramPersistance extends Properties {
	
	
    private String itemNum;

	private String nextCDItemNum;
	private String nextDVDItemNum;
	private String nextBOOKItemNum; 
	private ItemType typeEnum; 
	private String updatedTitle;
	private String updatedArtist;
	private String joinedUpdate;
	
		
	private String itemType;
	private String title;
	private String artist;
	private String productCode;
	private String quantity;
	private String itemDetails[];
//	private String listInventoryViewALL;		// model items
//	private String listInventoryViewSingle;		// model items

	
	private Properties propertiesTable;
	private String propertiesFilename = "StoredInventory.properties";
	private OutputStream outputFile;
	private FileInputStream inputFile;
	private StringBuilder getALLItemsToBuffer;
	private StringBuilder getSINGLEItemsToBuffer;
	private InventoryProgramModel theModel;


	
	// constructors
	public InventoryProgramPersistance() throws Exception {
		
		propertiesTable = new Properties();
		
		// Check to see if properties file already exists, if not create it
		File fileExistsOnDisk = new File(propertiesFilename);
		
		if (!fileExistsOnDisk.exists())
		{
			outputFile = new FileOutputStream(propertiesFilename);
						
			// data inventory items written to disk
			propertiesTable.setProperty("100", "CD,Black Diamond,Angie Stone,LS5784,5");
			propertiesTable.setProperty("300", "DVD,Star Wars - Complete Saga,Lucas Films,024543742180,2");
			propertiesTable.setProperty("500", "BOOK,The Hobbit,J. R. R. Tolkien,9780788789823,2");
			propertiesTable.setProperty("nextCDItemNum", "101");
			propertiesTable.setProperty("nextDVDItemNum", "301");
			propertiesTable.setProperty("nextBOOKItemNum", "501");
			
			// write to disk
			propertiesTable.store(outputFile, "new file");
			outputFile.close();

		}
		
		// if/when the file exists, load contents of file into the propertiesTable
		inputFile = new FileInputStream(propertiesFilename); 
		
		// load property file
		propertiesTable.load(inputFile);
			
		// retrieve next available item numbers from disk
		nextCDItemNum = propertiesTable.getProperty("nextCDItemNum");
		nextDVDItemNum = propertiesTable.getProperty("nextDVDItemNum");
		nextBOOKItemNum = propertiesTable.getProperty("nextBOOKItemNum");
		
		// DEBUG: list table properties
//		propertiesTable.list(System.out);
//		this.getInventoryItemsALL();

		
	}
	
	
	// model constructor
	public InventoryProgramPersistance(InventoryProgramModel theModel) throws Exception
	{
		this();	// calls empty constructor to set up the data
		this.theModel = theModel;
	}
	
	/*
	public static void main(String[] args) throws Exception{
		InventoryPersistance ip = new InventoryPersistance();
		
		ip.getInventorySingle("500");
		
//		ip.getInventoryALL();
		
//		System.out.println();
//		System.out.println(ip.getNextCDItemNum());
//		
//		System.out.println();
//		System.out.println(ip.getInventoryALL());
//		
//		System.out.println();
//		ip.getInventoryItemsSingle("500");
//		System.out.println(ip.getInventorySingleView());
	}
	*/
	
	//// methods////
	
	

	
	
	
	
	
	/////////////////////////OK/////////////////////////////
	
	// LIST ALL
	public void getInventoryALL() throws IOException {
		this.getInventoryItemsReadALL();

	}
	
	// LIST SINGLE
	public void getInventorySingle(String itemNum) throws IOException {
		this.getInventoryItemsReadSingle(itemNum);
	}
	
	// CREATE: inventory item
	public void createNewInventorySelectType(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		

		typeEnum = ItemType.valueOf(itemType);
		
        switch (typeEnum)
        {
			case CD : 
        		
        		itemNum = nextCDItemNum;
        		itemType = "CD";
        		// incrementing the next available item number
        		nextCDItemNum = String.valueOf(Integer.parseInt(nextCDItemNum) + 1);
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );      		
        		break;
        		
        	case DVD : 
        		
        		itemNum = nextDVDItemNum;
        		itemType = "DVD";
        		// incrementing the next available item number
        		nextDVDItemNum = String.valueOf(Integer.parseInt(nextDVDItemNum) + 1);
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
        		break;
        		
        	case BOOK : 
        		
        		itemNum = nextBOOKItemNum;
        		itemType = "BOOK";
        		// incrementing the next available item number
        		nextBOOKItemNum = String.valueOf(Integer.parseInt(nextBOOKItemNum) + 1);
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
        		break;	
        }

	}
	
	// CREATE: item by writing it to disk
	public void createInventoryEntry(String itemNum, String itemType, String title, String artist, String productCode, String quantity)throws Exception
	{
		outputFile = new FileOutputStream(propertiesFilename);
	
		updatedTitle = InvPersistance.toTitleCase(title);
		updatedArtist = InvPersistance.toTitleCase(artist);
		
		joinedUpdate = String.join(",", itemType.toUpperCase(),updatedTitle,updatedArtist,productCode,quantity);
		
		// writing new to propertiesTable
		propertiesTable.put(itemNum, joinedUpdate);
			
		typeEnum = ItemType.valueOf(itemType);
		
        switch (typeEnum)
        {
			case CD : 
				
				propertiesTable.put("nextCDItemNum", nextCDItemNum.toString());
				break;
        		
        	case DVD : 
        		
        		propertiesTable.put("nextDVDItemNum", nextDVDItemNum.toString());
        		break;
        		
        	case BOOK : 
        		
        		propertiesTable.put("nextBOOKItemNum", nextBOOKItemNum.toString());        		
        		break;
        		
        }
				
		propertiesTable.store(outputFile, "updated");
		outputFile.close();
		
		this.getInventoryItemsReadSingle(itemNum);
		

	}
	
	// UPDATE: single item ARTIST
	public void updateArtistInventoryItem(String itemNum, String artist) throws Exception {
		this.populateInstanceVariables(itemNum);
		updatedArtist = InvPersistance.toTitleCase(artist);
		this.createInventoryEntry(itemNum,itemType, title, artist, productCode, quantity);
	
		

	}
	
	// DELETE
	public void deleteItemFromInventory(String itemNum) throws Exception
	{


		
		if (propertiesTable.getProperty(itemNum) == null)
		{
			System.out.println("Item not found");
		}
		else
		{
			outputFile = new FileOutputStream(propertiesFilename);
			propertiesTable.remove(itemNum);
			propertiesTable.store(outputFile, "updated");
			
			getSINGLEItemsToBuffer = new StringBuilder();
			getSINGLEItemsToBuffer.setLength(0);
			
			try 
			{
					
				getSINGLEItemsToBuffer.append(itemNum + ": Sucessfully Deleted");
				this.setInventorySingleView(getSINGLEItemsToBuffer.toString());


			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
			
	
		
	}

	
	// READ: List 'ALL' items in inventory (sorted)
	public void getInventoryItemsReadALL() throws IOException {
				
		inputFile = new FileInputStream(propertiesFilename); 
		getALLItemsToBuffer = new StringBuilder();
		
		// clear previous buffer info
		getALLItemsToBuffer.setLength(0);		
		
		try 
		{
			
			propertiesTable.load(new FileInputStream(propertiesFilename));
//			propertiesTable.list(System.out);
		      
		    Map<String, String> sortedMap = new TreeMap(propertiesTable);

		    //output sorted properties (key=value)
		    for (String key : sortedMap.keySet()) 
		    {
		    	getALLItemsToBuffer.append(key + "=" + sortedMap.get(key) + "\n");
		    }

		    this.setInventoryALLView(getALLItemsToBuffer.toString());	//This line to write to MODEL 
//		    theModel.listInventoryViewALL(getALLItemsToBuffer.toString());

		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	// Populate local inventory values
	public void populateInstanceVariables(String itemNum) {
				
		if (propertiesTable.getProperty(itemNum) == null)
		{
			System.out.println("Item Number " + itemNum + " not found");
		}
		else
		{
			itemDetails = propertiesTable.getProperty(itemNum).split(",");
			itemType = itemDetails[0];
			title  = itemDetails[1];
			artist  = itemDetails[2];
			productCode  = itemDetails[3];
			quantity  = itemDetails[4];
		}
		

		
	}

	// READ: List 'SINGLE' item in inventory 
	public void getInventoryItemsReadSingle(String itemNum) throws IOException {

		getSINGLEItemsToBuffer = new StringBuilder();
		getSINGLEItemsToBuffer.setLength(0);
						
		try 
		{
				
			getSINGLEItemsToBuffer.append(itemNum + " : " + propertiesTable.getProperty(itemNum));
			this.setInventorySingleView(getSINGLEItemsToBuffer.toString());


		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	
	
	// Method ensures all input has correct display formatting 
	public static String toTitleCase(String userString)	{
		  char[] chars = userString.toLowerCase().toCharArray();
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
	
	// SET return buffer in theModel
	private void setInventoryALLView(String listInventoryViewALL) {
		theModel.listInventoryViewALL(listInventoryViewALL);
	}
	
	private void setInventorySingleView(String listInventoryViewSingle) {
		theModel.listInventoryViewSingle(listInventoryViewSingle);

	}
	
	/////////////////////////OK/////////////////////////////
	

	

		
	/*
	
	///////// Model method for ALL string buffer item to view ////////////////////
	
	
	public void listInventoryViewSingle(String listInventoryViewSingle) {
		this.listInventoryViewSingle = listInventoryViewSingle;
		
	}
	
	
	private String getInventoryItemsALL() {
		return listInventoryViewALL;
		
	}
	
	
//	private void setInventorySingleView(String listInventoryView) {
//		this.listInventoryViewSingle = listInventoryView;
//		
//	}
	
	private String getInventorySingle() {
		return listInventoryViewSingle;
		
	}

*/








	
}


	
