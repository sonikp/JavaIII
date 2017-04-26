package testing;

import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReTestProperties extends Properties
{
	
	static Properties propertyTable = new Properties();
//	static ReTestProperties rt = new ReTestProperties();
	
	public ReTestProperties() throws Exception
	{
//		this.rt = rt;
//		this.storeData();
	}
	
	public void storeData() throws Exception
	{
		// 1. Set properties file
		OutputStream outputFile = new FileOutputStream("retestStore.properties");
		
		propertyTable.setProperty("name", "Angie Stone");
		propertyTable.setProperty("title", "Fly In The Hand");
		propertyTable.setProperty("number", "TBM345984");
		
		// push to properties properties file
		propertyTable.store(outputFile, "Test Inventory Data");	// first entry in the file and explains the purpose of the file
		outputFile.close();
	}
	
	public void readData() throws Exception
	{
		// 2. read from properties file
		FileInputStream inputFile = new FileInputStream("retestStore.properties"); // StoredInventory.properties
		
		// load property file
		propertyTable.load(inputFile);

		
		System.out.println("\nLets try listing all the properties\n");
		propertyTable.list(System.out);
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		ReTestProperties rt = new ReTestProperties();
		
		rt.storeData();
		rt.readData();
		
		

		

	}
	
	
}
