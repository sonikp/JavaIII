package week3;

// fig 12.16

import javax.swing.JFrame;

public class ButtonTest
{
	public static void main(String[] args)
	{
		ButtonFrame buttonFrame = new ButtonFrame();
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setSize(275,100);
		buttonFrame.setVisible(true);
		
	}
}