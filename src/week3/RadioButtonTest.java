package week3;
//fig 12.20

import javax.swing.JFrame;

public class RadioButtonTest
{
	public static void main(String[] args)
	{
		RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
		radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		radioButtonFrame.setSize(300,100);
		radioButtonFrame.setLocationRelativeTo(null);
		radioButtonFrame.setVisible(true);
	}
}