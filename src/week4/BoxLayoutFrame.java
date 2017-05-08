package week4;
// fig 22.16

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTabbedPane;


public class BoxLayoutFrame extends JFrame
{
	public BoxLayoutFrame()
	{
		super("BoxLayout Demo");
		
		// create Box containers with BoxLayout
		Box horizontal1 = Box.createHorizontalBox();
		Box vertical1 = Box.createVerticalBox();
		Box horizontal2 = Box.createHorizontalBox();
		Box vertical2 = Box.createVerticalBox();
		
		final int SIZE = 3;
		
		// add buttons to Box 
		for (int count = 0; count < SIZE; count++) {
			horizontal1.add(new JButton("Button " + count));
		}
		
		// create strut and add buttons to Box vertical
		for (int count = 0; count < SIZE; count++) {
			vertical2.add(Box.createVerticalStrut(25));
			vertical1.add(new JButton("Button " + count));
		}
		
		// create horizontal glue 
		for (int count = 0; count < SIZE; count++) {
			horizontal2.add(Box.createHorizontalGlue());
			horizontal2.add(new JButton("Button " + count));
		}
		
		// create rigid area and add buttons to Box vertical 2
		for (int count = 0; count < SIZE; count++) {
			vertical2.add(Box.createRigidArea(new Dimension(12, 8)));
			vertical2.add(new JButton("Button " + count));
		}
		
		// create vertical glue and add buttons to panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for (int count = 0; count < SIZE; count++) {
			panel.add(Box.createGlue());
			panel.add(new JButton("Button " + count));
		}
		
		// create a JTabbedPane
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		
		// place each container on tabbed pane
		tabs.addTab("Horizontal Box", horizontal1);
		tabs.addTab("Vertical Box with Struts", vertical1);
		tabs.addTab("Horizontal Box with Glue", horizontal2);
		tabs.addTab("Vertical Box with Rigid Area", vertical2);
		tabs.addTab("Vertical Box with Glue", panel);
		
		add(tabs);
		
	}
}


























