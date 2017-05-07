package week4;
// fig 22.4

import javax.swing.JFrame;

public class OvalSliderDemo
{
	public static void main(String[] args)
	{
		OvalSliderFrame ovalSliderFrame = new OvalSliderFrame();
		ovalSliderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ovalSliderFrame.setSize(220, 270);
		ovalSliderFrame.setLocationRelativeTo(null);
		ovalSliderFrame.setVisible(true);
	}
}