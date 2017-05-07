package week3;
// fig 12.44

import javax.swing.JFrame;

public class GridLayoutTest
{
	public static void main(String[] args)
	{
		GridLayoutFrame gridLayoutFrame = new GridLayoutFrame();
		gridLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridLayoutFrame.setSize(300, 200);
		gridLayoutFrame.setLocationRelativeTo(null);
		gridLayoutFrame.setVisible(true);
	}
}