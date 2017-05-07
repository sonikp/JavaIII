package week3;

// fig 12.48

import javax.swing.JFrame;

public class TextAreaTest
{
	public static void main(String[] args)
	{
		TextAreaFrame textAreaFrame = new TextAreaFrame();
		textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textAreaFrame.setSize(425, 200);
		textAreaFrame.setLocationRelativeTo(null);
		textAreaFrame.setVisible(true);
	}
}