package week3;
// fig 12.43

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GridLayoutFrame extends JFrame implements ActionListener
{
	private final JButton buttons[];
	private static final String names[] = { "one", "two", "three", "four", "five", "six" };
	private boolean toggle = true;
	private final Container container;
	private final GridLayout gridLayout1;
	private final GridLayout gridLayout2;
	
	public GridLayoutFrame()
	{
		super("GridLayout Demo");
		gridLayout1 = new GridLayout(2, 3, 5, 5); // 2 by 3; gaps of 5
		gridLayout2 = new GridLayout(3, 2); // 3 by 2; no gaps
		container = getContentPane();
		setLayout(gridLayout1);
		buttons = new JButton[names.length];
		
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
			add(buttons[count]);
		}
	}
	
	// handle button events by toggling between layouts
	@Override
	public void actionPerformed(ActionEvent event) {
		if (toggle)	 { // set layout based on toggle
			container.setLayout(gridLayout2);
		}
		else {
			container.setLayout(gridLayout1);
		}
		
		toggle = !toggle;
		container.validate();
			
	}
	
}









