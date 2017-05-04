package zTBDassignment1OLD;

/**
 * Working with propertied
 * https://www.youtube.com/watch?v=w7D5YB2U2jU
 */

import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;



public class PersistenceToProperties
{
	public static void main(String[] args) throws Exception
	{
		Properties propTable = new Properties();
		

		
		// 1. write to a properties file
		OutputStream opFile = new FileOutputStream("Inventory.properties");
		
		propTable.setProperty("cd:LS5784", "Angie Stone:Black Diamond:15.22:7");
		propTable.setProperty("dvd:TBM345984", "Alice Russell:Fly In The Hand:13.67:9");
		propTable.setProperty("cd:T-39GG5784", "Bill Withers:Still Bill::11.21:1");
		propTable.setProperty("book:ERT945864", "Bootsy Collins:Play With Bootsy:17.96:5");
		propTable.setProperty("cd:WW4095604", "James Brown:Cold Sweat:23.96:6");
		
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
		
		
		/*
		// 2. read from properties file
		FileInputStream ipFile = new FileInputStream("dataConfig.properties"); 
		
		// load property file
		propTable.load(ipFile);
		
		System.out.println(propTable.getProperty("uname"));
		System.out.println(propTable.getProperty("url"));
		System.out.println(propTable.getProperty("passwd"));
		
		System.out.println("\nLets try listing all the properties\n");
		propTable.list(System.out);
		*/
		
	}
}