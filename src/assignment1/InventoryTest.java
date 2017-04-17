package assignment1;

public class InventoryTest
{
	
	public enum ItemType 
	{
		Angie_Stone ("cd", "Black Diamond", "LS5784", 15.22, 7), 
		Alice_Russell ("dvd", "Fly In The Hand", "TBM345984", 13.67, 9),
		Bill_Withers ("cd", "Still Bill", "T-39GG5784", 11.21, 1),
		Bootsy_Collins ("book", "Play With Bootsy", "ERT945864", 17.96, 5),
		James_Brown ("cd", "Cold Sweat", "WW4095604", 23.96, 6);
	
		
		private String itemType;
		private String title;
		private String productID; 
		private double unitPrice;
		private int unitsInStock;
 
		private ItemType(String itemType, String title, String productID, double unitPrice, int unitsInStock) 
		{
			this.itemType = itemType;
			this.title = title;
			this.productID = productID;
			this.unitPrice = unitPrice;
			this.unitsInStock = unitsInStock;
		}
	}
 
	public static void main(String[] args) {
		System.out.println("-----Inventory Items----");
		for (ItemType inventory : ItemType.values()) {
			System.out.println("Item Type: " + inventory.itemType
					+ " - Item Name: " + inventory.title
					+ " - Item productID: " + inventory.productID
					+ " - Item Price: " + inventory.unitPrice
					+ " - Item In Stock: " + inventory.unitPrice);

		}
	}
	



}