package assignmentobserverbackupcopy;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;


public class InvPersistance extends Properties 
{
	static String itemNum; // Robert it seems to be asking me to remove the private setting
	static String itemType;
	static String title;
	static String artist;
	static String productCode;
	static String quantity;
	
	static String itemDetails[];
	
	private InvModel theModel;
	private static Properties propertiesTable;
	private static String propertiesFilename = "StoredInventory.properties";

	


	


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
			propertiesTable.setProperty("300", "DVD,Star Wars - Complete Saga,Lucas Films,024543742180,2");
			propertiesTable.setProperty("301", "DVD,The Godfather Trilogy,Coppola Restoration,097361386461,3");
			propertiesTable.setProperty("302", "DVD,Kill Bill Vol. 1 & 2,Miramax Films,031398134350,1");
			propertiesTable.setProperty("303", "DVD,12 Monkeys,Universal Picture,025192032141,4");
			propertiesTable.setProperty("304", "DVD,Kingsman - The Secret Service,Marv Films,024543980216,2");
			propertiesTable.setProperty("500", "BOOK,The Hobbit,J. R. R. Tolkien,9780788789823,2");
			propertiesTable.setProperty("501", "BOOK,Harry Potter Paperback Boxset,J.K. Rowling,9780545162074,2");
			propertiesTable.setProperty("502", "BOOK,The Lord of the Rings 3 Volume Book Set,Tolkien,031398134350,1");
			propertiesTable.setProperty("503", "BOOK,1984,George Orwell,9780451518651,3");
			propertiesTable.setProperty("504", "BOOK,The Little Prince,Antoine de Saint-Exupéry,9788998469863,5");
			
			// write to disk
			propertiesTable.store(outputFile, "new file");
			outputFile.close();
		}
		
		
		// if/when the file exists, load contents of file into the propertiesTable
		FileInputStream inputFile = new FileInputStream(propertiesFilename); 
		
		// load property file
		propertiesTable.load(inputFile);
		
		// list table properties
		System.out.println("\nData stored in properties file on disk\n");
		propertiesTable.list(System.out);

	}
	
	public InvPersistance(InvModel theModel) throws Exception
	{
		this();	// calls empty constructor to set up the data
		this.theModel = theModel;
	}
	
	/*
	public static void main(String[] args) throws Exception
	{
		InvPersistance pt = new InvPersistance();
		pt.testMessage();
		pt.searchForItemDetails("101");
		System.out.println("ItemNumber: " + itemNum + ", ItemType: " + itemType + ", Title: " + title + ", Artist: " + artist + ", ProductCode: " + productCode + ", Quantity: " + quantity);
		
		

		
		
	}
	*/
	
	// UPDATE:
	public void updateArtistInventoryItem(String artist) throws Exception 
	{
		// untested: currently creates new itemNum when using the create(), need to figure out a way 

		System.out.println("DBug:Pers:updateArtistInventoryItem:artist;  " + artist);
		String updatedArtist = InvPersistance.toTitleCase(artist);
		this.createInventoryItem(itemType, title, artist, productCode, quantity);
		this.searchForItemDetails(itemNum);
		this.updateModelWithSearchResults(itemNum, itemType, title, artist, productCode, quantity);

	}
	
	// make create item with itemNum, before have an if/else statement for new existing
	
	// CREATE
	public void createInventoryItem(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		OutputStream outputFile = new FileOutputStream(propertiesFilename);
		System.out.println("DBug:Pers:createInventoryItem():title; " + title);

		itemNum = "407";	// ToDo create a counter numbering system
		
		String updatedTitle = InvPersistance.toTitleCase(title);
		String updatedArtist = InvPersistance.toTitleCase(artist);
		
		System.out.println(updatedTitle + " " + updatedArtist);

		
		String joinedUpdate = String.join(",", itemType.toUpperCase(),updatedTitle,updatedArtist,productCode,quantity);
		

		propertiesTable.put(itemNum, joinedUpdate);
		propertiesTable.store(outputFile, "updated");	
		propertiesTable.list(System.out);
	}
	
	// updates all input from 
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
	
	
	// READ:
	public void searchForItemDetails(String itemNum) throws Exception
	{

		System.out.println("DBug:Pers:searchForItemDetails():input; " + itemNum);
		
		if (propertiesTable.getProperty(itemNum) == null)
		{
			System.out.println("Item Number " + itemNum + " not found");
		}
		else
		{
			// getting thing done, ToDo, if I have time, I will come back to make this with a 
			System.out.println("Your Search term: " + itemNum + " : "+ propertiesTable.getProperty(itemNum));
			itemDetails = propertiesTable.getProperty(itemNum).split(",");
			
//			itemNum = itemNum;	// not necessary I should remove this
			itemType = itemDetails[0];
			title  = itemDetails[1];
			artist  = itemDetails[2];
			productCode  = itemDetails[3];
			quantity  = itemDetails[4];
			
			
			this.updateModelWithSearchResults(itemNum, itemType, title, artist, productCode, quantity);

		}

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
	
	
	public void updateModelWithSearchResults(String itemNum, String itemType, String title, String artist, String productCode, String quantity ) throws Exception
	{
		theModel.itemNum = itemNum;
		theModel.itemType = itemType;
		theModel.title = title;
		theModel.artist = artist;
		theModel.productCode = productCode;
		theModel.quantity = quantity;

		
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
	
	public void testMessage()
	{
		System.out.println("testmessage");
	}
	
	

	






	

	
	//==========================Old Shit=============================

	/*
	public void getStoredValue(String input) throws Exception
	{

		System.out.println("DBug:Pers:getStoredValue:input; " + input);
		
		if (propertiesTable.getProperty(input) == null)
		{
			System.out.println("not found");
		}
		else
		{
			System.out.println("Your Search term: " + input + " : "+ propertiesTable.getProperty(input));
			
		}

	}
	*/
	
	
	/*
public void datastoreInitialization() throws Exception
{
	
	// 1. write to a properties file
	OutputStream opFile = new FileOutputStream("StoredInventory.properties");
	*/
	/*
	// key:value pair data written to file
	propertiesTable.setProperty("name", "Angie Stone");
	propertiesTable.setProperty("title", "Fly In The Hand");
	propertiesTable.setProperty("number", "DFZ-435998");

	propertiesTable.setProperty("cd1", "Alice Russell:Fly In The Hand:DFZ-435998");
	propertiesTable.setProperty("cd2", "Bootsy Collins:Play With Bootsy:E4572HGH993");
	*/
	
	/*
	// push to properties properties file
	propertiesTable.store(opFile, "Inventory Data");	// first entry in the file and explains the purpose of the file
	opFile.close();
	*/
	
	/*
	// 2. read from properties file
	FileInputStream ipFile = new FileInputStream("StoredInventory.properties"); 
	
	// load property file
	propertiesTable.load(ipFile);
	
	// list table properties
	System.out.println("\nData stored in properties file on disk\n");
	propertiesTable.list(System.out);
	
	// list property value from delimited : table properties
	System.out.println("\n\nList property value from delimited : table properties");
	String[] values = propertiesTable.getProperty("cd1").toString().split(":");		
	System.out.print("\n" + values[0]);
	}
	*/




	/*

	private static String prodID = "ProductID";
	private static String prodIDnum = "1234";
	private String valueItem;
	
	//Key for 2nd part of array
	final static int TITLE = 0;
	final static int ARTIST = 1;
	final static int PRODUCTCODE = 2;
	
	// item type
	public enum itemType { CD,DVD,BOOK,ALL };
	
	String cdValues[];
	String dvdValues[];
	String bookValues[];
	
	String cdInfos[][];
	String dvdInfos[][];
	String bookInfos[][];
	

	static Properties propTable = new Properties();
	Properties dataTable = new Properties();
	
	*/

	/*
	public void chooseType(ItemType item, int loc)
	{
        //System.out.println("DBug:chooseType:dvdValues:&loc=2\t " + this.dvdValues[loc]);
		
		switch (item)
        {
        	case CD : System.out.println("Chose: CD: \t" + this.cdValues[loc]);
        	break;
        	case DVD : System.out.println("Chose: DVD: \t" + this.dvdValues[loc]);
        	break;
        	case BOOKS : System.out.println("Chose: Books: \t" + this.bookValues[loc]);
        	break;
        }
        
	}
	
	public static void main(String[] args) throws Exception
	{
		
		InvPersistance tester = new InvPersistance();
		ItemType item = ItemType.BOOKS;
		
//		tester.chooseType(ItemType.DVD, 2);
//		tester.chooseType(item,1);

	}
	
	public void populateSmallTable() throws Exception
	{
		InvPersistance db = new InvPersistance();
		
		// 1. write to a properties file
		OutputStream opFile = new FileOutputStream("Inventory.properties");
		

		dataTable.setProperty("title", "JavaSounds");
		dataTable.setProperty("ProductID", db.getProdID());

		dataTable.store(opFile, "Inventory Data");	// first entry in the file and explains the purpose of the file
		opFile.close();
		
	}
	
	public void readSmallTable() throws Exception
	{
		InvPersistance db = new InvPersistance();
		
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("Inventory.properties"); 
		
		// load property file
		dataTable.load(ipFile);
		
		System.out.println("\n");
		System.out.println("title:\t " + dataTable.getProperty("title"));
		System.out.println("ProductID: " + dataTable.getProperty("ProductID"));
		
	}
		
		public void readSmallTable() throws Exception
	{
		InvPersistance db = new InvPersistance();
		
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("Inventory.properties"); 
		
		// load property file
		propertiesTable.load(ipFile);
		
		System.out.println("\n");
		System.out.println("title:\t " + propertiesTable.getProperty("title"));
		System.out.println("ProductID: " + propertiesTable.getProperty("ProductID"));
		
	}
	
	
	public void populateDataTable() throws Exception
	{
		
		OutputStream opFile = new FileOutputStream("InvePersistanceLargeDB.properties");
		propTable.setProperty("cd", "Black Diamond,Angie Stone,LS5784;Fly In The Hand,Alice Russell,TBM345984;Still Bill,Bill Withers,T-39GG5784;Play With Bootsy,Bootsy Collins,ERT945864;Cold Sweat,James Brown,WW4095604");
		propTable.setProperty("dvd", "Star Wars - Complete Saga,Lucas Films,024543742180;The Godfather Trilogy,Coppola Restoration,097361386461;Kill Bill Vol. 1 & 2,Miramax Films,031398134350;12 Monkeys,Universal Picture,025192032141;Kingsman - The Secret Service,Marv Films,024543980216");
		propTable.setProperty("book", "The Hobbit,J. R. R. Tolkien,9780788789823;Harry Potter Paperback Boxset,J.K. Rowling,9780545162074;The Lord of the Rings 3 Volume Book Set,Tolkien,031398134350;1984,George Orwell,9780451518651;The Little Prince,Antoine de Saint-Exupéry,9788998469863");
		
		// push to properties properties file
		propTable.store(opFile, "Test Inventory Data");	// first entry in the file and explains the purpose of the file
		opFile.close();
		
	}
	
	
	
	public void readDataTable(String db, String element) throws Exception
	{
		String dbSearch = "unknown";
		if (db == "cdInfos")
			dbSearch = "cdInfos";
		else if (db == "dvdInfos")
			dbSearch = "dvdInfos";
		else if (db == "bookInfos")
			dbSearch = "bookInfos";
		
		System.out.println("DBug:InvPe:read: " + dbSearch + " " + element);
			
		
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("InvePersistanceLargeDB.properties"); 
		
		// load property file
		propTable.load(ipFile);
		
		*/

		/*
		System.out.println("\nLets try listing all the properties\n");
		propTable.list(System.out);
		*/
		/*
		String cdValues[] = propTable.getProperty("cd").toString().split(",");
		String dvdValues[] = propTable.getProperty("dvd").toString().split(",");
		String bookValues[] = propTable.getProperty("book").toString().split(",");
		System.out.println("DBug:read:cdValues: \t" + cdValues[2]);
		
		//get two dimensional array from the properties file that has been delineated
		 String[][] cdInfos = fetchArrayFromPropFile("cd",propTable);
		 String[][] dvdInfos = fetchArrayFromPropFile("dvd",propTable);
		 String[][] bookInfos = fetchArrayFromPropFile("book",propTable);
		 System.out.println("DBug:read:cdInfos:\t" + cdInfos[2][TITLE]);
		 
		 
	}
	
	*/
	
	/*
	
	public void readAndDisplayDataTable() throws Exception
	{
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("InvePersistanceLargeDB.properties"); 
		
		// load property file
		propTable.load(ipFile);
		
		*/

		/*
		System.out.println("\nLets try listing all the properties\n");
		propTable.list(System.out);
		*/
		
	
	/*
		String[] cdValues = propTable.getProperty("cd").toString().split(",");
		String[] dvdValues = propTable.getProperty("dvd").toString().split(",");
		String[] bookValues = propTable.getProperty("book").toString().split(",");
//				System.out.print(cdValues[2]);
		
		//get two dimensional array from the properties file that has been delineated
		 String[][] cdInfos = fetchArrayFromPropFile("cd",propTable);
		 String[][] dvdInfos = fetchArrayFromPropFile("dvd",propTable);
		 String[][] bookInfos = fetchArrayFromPropFile("book",propTable);
		 
		 
		  //below code will print out all the Title, Artist, and ProductCode
		  for (int i = 1; i < cdInfos.length; i++) 
		  {
		      System.out.print("CD "+ i + ":");
		      System.out.print("\t");
		      System.out.print("Title: " + cdInfos[i][TITLE]);
		      System.out.print("\t");
		      System.out.print("Artist: " + cdInfos[i][ARTIST]);
		      System.out.print("\t");
		      System.out.print("ProductCode: " + cdInfos[i][PRODUCTCODE]);
		      System.out.print("\n");

		  }
		  System.out.println();
		  //below code will print out all the Title, Artist, and ProductCode
		  for (int i = 1; i < dvdInfos.length; i++) 
		  {
		      System.out.print("DVD "+ i + ":");
		      System.out.print("\t");
		      System.out.print("Title: " + dvdInfos[i][TITLE]);
		      System.out.print("\t");
		      System.out.print("Studio: " + dvdInfos[i][ARTIST]);
		      System.out.print("\t");
		      System.out.print("UPCCode: " + dvdInfos[i][PRODUCTCODE]);
		      System.out.print("\n");

		  }
		  
		  //below code will print out all the book Title, Artist, and ProductCode
		  for (int i = 1; i < bookInfos.length; i++) 
		  {
		      System.out.print("\nBook "+ i + ":");
		      System.out.print("\n");
		      System.out.print("Title: " + bookInfos[i][TITLE]);
		      System.out.print("\n");
		      System.out.print("Author: " + bookInfos[i][ARTIST]);
		      System.out.print("\n");
		      System.out.print("ISBN: " + bookInfos[i][PRODUCTCODE]);
		      System.out.print("\n");

		  }
				  
	}
	*/
	
	
	/*
	public void datastoreInitialization() throws Exception
	{
		//read from properties file
		FileInputStream ipFile = new FileInputStream("InvePersistanceLargeDB.properties"); 
		
		// load property file
		propTable.load(ipFile);
		
		// initialize arrays
		String[] cdValues = propTable.getProperty("cd").toString().split(",");
		String[] dvdValues = propTable.getProperty("dvd").toString().split(",");
		String[] bookValues = propTable.getProperty("book").toString().split(",");
		System.out.println("DBug:read:cdValues: \t" + cdValues[3]);
		
		//get two dimensional array from the properties file that has been delineated
		String[][] cdInfos = fetchArrayFromPropFile("cd",propTable);
		String[][] dvdInfos = fetchArrayFromPropFile("dvd",propTable);
	    String[][] bookInfos = fetchArrayFromPropFile("book",propTable);
		System.out.println("DBug:read:cdInfos:\t" + cdInfos[2][TITLE]);
	}
	
	*/
	
	
	/*
	public static void main(String[] args) throws Exception
	{

		

		/*
		// 1. Set properties file
		OutputStream opFile = new FileOutputStream("TestInventoryStore.properties");
		
		

		propTable.setProperty("cd", "Black Diamond,Angie Stone,LS5784;Fly In The Hand,Alice Russell,TBM345984;Still Bill,Bill Withers,T-39GG5784;Play With Bootsy,Bootsy Collins,ERT945864;Cold Sweat,James Brown,WW4095604");
		propTable.setProperty("dvd", "Star Wars - Complete Saga,Lucas Films,024543742180;The Godfather Trilogy,Coppola Restoration,097361386461;Kill Bill Vol. 1 & 2,Miramax Films,031398134350;12 Monkeys,Universal Picture,025192032141;Kingsman - The Secret Service,Marv Films,024543980216");
		propTable.setProperty("book", "The Hobbit,J. R. R. Tolkien,9780788789823;Harry Potter Paperback Boxset,J.K. Rowling,9780545162074;The Lord of the Rings 3 Volume Book Set,Tolkien,031398134350;1984,George Orwell,9780451518651;The Little Prince,Antoine de Saint-Exupéry,9788998469863");
		
		// push to properties properties file
		propTable.store(opFile, "Test Inventory Data");	// first entry in the file and explains the purpose of the file
		opFile.close();
		
		*/
		

		
		
		/*
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("TestInventoryStore.properties"); 
		
		// load property file
		propTable.load(ipFile);
		*/

		/*
		System.out.println("\nLets try listing all the properties\n");
		propTable.list(System.out);
		*/
		/*
		String[] cdValues = propTable.getProperty("cd").toString().split(",");
		String[] dvdValues = propTable.getProperty("dvd").toString().split(",");
		String[] bookValues = propTable.getProperty("book").toString().split(",");
//		System.out.print(values[2]);
		
		//get two dimensional array from the properties file that has been delineated
		 String[][] cdInfos = fetchArrayFromPropFile("cd",propTable);
		 String[][] dvdInfos = fetchArrayFromPropFile("dvd",propTable);
		 String[][] bookInfos = fetchArrayFromPropFile("book",propTable);
		 
		 
		  //below code will print out all the Title, Artist, and ProductCode
		  for (int i = 1; i < cdInfos.length; i++) 
		  {
		      System.out.print("\nCD "+ i + ":");
		      System.out.print("\n");
		      System.out.print("Title: " + cdInfos[i][TITLE]);
		      System.out.print("\n");
		      System.out.print("Artist: " + cdInfos[i][ARTIST]);
		      System.out.print("\n");
		      System.out.print("ProductCode: " + cdInfos[i][PRODUCTCODE]);
		      System.out.print("\n");

		  }
		  
		  //below code will print out all the Title, Artist, and ProductCode
		  for (int i = 1; i < dvdInfos.length; i++) 
		  {
		      System.out.print("\nDVD "+ i + ":");
		      System.out.print("\n");
		      System.out.print("Title: " + dvdInfos[i][TITLE]);
		      System.out.print("\n");
		      System.out.print("Studio: " + dvdInfos[i][ARTIST]);
		      System.out.print("\n");
		      System.out.print("UPCCode: " + dvdInfos[i][PRODUCTCODE]);
		      System.out.print("\n");

		  }
		  
		  //below code will print out all the book Title, Artist, and ProductCode
		  for (int i = 1; i < bookInfos.length; i++) 
		  {
		      System.out.print("\nBook "+ i + ":");
		      System.out.print("\n");
		      System.out.print("Title: " + bookInfos[i][TITLE]);
		      System.out.print("\n");
		      System.out.print("Author: " + bookInfos[i][ARTIST]);
		      System.out.print("\n");
		      System.out.print("ISBN: " + bookInfos[i][PRODUCTCODE]);
		      System.out.print("\n");

		  }
		  */

		
	//}


	

	
	/**
	* Creates two dimensional array from delineated string in properties file
	* @param propertyName name of the property as in the file
	* @param propFile the instance of the Properties file that has the property
	* @return two dimensional array
	*/
	
	
	/*
	private static String[][] fetchArrayFromPropFile(String propertyName, Properties propFile) 
	{

	  //get array split up by the semicolin
	  String[] a = propFile.getProperty(propertyName).split(";");

	  //create the two dimensional array with correct size
	  String[][] array = new String[a.length][a.length];

	  //combine the arrays split by semicolin and comma 
	  for(int i = 0;i < a.length;i++) 
	  {
	      array[i] = a[i].split(",");
	  }
	  return array;
	}
	
	*/
	/*
	public void writeDataStream(String prodIDnum) throws Exception
	{
//		Properties dataTable = new Properties();
		InvPersistance db = new InvPersistance();
		OutputStream opFile = new FileOutputStream("Inventory.properties");
////		System.out.println("Debug writeDataStream: "+ db.getProdID());
		
		try 
		{
			dataTable.setProperty("title", "JavaSounds");
			//dataTable.setProperty("ProductID", db.getProdID());
			System.out.println("Debug:thePersis:write:prodIDnum= " + prodIDnum);
			dataTable.setProperty("ProductID", prodIDnum);
			dataTable.store(opFile, "Inventory Data");	// first entry in the file and explains the purpose of the file
			opFile.close();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDataElementFromKey(String keyName) throws Exception
	{
		

		InvPersistance db = new InvPersistance();
		Properties dataTable = new Properties();
		FileInputStream ipFile = new FileInputStream("Inventory.properties");
		
		
		try 
		{
			
			// load property file
			dataTable.load(ipFile);
			System.out.println(keyName + "::: " + dataTable.getProperty(keyName));
			
			System.out.println("\n");
			System.out.println("title:\t " + dataTable.getProperty("title"));
			System.out.println("ProductID: " + dataTable.getProperty("ProductID"));
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	
	public String readDataElement(String keyName) throws Exception
	{
		

		InvPersistance db = new InvPersistance();
		Properties dataTable = new Properties();
		FileInputStream ipFile = new FileInputStream("Inventory.properties");
		
		
		try 
		{
			
			// load property file
			dataTable.load(ipFile);
			System.out.println(keyName + "::: " + dataTable.getProperty(keyName));
			valueItem = dataTable.getProperty(keyName);
			System.out.println("Debug:InvePerses:readDBelement:valueItem= " + valueItem);
//			System.out.println("\n");
//			System.out.println("title:\t " + dataTable.getProperty("title"));
//			System.out.println("ProductID: " + dataTable.getProperty("ProductID"));
//			
		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return valueItem;	
		

	}
	
	public void readDataStream(String prodIDnum) throws Exception
	{
		

		InvPersistance db = new InvPersistance();
		Properties dataTable = new Properties();
		FileInputStream ipFile = new FileInputStream("Inventory.properties");
		
		
		try 
		{
			
			// load property file
			dataTable.load(ipFile);
			
			System.out.println("\n");
			System.out.println("title:\t " + dataTable.getProperty("title"));
			System.out.println("ProductID: " + dataTable.getProperty("ProductID"));
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public void setProdID(String prodIDnum)
	{
		this.prodIDnum = prodIDnum;
//		System.out.println("Debug: Pers: " + prodIDnum);
		
	}
	
	public String getProdID()
	{
		return prodIDnum;
	}
	*/
}
	
	
	
	