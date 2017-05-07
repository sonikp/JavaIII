package week3;

import javax.swing.JFrame;

// fig 12.40

public class FlowLayoutTest
{
	public static void main(String[] args)
	{
		FlowLayoutFrame flowLayoutFrame = new FlowLayoutFrame();
		flowLayoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		flowLayoutFrame.setSize(300, 75);
		flowLayoutFrame.setLocationRelativeTo(null);
		flowLayoutFrame.setVisible(true);
	}
}