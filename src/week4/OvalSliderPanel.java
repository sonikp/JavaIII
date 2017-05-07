package week4;

// fig 22.2

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

public class OvalSliderPanel extends JPanel
{
	private int diameter = 10;
	
	// draw an oval of the specified diameter
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(10, 10, diameter, diameter);
	}
	
	// validate and set diameter, then repaint
	public void setDiampeter(int newDiameter) {
		// if diameter invalid, default to 10
		diameter = (newDiameter >= 0 ? newDiameter : 10);
		repaint();
	}
	
	// used by layout manager to determine preferred size
	public Dimension getPrefferedSize() {
		return new Dimension(200, 200);
	}
	
	// used by layout manager to determine minimum size
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	
}





















