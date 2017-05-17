package zTBDassModule2;

import javax.swing.JFrame;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println("TestTEstText!!");
		NewViewFrameEDIT newViewFrameEDIT = new NewViewFrameEDIT();
		newViewFrameEDIT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newViewFrameEDIT.setSize(770, 420);
		newViewFrameEDIT.setLocationRelativeTo(null);
		newViewFrameEDIT.setVisible(true);
	}
}