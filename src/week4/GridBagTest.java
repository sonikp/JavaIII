package week4;

// fig 22.22

import javax.swing.JFrame;

public class GridBagTest
{
	public static void main(String[] args)
	{
		GridBagFrame gridBagFrame = new GridBagFrame();
		gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridBagFrame.setSize(300, 150);
		gridBagFrame.setLocationRelativeTo(null);
		gridBagFrame.setVisible(true);
	}
}