package assModule2;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ViewOneFrame extends JFrame
{
	private static final LayoutManager BorderLayout = null;
	private final JDesktopPane theDesktop;
	
	public ViewOneFrame()
	{
		super("ViewOne");
		setLayout(BorderLayout);
		
		JMenuBar bar = new JMenuBar();
		JMenu addMenu = new JMenu("Inventory Program");
		JMenuItem listALL = new JMenuItem("List (ALL)");
		JMenuItem listSingle = new JMenuItem("List (Single)");
		
		addMenu.add(listALL);
		addMenu.add(listSingle);
		bar.add(addMenu);
		setJMenuBar(bar);
		
		theDesktop = new JDesktopPane();
		add(theDesktop);
	}
	
}