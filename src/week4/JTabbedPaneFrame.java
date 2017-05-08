package week4;
// fig 22.13

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;



public class JTabbedPaneFrame extends JFrame
{
	public JTabbedPaneFrame()
	{
		super("JTabbedPane demo");
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// set up panel 1 and add it to JTabbedPane
		JLabel label1 = new JLabel("panel one", SwingConstants.CENTER);
		JPanel panel1 = new JPanel();
		panel1.add(label1);
		tabbedPane.addTab("Tab One", null, panel1, "First Panel");
		
		// set up panel 2 and add it to JTabbedPane
		JLabel label2 = new JLabel("panel tw0", SwingConstants.CENTER);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.YELLOW);
		panel2.add(label2);
		tabbedPane.addTab("Tab Two", null, panel2, "Second Panel");
		
		// set up panel3 and add it to JTabbedPane
		JLabel label3 = new JLabel("panel three", SwingConstants.CENTER);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.add(new JButton("North"), BorderLayout.NORTH);
		panel3.add(new JButton("West"), BorderLayout.WEST);
		panel3.add(new JButton("East"), BorderLayout.EAST);
		panel3.add(new JButton("South"), BorderLayout.SOUTH);
		panel3.add(label3, BorderLayout.CENTER);
		tabbedPane.addTab("Tab Three", null, panel3, "Third Pane");
		
		add(tabbedPane);
	}
}	// end class JTabbedPane



























