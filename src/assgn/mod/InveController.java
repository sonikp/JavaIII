package assgn.mod;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InveController
{
	private InveView theView;
	private InveModel theModel;
	
	
	

	
	
	
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
	
	
	
	
	
	
	
	public InveController()
	{
		// empty constructor
	}
	
	public InveController(InveView theView, InveModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		
		//this.theView.addNumberListener(new AddItemListener());
		
	}
	
	
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
	

}