package week3;
// fig 12.34

import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PaintPanel extends JPanel
{
	private final ArrayList<Point> points = new ArrayList<>();
	
	// set up GUI and register mouse event handler
	public PaintPanel()
	{
		
		
		// handle frame mouse motion event
		addMouseMotionListener(new MouseMotionAdapter() {
			// store drag coordinates and repaint
			@Override
			public void mouseDragged(MouseEvent event) {
				points.add(event.getPoint());
				repaint();
			}
			
		});
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		// draw all points
		for (Point point : points)
		{
			g.fillOval(point.x, point.y, 4, 4);
		}
	}
	
}













