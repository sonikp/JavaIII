package week3;
//fig 12.24

import javax.swing.JFrame;

public class ListTest
{
	public static void main(String[] args)
	{
		ListFrame listFrame = new ListFrame();
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(350, 150);
		listFrame.setLocationRelativeTo(null);
		listFrame.setVisible(true);
	}
}