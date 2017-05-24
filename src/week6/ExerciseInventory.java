package week6;

// inventory database exercise for ResultsSet to JTable

public class ExerciseInventory
{
	private int itemID;
	private String itemType;
	private String title;
	private String artist;
	private String productCode;
	private String quantity;

	
	// constructor
	public ExerciseInventory() {}
	
	// constructor
	public ExerciseInventory(String itemType, String title, String artist, String productCode, String quantity) //int itemID, 
	{
		setItemID(itemID);
		setItemType(itemType);
		setTitle(title);
		setArtist(artist);
		setProductCode(productCode);
		setQuantity(quantity);
	}
	
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


}