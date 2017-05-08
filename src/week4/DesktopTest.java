package week4;
// fig 22.12

import javax.swing.JFrame;

public class DesktopTest
{
	public static void main(String[] args)
	{
		DesktopFrame desktopFrame = new DesktopFrame();
		desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopFrame.setSize(600, 400);
		desktopFrame.setLocationRelativeTo(null);
		desktopFrame.setVisible(true);
	}
}