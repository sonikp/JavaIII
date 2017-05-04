package assigment1module1FIX;

public class InventoryCD extends InventoryItems {
	
	
	private String artist;
	private String productCode;
	
	public InventoryCD(){}
	
	public InventoryCD(String name, String artist, String productCode, String quantity){
		super(name, quantity);
		this.artist = artist;
		this.productCode = productCode;

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
	
	

	
}