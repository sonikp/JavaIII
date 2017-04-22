package assgn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvController
{
	private InvView theView;
	private InvModel theModel;
	
	public InvController(InvView theView, InvModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addCalculateListener(new CalculateListener());
	}
	
	
	class CalculateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			int firstNumber = 0;
			int secondNumber = 0;
			try
			{
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				
//				theModel.setNumber(firstNumber);
				
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
	
	

	
	

}