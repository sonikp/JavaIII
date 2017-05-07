package week3;
// fig 12.26

import javax.swing.JFrame;

public class MultipleSelectionTest
{
	public static void main(String[] args)
	{
		MultipleSelectionFrame multipleSelectionFrame = new MultipleSelectionFrame();
		multipleSelectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		multipleSelectionFrame.setSize(350, 150);
		multipleSelectionFrame.setLocationRelativeTo(null);
		multipleSelectionFrame.setVisible(true);
		
	}
}