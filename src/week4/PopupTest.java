package week4;
// fig 22.8

import javax.swing.JFrame;

public class PopupTest
{
	public static void main(String[] args)
	{
		PopupFrame popupFrame = new PopupFrame();
		popupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popupFrame.setSize(300, 200);
		popupFrame.setLocationRelativeTo(null);
		popupFrame.setVisible(true);
	}
}