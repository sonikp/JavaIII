package week4;

// fig 22.23

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class GridBagFrame2 extends JFrame
{
	private final GridBagLayout layout;
	private final GridBagConstraints constraints;
	
	public GridBagFrame2()
	{
		super("GridBagLayout II");
		layout = new GridBagLayout();
		setLayout(layout);
		constraints = new GridBagConstraints();
		
		// create GUI components
		String metals[] = {"Copper", "Aluminum", "Silver" };
		JComboBox comboBox = new JComboBox(metals);
		
		JTextField textField = new JTextField("TextField");
		
		String fonts[] = { "Serif", "Monospaced" };
		
		JList list = new JList(fonts);
		
		String names[] = { "zero", "one", "two", "three", "four" };
		JButton buttons[] = new JButton[names.length];
		
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
		}
		
		// define GUI component constraints for textField
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponents(textField);
		
		// button[0]
		constraints.gridwidth = 1;
		addComponents(buttons[0]);
		
		// button[1]
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponents(buttons[1]);
		
		// button[2]
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponents(buttons[2]);
		
		// comboBox -- weightX is 1; fill is BOTH
		constraints.weighty = 0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponents(comboBox);
		
		// button[3]
		constraints.weighty = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponents(buttons[3]);
		
		// button[4]
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponents(buttons[4]);
		
		// list -- weightx and weighty are 1; fill is BOTH
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponents(list);
	}	// end GridBagFrame2 constructor
	
	// add a component to the container
	private void addComponents(Component component) {
		layout.setConstraints(component, constraints);
		add(component);
	}
} 

















