package assignment1;

public class MyInventoryMain
{
	public static void main(String[] args)
	{
		
		System.out.println("MyInventorySystem \n");
		
		InventoryModel theModel = new InventoryModel();
		
		
		
		theModel.setTitle("Great Book");
		
		System.out.println("Book Title: " + theModel.getTitle());
		
		InventoryBooks theBooks = new InventoryBooks();
		theBooks.setTitle("This is a book");
		System.out.println("BookInventory: " + theBooks.getTitle());
		
		InventoryCD theCDs = new InventoryCD();
		theCDs.setTitle("This is a CD");
		System.out.println("CD Inventory: " + theCDs.getTitle());
		
		
		
	}
}