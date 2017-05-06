package week3;

// fig 12.19

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame
{
	private final JTextField textField;
	private final Font plainFont;
	private final Font boldFont;
	private final Font italicFont;
	private final Font boldItalicFont;
	
	private final JRadioButton plainJRadioButton;
	private final JRadioButton boldJRadioButton;
	private final JRadioButton italicJRadioButton;
	private final JRadioButton boldItalicJRadioButton;
	
	private final ButtonGroup radioGroup;
	
	public RadioButtonFrame()
	{
		super("radioButton");
		setLayout(new FlowLayout());
		
		textField = new JTextField("watch the font style change", 25);
		textField.setHorizontalAlignment(JTextField.CENTER);
		add(textField);
		
		// create radio buttons
		plainJRadioButton = new JRadioButton("Plain", true);
		boldJRadioButton = new JRadioButton("Bold", false);
		italicJRadioButton = new JRadioButton("Italic", false);
		boldItalicJRadioButton = new JRadioButton("Bold/Italic", false);
		add(plainJRadioButton);
		add(boldJRadioButton);
		add(italicJRadioButton);
		add(boldItalicJRadioButton);
		
		// create logical relationship between JRadioButtons
		radioGroup = new ButtonGroup();
		radioGroup.add(plainJRadioButton);
		radioGroup.add(boldJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldItalicJRadioButton);
		
		// create font objects
		plainFont = new Font("Serif", Font.PLAIN,14);
		italicFont = new Font("Serif", Font.ITALIC,14);
		boldFont = new Font("Serif", Font.BOLD,14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC,14);
		textField.setFont(plainFont);
		
		// register events for JRadioButtons
		plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont));
		boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont));		
	}
	
	private class RadioButtonHandler implements ItemListener
	{
		private Font font;	// font associated with this listener
		
		public RadioButtonHandler(Font f) {
			System.out.println("f: " + f);
			font = f;
		}

		
		// handle radio button events
		@Override
		public void itemStateChanged(ItemEvent event){
			System.out.println("font: " + font);
			textField.setFont(font);
		}
	}
	
}

















