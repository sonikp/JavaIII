package week3;
// fig 12.37

import javax.swing.JFrame;

public class KeyDemoTest
{
	public static void main(String[] args)
	{
		KeyDemoFrame keyDemoFrame = new KeyDemoFrame();
		keyDemoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keyDemoFrame.setSize(350, 150);
		keyDemoFrame.setLocationRelativeTo(null);
		keyDemoFrame.setVisible(true);
		
	}
}