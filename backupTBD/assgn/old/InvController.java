package assgn.old;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assgn.InvModel;
import assgn.InvView;

public class InvController
{
	private InvView theView;
	private InvModel theModel;
	
	public InvController(InvView theView, InvModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addNumberListener(new AddItemListener());
		
//		this.theView.addCalculateListener(new CalculateListener());
	}
	
	
	class AddItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String prodNumber;
			try
			{
				prodNumber = theView.getProdNumber();
				theModel.setNumber(prodNumber);
				System.out.println("Debug:Controller+addListener: " + prodNumber);
			}
			catch (NumberFormatException ex)
			{
				System.out.println(ex);
				
			}
		}
	}
	
	/*
	class CalculateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String prodNumber;
			int firstNumber = 0;
			int secondNumber = 0;
			try
			{
				prodNumber = theView.getProdNumber();
				theModel.setNumber(prodNumber);
				System.out.println("Debug:Controller+calculateListener: " + prodNumber);
				
				
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				

				
				theModel.addTwoNumbers(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue());
				//theView.setCalcSolution(theModel.getNumber());
				
			}
			catch (NumberFormatException ex)
			{
				System.out.println(ex);
				
				
			}
		}
		
	}
	*/
	

	
	

}