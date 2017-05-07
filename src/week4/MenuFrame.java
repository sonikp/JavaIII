package week4;

// fig 22.5

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuFrame extends JFrame
{
	private final Color colorValues[] = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};
	private final JRadioButtonMenuItem colorItems[];
	private final JRadioButtonMenuItem fonts[];
	private final JCheckBoxMenuItem styleItems[];
	private final JLabel displayJLabel;
	private final ButtonGroup fontButtonGroup;
	private final ButtonGroup colorButtonGroup;
	private int style;
	
	public MenuFrame()
	{
		super("Using JMenus");
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		// create About... menu
		JMenuItem aboutItem = new JMenuItem("About...");
		aboutItem.setMnemonic('A');
		fileMenu.add(aboutItem);
		aboutItem.addActionListener(new ActionListener() {
			// display message dialog when user selects About
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(MenuFrame.this, "This is an example\nof"
						+ " using Menu's", "About", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');
		fileMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			
			// terminate application when user clicks exitItem
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);
		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('r');
		
		// array listing string colors
		String colors[] = { "Black", "Blue", "Red", "Green"};
		
		JMenu colorMenu = new JMenu("Color");
		colorMenu.setMnemonic('c');
		
		// create radio button menu items for colors
		colorItems = new JRadioButtonMenuItem[colors.length];
		colorButtonGroup = new ButtonGroup();
		ItemHandler itemHandler = new ItemHandler();	// handler for colors
		
		// create color radio button menu items
		for (int count = 0; count < colors.length; count++) {
			colorItems[count] = new JRadioButtonMenuItem(colors[count]);
			colorMenu.add(colorItems[count]);
			colorButtonGroup.add(colorItems[count]);
			colorItems[count].addActionListener(itemHandler);
		}
		
		colorItems[0].setSelected(true);
		
		formatMenu.add(colorMenu);
		formatMenu.addSeparator();
		
		// array listing font names
		String fontNames[] = { "Serif", "Monospacced", "SanSerif" };
		JMenu fontMenu = new JMenu("Font");
		fontMenu.setMnemonic('n');
		
		// create radio button menu items for font names
		fonts = new JRadioButtonMenuItem[fontNames.length];
		fontButtonGroup = new ButtonGroup(); // manages font names
		
		// create Font radio button menu items
		for (int count = 0; count < fonts.length; count++) {
			fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
			fontMenu.add(fonts[count]);
			fontButtonGroup.add(fonts[count]);
			fonts[count].addActionListener(itemHandler);
		}
		
		fonts[0].setSelected(true);
		fontMenu.addSeparator();
		
		String styleNames[] = { "Bold", "Italic" };
		styleItems = new JCheckBoxMenuItem[styleNames.length];
		StyleHandler styleHandler = new StyleHandler();
		
		// create style checkbox menu items
		for (int count = 0; count < styleNames.length; count++) {
			styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
			fontMenu.add(styleItems[count]);
			styleItems[count].addItemListener(styleHandler);
		}
		
		formatMenu.add(fontMenu);
		bar.add(formatMenu);
		
		// set up label to display text
		displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
		displayJLabel.setForeground(Color.CYAN);
		displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));
		
		getContentPane().setBackground(Color.CYAN);
		add(displayJLabel, BorderLayout.CENTER);
		
	} // end MenuFrame constructor
	
	// inner class to handle action events from menu items
	private class ItemHandler implements ActionListener {
		
		// process color and font selections
		@Override
		public void actionPerformed(ActionEvent event) {
			
			for (int count = 0; count < colorItems.length; count++ ) {
				if (colorItems[count].isSelected()) {
					displayJLabel.setForeground(colorValues[count]);
					break;
				}
			}
			
			// process font selection
			for (int count = 0; count < fonts.length; count++) {
				if (event.getSource() == fonts[count]) {
					displayJLabel.setFont(new Font(fonts[count].getText(),style, 72));
				}
					
			}
			
			repaint();
		}
	}	// end class ItemHandler
	
	// inner class to handle item events from checkbox menu items
	private class StyleHandler implements ItemListener {
		// process font style selections
		@Override
		public void itemStateChanged(ItemEvent event) {
			String name = displayJLabel.getFont().getName();	// current Font
			Font font;	// new font based on user selections
			
			// determine which items are checked and create Font
			if (styleItems[0].isSelected() && styleItems[1].isSelected()) {
				font = new Font(name, Font.BOLD + Font.ITALIC, 72);
			}
			else if (styleItems[0].isSelected()) {
				font = new Font(name, Font.BOLD, 72);
			}
			else if (styleItems[1].isSelected()) {
				font = new Font(name, Font.ITALIC, 72);
			}
			else {
				font = new Font(name, Font.PLAIN, 72);
			}
			displayJLabel.setFont(font);
			repaint();
		}
	}
	
} // end class MenuFrame




















