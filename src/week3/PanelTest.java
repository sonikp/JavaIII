package week3;

import javax.swing.JFrame;

// fig 12.46

public class PanelTest
{
	public static void main(String[] args)
	{
		PanelFrame panelFrame = new PanelFrame();
		panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelFrame.setSize(450, 200);
		panelFrame.setLocationRelativeTo(null);
		panelFrame.setVisible(true);
	}
}