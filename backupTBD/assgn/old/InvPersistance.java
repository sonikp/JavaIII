package assgn.old;


import java.util.Properties;

import TBD.InvPersistanceOLD;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.util.Enumeration;
//import java.io.File;

public class InvPersistance extends Properties 
{

	private static String prodID = "ProductID";
	private static String prodIDnum = "1234";

	Properties dataTable = new Properties();

//	System.out.println("Debug writeDataStream: "+ db.getProdID());
	
	public void setProdID(String prodIDnum)
	{
		this.prodIDnum = prodIDnum;
		System.out.println("Debug: Pers: " + prodIDnum);
		
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
		InvPersistance db = new InvPersistance();
		OutputStream opFile = new FileOutputStream("Inventory.properties");
		System.out.println("Debug writeDataStream: "+ db.getProdID());
		
		try {
			dataTable.setProperty("title", "JavaSounds");
			dataTable.setProperty("ProductID", db.getProdID());

			dataTable.store(opFile, "Inventory Data");	// first entry in the file and explains the purpose of the file
			opFile.close();

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readDataStream(String prodIDnum) throws Exception
	{
		/*
		
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("Inventory.properties"); 
		
		// load property file
		dataTable.load(ipFile);
		
		System.out.println("\n");
		System.out.println("title:\t " + dataTable.getProperty("title"));
		System.out.println("ProductID: " + dataTable.getProperty("ProductID"));
		
		
		*/

		InvPersistance db = new InvPersistance();
		Properties dataTable = new Properties();
		FileInputStream ipFile = new FileInputStream("Inventory.properties");
		System.out.println("Debug readDataStream: "+ db.getProdID());
		
		try {
			
			// load property file
			dataTable.load(ipFile);
			
			System.out.println("\n");
			System.out.println("title:\t " + dataTable.getProperty("title"));
			System.out.println("ProductID: " + dataTable.getProperty("ProductID"));
			
			/*
			File file = new File("test.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);
			}
			*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		InvPersistance db = new InvPersistance();
		Properties dataTable = new Properties();
		OutputStream opFile = new FileOutputStream("Inventory.properties");
		System.out.println("Debug writeDataStream: "+ db.getProdID());
		*/

		
	}

	/*
	public static void main(String[] args) throws Exception
	{

		InvPersistance db = new InvPersistance();
		Properties dataTable = new Properties();
//		db.setProdID("3333");
		System.out.println("Debug main: "+ db.getProdID());

		
	
		
		
		
		// 1. write to a properties file
		OutputStream opFile = new FileOutputStream("Inventory.properties");
		
		
		System.out.println("-" + db.getProdID());

		
		dataTable.setProperty("title", "JavaSounds");
		dataTable.setProperty("ProductID", db.getProdID());

		dataTable.store(opFile, "Inventory Data");	// first entry in the file and explains the purpose of the file
		opFile.close();
		
		
		
		
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("Inventory.properties"); 
		
		// load property file
		dataTable.load(ipFile);
		
		System.out.println("\n");
		System.out.println("title:\t " + dataTable.getProperty("title"));
		System.out.println("ProductID: " + dataTable.getProperty("ProductID"));
		
		
		
	}
	*/
}