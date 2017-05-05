package week3;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class LabelFrame extends JFrame
{
	
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	
	public LabelFrame()
	{
		super("Testing JLabel");
		setLayout(new FlowLayout());
		label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		add(label1);
		
		Icon bug = new ImageIcon(getClass().getResource("bug-icon.png")); // icon needs to be in the ./bin/week3 
		
		label2 = new JLabel("Label with text & icon", bug, SwingConstants.LEFT);
		label2.setToolTipText("This is label1");
		add(label2);
		
		label3 = new JLabel("Label with text & icon at bottom");
		label3.setToolTipText("This is label1");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
	}
	

}
	









