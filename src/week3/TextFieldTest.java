package week3;

// Fig 12.10

import javax.swing.JFrame;

public class TextFieldTest
{
	public static void main(String[] args)
	{
		TextFieldFrame textFieldFrame = new TextFieldFrame();
		textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textFieldFrame.setSize(350, 100);
		textFieldFrame.setLocationRelativeTo(null);
		textFieldFrame.setVisible(true);
	}
}