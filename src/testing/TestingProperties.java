package testing;


import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class TestingProperties extends Properties 
{
	
	//Key for 2nd part of array
	final static int TITLE = 0;
	final static int ARTIST = 1;
	final static int PRODUCTCODE = 2;
	
	public enum itemType { cdInfos, dvdInfos, bookInfos };
	
	//public enum itemType { cd,dvd,book };
	

	static Properties propTable = new Properties();
	
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
		
		

		
		
		
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("TestInventoryStore.properties"); 
		
		// load property file
		propTable.load(ipFile);

		/*
		System.out.println("\nLets try listing all the properties\n");
		propTable.list(System.out);
		*/
		
		String[] cdValues = propTable.getProperty("cd").toString().split(",");
		String[] dvdValues = propTable.getProperty("dvd").toString().split(",");
		String[] bookValues = propTable.getProperty("book").toString().split(",");
//		System.out.print(values[2]);
		
		//get two dimensional array from the properties file that has been delineated
		 String[][] cdInfos = fetchArrayFromPropFile("cd",propTable);
		 String[][] dvdInfos = fetchArrayFromPropFile("dvd",propTable);
		 String[][] bookInfos = fetchArrayFromPropFile("book",propTable);
		 
		 //enum itemType { cdInfos, dvdInfos, bookInfos};
		 
		 int location = 1;
		 String itemType = "cdInfos";
		 
		 System.out.println(cdInfos[location][TITLE]);
		 String output = cdInfos[location][TITLE];
		 System.out.println(output);
		 
		 /*
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
		  
		  System.out.println("^^^^^^^" + bookInfos[3][ARTIST]);
		  
		  //String itemType = "bookInfos";
		  
		  // trying to make the database type selectable
		  
		  public enum itemType { cdInfos,dvdInfos,bookInfos };

		  
		  for (int i = 1; i < itemType.length; i++) 
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

		
	}
	

	
	/**
	* Creates two dimensional array from delineated string in properties file
	* @param propertyName name of the property as in the file
	* @param propFile the instance of the Properties file that has the property
	* @return two dimensional array
	*/
	
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
	

}
	
	
	
	
	
	
	
	
	
	/*
	private static String prodID = "ProductID";
	private static String prodIDnum = "1234";
	private String valueItem;

	Properties dataTable = new Properties();
	InvePersistanceTest db = new InvePersistanceTest();
//	Properties dataTable = new Properties();
//	FileInputStream ipFile = new FileInputStream("Inventory.properties");
//	OutputStream opFile = new FileOutputStream("Inventory.properties");


	
	public void setProdID(String prodIDnum)
	{
		this.prodIDnum = prodIDnum;
//		System.out.println("Debug: Pers: " + prodIDnum);
		
	}
	
	public String getProdID()
	{
		return prodIDnum;
	}
	
	public void writeNumber(String key, String value)
	{
		
	}
	
	public void writeDataStream(String prodIDnum) throws Exception
	{
//		InvePersistance db = new InvePersistance();
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
		

//		InvePersistance db = new InvePersistance();
//		Properties dataTable = new Properties();
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
		

//		InvePersistance db = new InvePersistance();
//		Properties dataTable = new Properties();
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
		

//		InvePersistance db = new InvePersistance();
//		Properties dataTable = new Properties();
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

	*/
//}