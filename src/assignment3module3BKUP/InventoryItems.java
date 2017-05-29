package assignment3module3BKUP;

abstract class InventoryItems{

	private String title;
	private String artist;
	private String productCode;
	private String quantity;
	
	// constructors
	public InventoryItems(){}
	
	public InventoryItems(String title, String quantity){
		this.title = title;
		this.quantity = quantity;
	}
	
	public InventoryItems(String title, String artist, String productCode, String quantity){
		this.title = title;
		this.artist = artist;
		this.productCode = productCode;
		this.quantity = quantity;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	abstract public String getArtist(); 
	
	abstract public void setArtist(String artist);
	
	abstract public String getProductCode();
	
	abstract public void setProductCode(String productCode);
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}