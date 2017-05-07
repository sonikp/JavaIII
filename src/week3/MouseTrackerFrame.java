package week3;
// fig 12.28

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame
{
	private final JPanel mousePanel;
	private final JLabel statusBar;
	
	// MouseTrackerFrame constructor sets up GUI and registers mouse event handlers
	public MouseTrackerFrame()
	{
		super("Demo of mouse events");
		

		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);
		
		statusBar = new JLabel("mouse outside of panel");
		add(statusBar, BorderLayout.SOUTH);
		
		// event handler
		MouseHandler mouseHandler = new MouseHandler();
		mousePanel.addMouseListener(mouseHandler);
		mousePanel.addMouseMotionListener(mouseHandler);
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener {
		// MouseListener event handlers
		// handle events when mouse released immediately after press
		@Override
		public void mouseClicked(MouseEvent event)
		{
			statusBar.setText(String.format("Clicked at [%d, %d]", event.getX(), event.getY()));
		}
		
		@Override
		public void mousePressed(MouseEvent event)
		{
			statusBar.setText(String.format("Pressed at [%d, %d]", event.getX(), event.getY()));
		}
		
		@Override
		public void mouseReleased(MouseEvent event)
		{
			statusBar.setText(String.format("Released at [%d, %d]", event.getX(), event.getY()));
		}
		
		@Override
		public void mouseEntered(MouseEvent event)
		{
			statusBar.setText(String.format("Entered at [%d, %d]", event.getX(), event.getY()));
			mousePanel.setBackground(Color.GREEN);
		}
		
		@Override
		public void mouseExited(MouseEvent event)
		{
			statusBar.setText("Mouse outside of JPanel");
			mousePanel.setBackground(Color.WHITE);
		}
		
		@Override
		public void mouseDragged(MouseEvent event)
		{
			statusBar.setText(String.format("Dragged at [%d, %d]", event.getX(), event.getY()));
			mousePanel.setBackground(Color.WHITE);
		}
		
		@Override
		public void mouseMoved(MouseEvent event)
		{
			statusBar.setText(String.format("Moved at [%d, %d]", event.getX(), event.getY()));
			mousePanel.setBackground(Color.WHITE);
		}
		
	}
}















