package week4;

// fig 22.6

import javax.swing.JFrame;

public class MenuTest
{
	public static void main(String[] args)
	{
		MenuFrame menuFrame = new MenuFrame();
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(500, 200);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setVisible(true);
	}
}