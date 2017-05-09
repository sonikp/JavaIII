package week4;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GridBagFrame extends JFrame
{
	private final GridBagLayout layout;
	private final GridBagConstraints constraints;
	
	// set up GUI
	public GridBagFrame()
	{
		super("GridBagLayout");
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints(); // instantiates constraints
		
		// create GUI components
		JTextArea textArea1 = new JTextArea("TextArea1", 5, 10);
		JTextArea textArea2 = new JTextArea("TextArea2", 2, 2);
		
		String names[] = {"Iron", "Steel", "Brass" };
		JComboBox<String> comboBox = new JComboBox<String>(names);
		
		JTextField textField = new JTextField("TextField");
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		JButton button3 = new JButton("Button3");
		
		// weightX and weightY for textArea1 are both 0: the default anchor for all components is CENTER: the default
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(textArea1,0,0,1,3);
		
		// weightX and weightY for button1 are both 0: the default
		constraints.fill = GridBagConstraints.HORIZONTAL;
		addComponent(button1, 0, 1, 2, 1);
		
		// weightX and weightY for comboBox are both 0: the default. Fill is Horizontal
		addComponent(comboBox, 2, 1, 2, 1);
		
		// button2
		constraints.weightx = 1000; // can grow wider
		constraints.weighty = 1;	// can grow taller
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(button2, 1, 1, 1, 1);
		
		// fill is BOTH for button3
		constraints.weightx = 0;
		constraints.weighty = 0;
		addComponent(button3, 1, 2, 1, 1);
		
		// weightX and weightY for textField are both 0, fill is BOTH
		addComponent(textField, 2, 0, 2, 1);
		
		// weightX and weightY for textArea are both 0, fill is BOTH
		addComponent(textArea2, 3, 2, 1, 1);
		
	} // end GridBagFrame constructor
	
	// method to set constraints on
	private void addComponent(Component component, int row, int column, int width, int height) {
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		add(component);
	}
}


















