package assModule2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ViewOneFrame
{
    JTextArea displayText;
    JPanel panel;
	
	public ViewOneFrame()
	{
		JFrame frame = new JFrame("Inventory Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(870, 420);
		frame.setLayout(null);
		
		panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBounds(350, 20, 480, 330);
        panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
        frame.add(panel);
		

        JTextArea displayText = new JTextArea();
        displayText.setLineWrap(false);

        JScrollPane scrollPane = new JScrollPane(displayText);
        scrollPane.setBounds(5, 5, 100, 100);
        panel.add(scrollPane);
		
			
		// ending frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}