package week3;
// fig 12.21

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame
{
	private final JComboBox<String> imagesJComboBox;	// holds icon names
	private final JLabel label; // displays selected icon
	
	private static final String names[] = { "bug1.png", "bug2.png", "bug3.png", "bug4.png", "bug5.png", "bug-icon.png" };
	
	private final Icon icon[] = {
			new ImageIcon(getClass().getResource(names[0])),
			new ImageIcon(getClass().getResource(names[1])),
			new ImageIcon(getClass().getResource(names[2])),
			new ImageIcon(getClass().getResource(names[3])),
			new ImageIcon(getClass().getResource(names[4])),
			new ImageIcon(getClass().getResource(names[5])) };
	
	// CoonboBoxFrame constructor
	public ComboBoxFrame()
	{
		super("JComboBox");
		setLayout(new FlowLayout());
		
		imagesJComboBox = new JComboBox<String>(names);
		imagesJComboBox.setMaximumRowCount(3);
		
		imagesJComboBox .addItemListener(new ItemListener() // anonymous inner class
		{
			// handle JComboBox event 
			@Override
			public void itemStateChanged(ItemEvent event)
			{
				if (event.getStateChange() == ItemEvent.SELECTED)
					label.setIcon(icon[imagesJComboBox.getSelectedIndex()]);
			} 
		} // end anonymous inner class
		);  // end call to addItemListener
		
		add(imagesJComboBox);
		label = new JLabel(icon[0]);
		add(label);
	}
}
















