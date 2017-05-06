package week3;

// Fig 12.9

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class TextFieldFrame extends JFrame
{
	private final JTextField textField1;
	private final JTextField textField2;
	private final JTextField textField3;
	private final JPasswordField passwordField;
	
	public TextFieldFrame()
	{
		super("JTextField & JPasswordField");
		setLayout(new FlowLayout());
		
		textField1 = new JTextField(10);
		add(textField1);
		
		textField2 = new JTextField("Enter text here");
		add(textField2);
		
		textField3 = new JTextField("Uneditable text field", 21);
		textField3.setEditable(false);
		add(textField3);
		
		passwordField = new JPasswordField("Hidden Text");
		add(passwordField);
		
		// register event handlers
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
		
	}
	
	private class TextFieldHandler implements ActionListener{
		// process text field events
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String string = "";
			
			if (event.getSource() == textField1)
			{
				string = String.format("textField1: %s", event.getActionCommand());
//				System.out.println("Event: " + event.getActionCommand());
			}
				
			
			else if (event.getSource() == textField2)			
				string = String.format("textField2: %s", event.getActionCommand());
			
			else if (event.getSource() == textField1)			
				string = String.format("textField13: %s", event.getActionCommand());
			
			else if ((event.getSource() == passwordField))			
				string = String.format("passwordField: %s", event.getActionCommand());
			
				
			// display JTextField content
			JOptionPane.showMessageDialog(null, string);
			
		}
	}
	
	

	




	

	
}