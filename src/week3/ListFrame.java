package week3;
// fig 12.23

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class ListFrame extends JFrame
{
	private final JList<String> colorJList; // list to display colors
	private static final String colorNames[] = { "Black", "Blue", "Cyan", "Green", "Orange", "Pink", "Red", "White" };
	private static final Color colors[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, 
			Color.PINK, Color.RED, Color.WHITE };
	
	// ListFrames constructor
	public ListFrame()
	{
		super("List Test");
		setLayout(new FlowLayout());
		
		colorJList = new JList<String>(colorNames);
		colorJList.setVisibleRowCount(5);
		
		// do not allow multiple selections
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// add a JScrollPane containing JList to frame
		add(new JScrollPane(colorJList));
		
		colorJList.addListSelectionListener(new ListSelectionListener() {
			
			// handle list selection events
			@Override
			public void valueChanged(ListSelectionEvent event) {
				getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
				
			}
		});
		
	}
	
}











