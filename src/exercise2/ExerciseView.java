package exercise2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExerciseView
{
	JFrame frame;
	JPanel panel;
	JLabel itemLabel;
	JButton listAllButton;
	
	public ExerciseView()
	{
		frame = new JFrame("Test JTable DataModel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(870, 420);
		frame.setLayout(null);
		
		// defining features
		itemLabel = new JLabel("Get Data");
		itemLabel.setBounds(30, 30, 110, 30);	
		
		listAllButton = new JButton("Push");
		listAllButton.setBounds(100, 35, 114, 25);
		
		// adding features
		frame.add(itemLabel);
		frame.add(listAllButton);
		
		// ending frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}