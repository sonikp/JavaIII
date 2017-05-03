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
		System.out.println("\nData stored in properties file on disk\n");
//		propertiesTable.list(System.out);
		this.getInventoryItemsALL();

		
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
		
		System.out.println();
		System.out.println(ip.getNextCDItemNum());
		
		System.out.println();
		System.out.println(ip.getInventoryALLView());
		
		System.out.println();
		ip.getInventoryItemsSingle("100");
		System.out.println(ip.getInventorySingleView());
	}
	*/
	
	//// methods////
	public void getItemNumber() {
		System.out.println(nextCDItemNum);

		
	}
	
	public void setItemNumInModel()
	{
		theModel.setItemNum();

	}
	
	public String getNextCDItemNum()
	{
		return nextCDItemNum;
	}
	
	
	// GET 'ALL' items in inventory (sorted)
	public void getInventoryItemsALL() throws IOException
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

		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	

	
	public void getInventoryItemsSingle(String itemNum) throws IOException 
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
	
	

		
	
	
	///////// Model method for ALL string buffer item to view ////////////////////
	private void setInventoryALLView(String listInventoryView) {
		this.listInventoryViewALL = listInventoryView;
		
	}
	
	private String getInventoryALLView() {
		return listInventoryViewALL;
		
	}
	
	private void setInventorySingleView(String listInventoryView) {
		this.listInventoryViewSingle = listInventoryView;
		
	}
	
	private String getInventorySingleView() {
		return listInventoryViewSingle;
		
	}




	
}


	
