package week4;

// fig 22.24

import javax.swing.JFrame;

public class GridBagTest2
{
	public static void main(String[] args)
	{
		GridBagFrame2 gridBagFrame2 = new GridBagFrame2();
		gridBagFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridBagFrame2.setSize(300, 200);
		gridBagFrame2.setLocationRelativeTo(null);
		gridBagFrame2.setVisible(true);
	}
}