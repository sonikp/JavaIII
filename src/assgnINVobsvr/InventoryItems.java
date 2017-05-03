package assgnINVobsvr;

public class InventoryItems{

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