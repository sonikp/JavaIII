package assignment1;


public class InventoryController
{
	
	private InventoryView theView;
	private InventoryController theController;
	private InventoryModel theModel;
	
	public InventoryController(InventoryView theView, InventoryModel theModel) 
	{
		this.theView = theView;
		this.theModel = theModel;
	}
	
}