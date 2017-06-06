package zTBDass2mod2;

/*
Research:
http://stackoverflow.com/questions/12814112/transferring-stringbuilder-contents-to-a-new-arraylist-in-java
https://itssmee.wordpress.com/2014/02/19/java-string-stringbuilder-arrays-and-arraylist-code-and-rules/

*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;



public class aTestPersist
{
	
	private String itemType;
	private String title;
	private String artist;
	private String productCode;
	private String quantity;
	private String itemDetails[];
	private String dataArray[][];
	
	private Properties propertiesTable;
	private String propertiesFilename = "StoredInventory.properties";
	private OutputStream outputFile;
	private FileInputStream inputFile; 
	private StringBuilder listItemsToBuilder;
	private String itemsListedInString;

	
	// constructor
	public aTestPersist() throws Exception {
		
		propertiesTable = new Properties();
		
		File fileExistsOnDisk = new File(propertiesFilename);
		
		if (!fileExistsOnDisk.exists())
		{

			outputFile = new FileOutputStream(propertiesFilename);
				
			// data inventory items written to disk
			propertiesTable.setProperty("100", "CD,Black Diamond,Angie Stone,LS5784,5");
			propertiesTable.setProperty("101", "CD,Fly In The Hand,Alice Russell,TBM345984,3");
			propertiesTable.setProperty("102", "CD,Still Bill,Bill Withers,T-39GG5784,4");
			propertiesTable.setProperty("103", "CD,Play With Bootsy,Bootsy Collins,ERT945864,5");
			propertiesTable.setProperty("104", "CD,Cold Sweat,James Brown,WW4095604,7");
			// write to disk
			propertiesTable.store(outputFile, "new file");
			outputFile.close();
		}
		
		inputFile = new FileInputStream(propertiesFilename); 
		
		// load property file
		propertiesTable.load(inputFile);
//		propertiesTable.list(System.out);
		
	}
	
	public static void main(String[] args) throws Exception
	{
		aTestPersist tp = new aTestPersist();
		tp.listToStringBuilder();
		System.out.println("\n\nlisted items = \n" + tp.getStringBuilderBuffer());
		tp.createSingleArrayOfItems();
		System.out.println("\n\n--\n\n");
		tp.createTableArrayOfItems();
		
		
	}
	
	public void createTableArrayOfItems() throws Exception {
//		itemsListedInString
		
			
		for (int i = 0; i < itemsListedInString.length(); i++) {
//			System.out.println([i]);
		}
		
		
			
	}
	
	public void createSingleArrayOfItems() {
		itemDetails = propertiesTable.getProperty("100").split(",");
		itemType = itemDetails[0];
		title  = itemDetails[1];
		artist  = itemDetails[2];
		productCode  = itemDetails[3];
		quantity  = itemDetails[4];
		
		for (String element : itemDetails)
			System.out.println("Element: " + element);
		
	
	}
	
	public String getStringBuilderBuffer() {
		return itemsListedInString;
	}
	
	// LIST 'all' items in inventory
	public void listToStringBuilder() throws IOException
	{

				
		inputFile = new FileInputStream(propertiesFilename); 
		listItemsToBuilder = new StringBuilder();
		
		// clear previous buffer info
		listItemsToBuilder.setLength(0);
		
		
		try 
		{

			
			propertiesTable.load(new FileInputStream(propertiesFilename));
		      
		    Map<String, String> sortedMap = new TreeMap(propertiesTable);

		    //output sorted properties (key=value)
		    for (String key : sortedMap.keySet()) 
		    {
		    	listItemsToBuilder.append(key + "=" + sortedMap.get(key) + "\n");
		    }
		    itemsListedInString = listItemsToBuilder.toString();

		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}