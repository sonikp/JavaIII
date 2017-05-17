package zTBDassignment2module2BKUP;

public class InventoryBOOK extends InventoryItems {
	
		
	private String author;
	private String ISBN;
	
	public InventoryBOOK(){}
	
	public InventoryBOOK(String name, String author, String ISBN, String quantity){
		super(name, quantity);
		this.author = author;
		this.ISBN = ISBN;
	}

	public String getArtist() {
		return author;
	}

	public void setArtist(String author) {
		this.author = author;
	}

	public String getProductCode() {
		return ISBN;
	}

	public void setProductCode(String ISBN) {
		this.ISBN = ISBN;
	}

	
	
}