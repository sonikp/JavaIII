package week3;
// fig 12.29

import javax.swing.JFrame;

public class MouseTrackerTest
{
	public static void main(String[] args)
	{
		MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
		mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseTrackerFrame.setSize(350, 150);
		mouseTrackerFrame.setLocationRelativeTo(null);
		mouseTrackerFrame.setVisible(true);
	}
	
}