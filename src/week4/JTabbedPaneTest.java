package week4;
// fig 22.14

import javax.swing.JFrame;

public class JTabbedPaneTest
{
	public static void main(String[] args)
	{
		JTabbedPaneFrame tabbedPaneFrame = new JTabbedPaneFrame();
		tabbedPaneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tabbedPaneFrame.setSize(250,200);
		tabbedPaneFrame.setLocationRelativeTo(null);
		tabbedPaneFrame.setVisible(true);
	}
}