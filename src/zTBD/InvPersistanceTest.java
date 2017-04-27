package zTBD;


import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class InvPersistanceTest extends Properties 
{
	
	StringBuilder buffer = new StringBuilder();
	static Properties propTable = new Properties();
	
	public static void main(String[] args) throws Exception
	{
		
		

		
		// 1. write to a properties file
		OutputStream opFile = new FileOutputStream("InventoryStore.properties");
		
		
		propTable.setProperty("cd", "Angie Stone:Black Diamond:15.22:7");
		propTable.setProperty("dvd", "Alice Russell:Fly In The Hand:13.67:9");
		propTable.setProperty("book", "Bootsy Collins:Play With Bootsy:17.96:5");
//		propTable.setProperty("cd", "Bill Withers:Still Bill:11.21:1");
//		propTable.setProperty("dvd", "James Brown:Cold Sweat:23.96:6");
//		propTable.setProperty("book", "Bootsy Collins:Play With Bootsy:17.96:5");

		
		
		
		/*
		propTable.setProperty("cd:LS5784", "Angie Stone:Black Diamond:15.22:7");
		propTable.setProperty("dvd:TBM345984", "Alice Russell:Fly In The Hand:13.67:9");
		propTable.setProperty("cd:T-39GG5784", "Bill Withers:Still Bill:11.21:1");
		propTable.setProperty("book:ERT945864", "Bootsy Collins:Play With Bootsy:17.96:5");
		propTable.setProperty("cd:WW4095604", "James Brown:Cold Sweat:23.96:6");
		*/
		
		// push to properties properties file
		propTable.store(opFile, "Inventory Data");	// first entry in the file and explains the purpose of the file
		opFile.close();
		
		/*
		// set properties
		p.setProperty("url", "localhost:3306/myDB");
		p.setProperty("uname", "bobby");
		p.setProperty("passwd", "letmein!");
		
		// set properties
		p.setProperty("Angie_Stone", "cd:Black Diamond:LS5784:15.22:7");
		p.setProperty("Alice_Russell", "dvd:Fly In The TBM345984:13.67:9");
		p.setProperty("Bill_Withers", "cd:Still Bill:T-39GG5784:11.21:1");
		p.setProperty("Bootsy_Collins", "book:Play With Bootsy:ERT945864:17.96:5");
		p.setProperty("James_Brown", "cd:Cold Sweat:WW4095604:23.96:6");
	
		// push to properties properties file
		p.store(outFile, null);
		*/
		
		
		
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("InventoryStore.properties"); 
		
		// load property file
		propTable.load(ipFile);
		/*
		System.out.println(propTable.getProperty("uname"));
		System.out.println(propTable.getProperty("url"));
		System.out.println(propTable.getProperty("passwd"));
		*/
		
		System.out.println("\nLets try listing all the properties\n");
		propTable.list(System.out);
		
		String[] values = propTable.getProperty("book").toString().split(":");
		System.out.print(values[1]);
		
		

		
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
}