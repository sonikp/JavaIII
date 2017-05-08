package week4;
// fig 22.17

import javax.swing.JFrame;

public class BoxLayoutTest
{
	public static void main(String[] args)
	{
		BoxLayoutFrame boxLayoutFrame = new BoxLayoutFrame();
		boxLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boxLayoutFrame.setSize(400, 220);
		boxLayoutFrame.setLocationRelativeTo(null);
		boxLayoutFrame.setVisible(true);
	}
}