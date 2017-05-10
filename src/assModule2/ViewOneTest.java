package assModule2;

import javax.swing.JFrame;

public class ViewOneTest
{
	public static void main(String[] args)
	{
		ViewOneFrame viewOne = new ViewOneFrame();
		viewOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewOne.setSize(300, 300);
		viewOne.setLocationRelativeTo(null);
		viewOne.setVisible(true);
	}
}