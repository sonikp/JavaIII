package assigment1module1;

public class InventoryDVD extends InventoryItems {
	
	
	private String studio;
	private String UPCCode;
	
	public InventoryDVD(){}
	
	public InventoryDVD(String name, String studio, String UPCCode, String quantity){
		super(name, quantity);
		this.studio = studio;
		this.UPCCode = UPCCode;

	}

	public String getArtist() {
		return studio;
	}

	public void setArtist(String studio) {
		this.studio = studio;
	}

	public String getProductCode() {
		return UPCCode;
	}

	public void setProductCode(String uPCCode) {
		UPCCode = uPCCode;
	}


	
}