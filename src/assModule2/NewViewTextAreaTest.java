package assModule2;

import javax.swing.JFrame;

public class NewViewTextAreaTest
{
	public static void main(String[] args)
	{
		NewViewTextAreaFrame viewOne = new NewViewTextAreaFrame();
		viewOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewOne.setSize(770, 420);
		viewOne.setLocationRelativeTo(null);
		viewOne.setVisible(true);
	}
}