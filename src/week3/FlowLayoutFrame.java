package week3;

// fig 12.39

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FlowLayoutFrame extends JFrame
{
	private final JButton leftJButton;
	private final JButton centerJButton;
	private final JButton rightJButton;
	private final FlowLayout layout;
	private final Container container;
	
	// set up GUI and register button listeners
	public FlowLayoutFrame()
	{
		super("FlowLayout Demo");
		
		layout = new FlowLayout();
		container = getContentPane();
		setLayout(layout);
		
		// set up leftJButton and register listener
		leftJButton = new JButton("Left");
		add(leftJButton);
		leftJButton.addActionListener(new ActionListener() {
			// process leftJButton event
			@Override
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.LEFT);
				
				// realign attached components
				layout.layoutContainer(container);
			}
		});
		
		// set up centerJButton and register listener
		centerJButton = new JButton("Center");
		add(centerJButton);
		centerJButton.addActionListener(new ActionListener() {
			// process centerJButton event
			@Override
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.CENTER);
				
				// realign attached components
				layout.layoutContainer(container);
				
			}
		});
		
		// set up rightJButton and register listener
		rightJButton = new JButton("Right");
		add(rightJButton);
		rightJButton.addActionListener(new ActionListener() {
			// process rightJButton event
			@Override
			public void actionPerformed(ActionEvent event) {
				layout.setAlignment(FlowLayout.RIGHT);
				
				// realign attached components
				layout.layoutContainer(container);
				
			}
		});
	}
}



















