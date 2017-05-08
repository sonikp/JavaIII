package week4;

// fig 22.11  DOESNT WORK


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class DesktopFrame extends JFrame
{
	private final JDesktopPane theDesktop;
	
	// set up GUI
	public DesktopFrame()
	{
		super("Using a JDesktop");
		
		JMenuBar bar = new JMenuBar();
		JMenu addMenu = new JMenu("Add");
		JMenuItem newFrame = new JMenuItem("Internal Frame");
		
		addMenu.add(newFrame);
		bar.add(addMenu);
		setJMenuBar(bar);
		
		theDesktop = new JDesktopPane();
		add(theDesktop);
		
		// set up listener for newFrame menu item
		newFrame.addActionListener(new ActionListener() {
			
			// display new internal window
			@Override
			public void actionPerformed(ActionEvent event) {
				// create internal frame
				JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true,true);
				
				MyJPanel panel = new MyJPanel();
				frame.add(panel, BorderLayout.CENTER);
				frame.pack(); 	// set internal frame to size of contents
				
				theDesktop.add(frame);
				frame.setVisible(true);
				
			}
		});
	}	// end of desktop frame constuctor
}	// end of class DesktopFrame

class MyJPanel extends JPanel
{
	private static final SecureRandom generator = new SecureRandom();
	private final ImageIcon picture;
	private final static String images[] = { "kart1.jpg","kart2.jpg","kart3.jpg","kart4.jpg","kart5.jpg" };
	
	// load image
	public MyJPanel()
	{
		int randomNumber = generator.nextInt(images.length);
		picture = new ImageIcon(images[randomNumber]);
		System.out.println(picture);
		
	}
	
	// display imageIcon on panel
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		picture.paintIcon(this, g, 0, 0);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(picture.getIconWidth(), picture.getIconHeight());
	}
	
	
}




















