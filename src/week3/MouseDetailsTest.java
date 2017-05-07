package week3;

import javax.swing.JFrame;

// fig 12.32

public class MouseDetailsTest
{
	public static void main(String[] args)
	{
		MouseDetailsFrame mouseDetailFrame = new MouseDetailsFrame();
		mouseDetailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseDetailFrame.setSize(400, 150);
		mouseDetailFrame.setLocationRelativeTo(null);
		mouseDetailFrame.setVisible(true);
	}
}