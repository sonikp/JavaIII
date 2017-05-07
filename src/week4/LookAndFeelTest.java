package week4;
// fig 22.10

import javax.swing.JFrame;

public class LookAndFeelTest
{
	public static void main(String[] args)
	{
		LookAndFeelFrame lookAndFeelFrame = new LookAndFeelFrame();
		lookAndFeelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lookAndFeelFrame.setSize(400, 220);
		lookAndFeelFrame.setLocationRelativeTo(null);
		lookAndFeelFrame.setVisible(true);
	}
}