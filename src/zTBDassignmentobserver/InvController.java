package zTBDassignmentobserver;

import java.util.ArrayList;



public class InvController implements Subject
{
	
	private InvModel theModel;
	private InvView theView;
	
	private ArrayList<Inventory> viewer;
	private String name;
	private String title; 
	private String number;
	

	
	// constructor
	public InvController(){}

	public void getStoredValue(String input) throws Exception 
	{
		viewer = new ArrayList<Inventory>();
		System.out.println("DBug:Ctrlr:getStoredValue:input;  " + input);
		theModel.getStoredValue(input);
		
	}
	
	@Override
	public void register(Inventory theView) {
		// TODO Auto-generated method stub
		viewer.add(theView);
	}

	@Override
	public void unregister(Inventory theView) {
		// TODO Auto-generated method stub
		// Get the index of the observer to delete
		
		int viewerIndex = viewer.indexOf(theView);
		
		// Print out message (Have to increment index to match)
		
		System.out.println("Observer " + (viewerIndex+1) + " deleted");
		
		// Removes observer from the ArrayList
		
		viewer.remove(viewerIndex);
		
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Inventory view : viewer)
		{
			
			view.update(name, title, number);
		}
		
	}
	
	
	public void setName(String name){
		
		this.name = name;
		
		notifyObserver();
		
	}
	
	public void setTitle(String title){
		
		this.title = title;
		
		notifyObserver();
		
	}
	
	public void setNumber(String number){
		
		this.number = number;
		
		notifyObserver();
		
	}
	
	
	
	
	
	// setters and getters for the MVC objects
	public InvModel getTheModel() {
		return theModel;
	}


	public void setTheModel(InvModel theModel) {
		this.theModel = theModel;
	}


	public InvView getTheView() {
		return theView;
	}


	public void setTheView(InvView theView) {
		this.theView = theView;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//==========================Old Shit=============================
	/*
	
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
	
	*/
	
	
	
	
	/*
	public InvController()
	{
		// empty constructor
	}
	*/
	

	
	

/*
	class AddItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String prodNumber;
			try
			{
//				prodNumber = theView.getProdNumber();
//				theModel.setNumber(prodNumber);
				//theModel.setNumber(theView.getProdNumber()); //removed listener not implemented for a commandline app
//				System.out.println("Debug:Controller+addListener: " + prodNumber);
			}
			catch (NumberFormatException ex)
			{
				System.out.println(ex);
				
			}
		}
	}
	*/

}