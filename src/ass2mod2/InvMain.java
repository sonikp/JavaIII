package ass2mod2;

import javax.swing.JFrame;

public class InvMain
{
	public static void main(String[] args)
	{
		InvView newViewFrameEDIT = new InvView();
		newViewFrameEDIT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newViewFrameEDIT.setSize(870, 420);
		newViewFrameEDIT.setLocationRelativeTo(null);
		newViewFrameEDIT.setVisible(true);
	}
}