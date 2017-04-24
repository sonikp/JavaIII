package assgn.add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InveController
{
	private InveView theView;
	private InveModel theModel;
	
	public InveController(InveView theView, InveModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addNumberListener(new AddItemListener());
		
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
				theModel.setNumber(theView.getProdNumber());
//				System.out.println("Debug:Controller+addListener: " + prodNumber);
			}
			catch (NumberFormatException ex)
			{
				System.out.println(ex);
				
			}
		}
	}
	

}