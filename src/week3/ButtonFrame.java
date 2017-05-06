package week3;

import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Fig 12.15



public class ButtonFrame extends JFrame
{
	private final JButton plainJButton;
	private final JButton fancyJButton;
	
	public ButtonFrame()
	{
		super("Buttons");
		setLayout(new FlowLayout());
		
		plainJButton = new JButton("plain button");
		add(plainJButton);
		
		Icon bug1 = new ImageIcon(getClass().getResource("bug1.png"));
		Icon bug2 = new ImageIcon(getClass().getResource("bug2.png"));
		fancyJButton = new JButton("Fancy Button", bug1);
		fancyJButton.setRolloverIcon(bug2);
		add(fancyJButton);
		
		
		// create button handler
		ButtonHandler handler = new ButtonHandler();
		fancyJButton.addActionListener(handler);
		plainJButton.addActionListener(handler);
	}
		
		// inner class for button event handling
	private class ButtonHandler implements ActionListener{
		// handle button event
		@Override
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(ButtonFrame.this, 
					String.format("You Pressed; %s", event.getActionCommand()));
				
			}
			
	}
	
}














