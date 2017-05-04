package assgnINVobsvr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;



public class InventoryPersistance extends Properties{
	
	
    private String itemNum;
    private String itemType;
    private String title;
	private String artist;
	private String productCode;
	private String quantity;
	private String nextCDItemNum;
	private String nextDVDItemNum;
	private String nextBOOKItemNum; 
	
	private String listInventoryViewALL;		// model items
	private String listInventoryViewSingle;		// model items

	
	private Properties propertiesTable;
	private String propertiesFilename = "StoredInventory.properties";
	private OutputStream outputFile;
	private FileInputStream inputFile;
	private StringBuilder getALLItemsToBuffer;
	private StringBuilder getSINGLEItemsToBuffer;
	private InvOModel theModel;


	
	// constructors
	public InventoryPersistance() throws Exception {
		
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
	public InventoryPersistance(InvOModel theModel) throws Exception
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
	// LIST ALL
	public void getInventoryALL() throws IOException {
		this.getInventoryItemsReadALL();

	}
	
	// LIST SINGLE
	public void getInventorySingle(String itemNum) throws IOException {
		this.getInventoryItemsReadSingle(itemNum);
	}
	
	
	public void getItemNumber() {
		System.out.println("PERSIS: " + nextCDItemNum);
		this.returnItemNum();
		
	}
	
	public void returnItemNum(){
		theModel.returnItemNum(nextCDItemNum);
	}
	
	
	public void setItemNumInModel()
	{
//		theModel.setItemNum();
		System.out.println("DEBUG");
	}
	
	public String getNextCDItemNum()
	{
		return nextCDItemNum;
	}
	
	
	// GET 'ALL' items in inventory (sorted)
	public void getInventoryItemsReadALL() throws IOException
	{
				
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
	

	
	public void getInventoryItemsReadSingle(String itemNum) throws IOException 
	{

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
	public static String toTitleCase(String userString) 
	{
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
	
	

		
	
	
	///////// Model method for ALL string buffer item to view ////////////////////
	private void setInventoryALLView(String listInventoryViewALL) {
		theModel.listInventoryViewALL(listInventoryViewALL);
	}
	
	private void setInventorySingleView(String listInventoryViewSingle) {
		theModel.listInventoryViewSingle(listInventoryViewSingle);
//		this.listInventoryViewSingle(listInventoryViewSingle);
//		System.out.println(listInventoryViewSingle);
	}
	
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


//	public void getInventorySingle() {
//		System.out.println("FOO!!!!");
//		
//	}




	
}


	
