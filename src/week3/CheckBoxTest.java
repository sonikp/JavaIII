package week3;

// fig 12.18

import javax.swing.JFrame;

public class CheckBoxTest
{
	public static void main(String[] args)
	{
		CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
		checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkBoxFrame.setSize(275,100);
		checkBoxFrame.setLocationRelativeTo(null);
		checkBoxFrame.setVisible(true);
	}
}