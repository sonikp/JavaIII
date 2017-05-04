package testing;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import zTBDassignmentobserver.InvPersistance;
import zTBDassignmentobserver.InvPersistance.ItemType;

public class TestENUMCreate
{
	static private String cdNextItemNum;
	static private String dvdNextItemNum;
	static private String bookNextItemNum;
	
	public enum ItemType { CD,DVD,BOOK };
	
	
	public void createNewInventorySelectType(String itemType, String title, String artist, String productCode, String quantity) throws Exception
	{
		
		cdNextItemNum = "105";
		System.out.println("$$$$$$$$4" + itemType );
		

		ItemType typeEnum = ItemType.valueOf(itemType);
		
        switch (typeEnum)

        
        {


			case CD : 
        		System.out.println("Chose: CD: \t");
        		
        		String itemNum = cdNextItemNum;
        		itemType = "CD";
        		this.createInventoryEntry(itemNum, itemType, title, artist, productCode, quantity );
//        		this.updateCDNextItemNum(cdNextItemNum);
        		cdNextItemNum = String.valueOf(Integer.parseInt(cdNextItemNum) + 1);
        		break;
        	case DVD : 
        		System.out.println("Chose: DVD: \t");
        		break;
        	case BOOK : 
        		System.out.println("Chose: Books: \t");
        		break;
        	
        }
        
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		TestENUMCreate tc = new TestENUMCreate();
		tc.createNewInventoryItem();
		System.out.println(cdNextItemNum);
	}
	
	
	
	
	public void createNewInventoryItem() throws Exception
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("CREATE a NEW number in the inventory."
				+ "\nPlease enter the item details & hit <enter> for each item\n"
				+ "For Item Type, enter, CD, DVD, BOOK\nItem Type: ");	// TODO: implement ENUMS here
		String itemType = scanner.nextLine().toUpperCase();
		
		System.out.println("Title: ");
		String title = scanner.nextLine();
		
		System.out.println("Artist: ");
		String artist = scanner.nextLine();
		
		System.out.println("ProductCode: ");
		String productCode = scanner.nextLine();
		
		System.out.println("Quantity:");
		String quantity = scanner.nextLine();
		
		this.createNewInventorySelectType(itemType, title, artist, productCode, quantity);
		
	}
	
	// CREATE
	public void createInventoryEntry(String itemNum, String itemType, String title, String artist, String productCode, String quantity)throws Exception
	{
		
		
		System.out.println(itemNum + itemType + title + artist + productCode + quantity);
		
		/*
		OutputStream outputFile = new FileOutputStream(propertiesFilename);
		String updatedTitle = InvPersistance.toTitleCase(title);
		String updatedArtist = InvPersistance.toTitleCase(artist);
		
		System.out.println(updatedTitle + " " + updatedArtist);

		
		String joinedUpdate = String.join(",", itemType.toUpperCase(),updatedTitle,updatedArtist,productCode,quantity);
		

		propertiesTable.put(itemNum, joinedUpdate);
		propertiesTable.store(outputFile, "updated");	
		propertiesTable.list(System.out);
		*/
	}
	
}