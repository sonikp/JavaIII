package week3;

import javax.swing.JOptionPane;

public class Addition
{
	
	public static void main(String[] args)
	{
		String firstNumber = JOptionPane.showInputDialog("Enter First Number");
		String secondNumber = JOptionPane.showInputDialog("Enter Second Number");
		
		// convert String input to integers
		int number1 = Integer.parseInt(firstNumber);
		int number2 = Integer.parseInt(secondNumber);
		
		int sum = number1 + number2;
		
		// display output 
		JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
	}
	
}