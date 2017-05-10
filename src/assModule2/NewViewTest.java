package assModule2;

import javax.swing.JFrame;

public class NewViewTest
{
	public static void main(String[] args)
	{
		NewViewFrame viewOne = new NewViewFrame();
		viewOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewOne.setSize(770, 420);
		viewOne.setLocationRelativeTo(null);
		viewOne.setVisible(true);
	}
}