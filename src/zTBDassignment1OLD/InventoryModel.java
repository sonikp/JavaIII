package zTBDassignment1OLD;

public class InventoryModel
{
	private String title;
	private int productID; 
	private double unitPrice;
	private int unitsInStock;
	private enum itemType { cd, dvd, book, };
	
	// constructor
	public InventoryModel()
	{
		
	}
	

	
	// ---setters & getters
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setProductID(int newProductID)
	{
		productID = newProductID;
	}
	
	public int getProductID()
	{
		return productID;
	}
	
	public void setUnitPrice(double newUnitPrice)
	{
		unitPrice = newUnitPrice;
	}
	
	public double getUnitPrice()
	{
		return unitPrice;
	}
	
	public void setUnitsInStock(int newUnitsInStock)
	{
		unitsInStock = newUnitsInStock;
	}
	
	public double setUnitsInStock()
	{
		return unitsInStock;
	}
	
	// CRUD methods (Create, Retrieve, Update, and Delete)
	public void addItem(String updateTitle, int updateProductID, double updateUnitPrice, int updateUnitsInStock)
	{
		this.title = updateTitle;
		this.productID = updateProductID; 
		this.unitPrice = updateUnitPrice;
		this.unitsInStock = updateUnitsInStock;
	}
	
	public InventoryModel getItem()
	{
		InventoryModel item = new InventoryModel();
		return item;
	}
	
	public void updateItem(String updateTitle, int updateProductID, double updateUnitPrice, int updateUnitsInStock)
	{
		this.title = updateTitle;
		this.productID = updateProductID; 
		this.unitPrice = updateUnitPrice;
		this.unitsInStock = updateUnitsInStock;
	}
	
	public void deleteItem()
	{
		// delete item from persistence
	}

	public String toString()
	{
		 return "title: " + title + 
				 "productID: " + productID + 
				 "unitPrice: " + unitPrice + 
				 "unitsInStock: " + unitsInStock;
		 
	}
	
	
}