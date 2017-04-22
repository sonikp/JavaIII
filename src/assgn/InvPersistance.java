package assgn;


import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class InvPersistance extends Properties
{
	private static String prodID = "ProductID";
	private static String prodIDnum = "1234";
	
	public void setProdID(String prodIDnum)
	{
		this.prodIDnum = prodIDnum;
	}
	
	public String getProdID()
	{
		return prodIDnum;
	}
	
	public void writeNumber(String key, String value)
	{
		
	}

	
	public static void main(String[] args) throws Exception
	{

		InvPersistance db = new InvPersistance();
		Properties dataTable = new Properties();
		db.setProdID("3333");

		
	
		
		
		
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
	
}