package assgn.mod;


import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class InvePersistance extends Properties 
{

	private static String prodID = "ProductID";
	private static String prodIDnum = "1234";
	private String valueItem;

//	Properties dataTable = new Properties();
//	InvePersistance db = new InvePersistance();
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
		Properties dataTable = new Properties();
		InvePersistance db = new InvePersistance();
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
		

		InvePersistance db = new InvePersistance();
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
		

		InvePersistance db = new InvePersistance();
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
		

		InvePersistance db = new InvePersistance();
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

	
}