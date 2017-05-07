package week4;
// fig 22.9

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LookAndFeelFrame extends JFrame
{
	private final UIManager.LookAndFeelInfo[] looks;
	private final String lookNames[];
	private final JRadioButton radio[];
	private final ButtonGroup group;
	private final JButton button;
	private final JLabel label;
	private final JComboBox<String> comboBox;
	
	public LookAndFeelFrame()
	{
		super("Look and feel demo");
		
		// get installed look-and-feel information
		looks = UIManager.getInstalledLookAndFeels();
		lookNames = new String[looks.length];
		
		// get names of installed look-and-feels
		for (int i = 0; i < looks.length; i++) {
			lookNames[i] = looks[i].getName();
		}
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 1, 0, 5));
		
		label = new JLabel("This is a " + lookNames[0] + " look-and-feel", SwingConstants.CENTER);
		northPanel.add(label);
		
		button = new JButton("JButton");
		northPanel.add(button);
		
		comboBox = new JComboBox<String>(lookNames);
		northPanel.add(comboBox);
		
		// create array for radio buttons
		radio = new JRadioButton[looks.length];
		
		JPanel southPanel = new JPanel();
		
		// use a GridLayout with 3 buttons in each row
		int rows = (int) Math.ceil(radio.length / 3.0);
		southPanel.setLayout(new GridLayout(rows, 3));
		
		group = new ButtonGroup(); // button group for look-and-feel
		ItemHandler handler = new ItemHandler();
		
		for (int count = 0; count < radio.length; count++) {
			radio[count] = new JRadioButton(lookNames[count]);
			radio[count].addItemListener(handler);
			group.add(radio[count]);
			southPanel.add(radio[count]);
		}
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		radio[0].setSelected(true);
	}	// end look-and-feel frame constructor
	
	// use UIManager to change look-and-feel of GUI
	private void changeTheLookAndFeel(int value) {
		try // chance look-and-feel
		{
			// set look-and-feel for this application
			UIManager.setLookAndFeel(looks[value].getClassName());
			
			// update components in this application
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	// private inner class to handle radio button event
	private class ItemHandler implements ItemListener {
		// process user's look-and-feel selection
		@Override
		public void itemStateChanged(ItemEvent event) {
			for (int count = 0; count < radio.length; count++) {
				if (radio[count].isSelected()) {
					label.setText(String.format("This is a %s look-and-feel", lookNames[count]));
					comboBox.setSelectedIndex(count);
					changeTheLookAndFeel(count);
				}
			}
		}
	} // end private inner class ItemHandler
} // end class LookAndFeelFrame

















