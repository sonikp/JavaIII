package week4;

// fig 22.7

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ButtonGroup;

public class PopupFrame extends JFrame
{
	private final JRadioButtonMenuItem items[];
	private final Color colorValues[] = {Color.BLUE, Color.YELLOW, Color.RED};
	private final JPopupMenu popupMenu;
	
	public PopupFrame()
	{
		super("Using JPopup Menus");
		
		ItemHandler handler = new ItemHandler();
		String colors[] = { "Blue", "Yellow", "Red" };
		
		ButtonGroup colorGroup = new ButtonGroup();
		popupMenu = new JPopupMenu();
		items = new JRadioButtonMenuItem[colors.length];
		
		// construct menu item, add to pop-up menu, enable event handling
		for (int count = 0; count < items.length; count++) {
			items[count] = new JRadioButtonMenuItem(colors[count]);
			popupMenu.add(items[count]);
			colorGroup.add(items[count]);
			items[count].addActionListener(handler);
		}
		
		setBackground(Color.WHITE);
		
		// declare a MouseListener for the window to display pop-up menu
		addMouseListener(new MouseAdapter() {
			// handle mouse press events
			@Override
			public void mousePressed(MouseEvent event) {
				checkForTriggerEvent(event);
			}
			
			@Override
			public void mouseReleased(MouseEvent event) {
				checkForTriggerEvent(event);
			}
			
			// determine whether event should trigger pop-up menu
			private void checkForTriggerEvent(MouseEvent event) {
				if (event.isPopupTrigger()) {
					popupMenu.show(event.getComponent(), event.getX(), event.getY());
				}
			}
		});
	} // end PopupFrame constructor
	
	// private inner class to handle menu item events
	private class ItemHandler implements ActionListener {
		// process menu item selections
		@Override
		public void actionPerformed(ActionEvent event) {
			// determine which menu item was selected
			for (int i = 0; i < items.length; i++) {
				if (event.getSource() == items[i]) {
					getContentPane().setBackground(colorValues[i]);
					return;
				}
			}
		}
	} // end private inner class ItemHandler
} // end class PopupFrame












