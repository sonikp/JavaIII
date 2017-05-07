package week3;
// fig 12.42

import javax.swing.JFrame;

public class BorderLayoutTest
{
	public static void main(String[] args)
	{
		BorderLayoutFrame borderLayoutFrame = new BorderLayoutFrame();
		borderLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayoutFrame.setSize(300, 200);
		borderLayoutFrame.setLocationRelativeTo(null);
		borderLayoutFrame.setVisible(true);
	}
}