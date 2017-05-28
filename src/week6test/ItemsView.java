package week6test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class ItemsView extends JFrame
{
	// display

	JPanel panel;
	
	JLabel applicationTitle, itemTypeLabel, idNumLabel, titleLabel, artistLabel, prodCodeLabel, quantityLabel;
    JTextField  idNumField, artistField, titleField, prodCodeField, qualtityField;	
    JButton listAllButton, listSingleButton, createButton, updateButton, deleteButton, quitButton; 

	
	JFrame frame;

	
	// database URL, username, password
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/InventoryDatabase?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	
	// default query retrieves all data from Inventory table
	private static final String DEFAULT_QUERY = "SELECT * FROM Inventory";
	private static final String ITEM_QUERY = "SELECT itemID, itemType, title, artist, productCode, quantity FROM Inventory WHERE itemID = 1";
	
	private static InventorySetTableModel tableModel;
	
	public ItemsView()
	{
		try 
		{
			// create TableModel for results of query SELECT * FROM Inventory
			tableModel = new InventorySetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
			
			

			
			
			// set up JTextArea in which user types queries

			
			frame = new JFrame("Frame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(870, 420);		
			frame.setLayout(null);
	        applicationTitle = new JLabel("Inventory Application");			
	        applicationTitle.setBounds(60, 2, 200, 30);
	        
			String names[] = {"CD", "DVD", "BOOK" };
			JComboBox<String> comboBox = new JComboBox<String>(names);
			comboBox.setBounds(145, 35, 180, 30);
			
			// Naming the labels
	        itemTypeLabel = new JLabel("Item Type");
	        itemTypeLabel.setBounds(30, 35, 110, 30);		
	        idNumLabel = new JLabel("ID#"); 
	        idNumLabel.setBounds(30, 70, 60, 30);
	        titleLabel = new JLabel("Title"); 
	        titleLabel.setBounds(30, 105, 60, 30); 
	        artistLabel = new JLabel("Artist"); 
	        artistLabel.setBounds(30, 140, 100, 30);		
	        prodCodeLabel = new JLabel("Product Code"); 
	        prodCodeLabel.setBounds(30, 175, 100, 30);		        
	        quantityLabel = new JLabel("Quantity"); 
	        quantityLabel.setBounds(30, 210, 100, 30);		

	        // Defining and naming fields
	        idNumField = new JTextField(); 
	        idNumField.setBounds(145, 70, 180, 30);              
	        titleField = new JTextField(); 
	        titleField.setBounds(145, 105, 180, 30);
	        artistField = new JTextField(); 
	        artistField.setBounds(145, 140, 180, 30);           
	        prodCodeField = new JTextField(); 
	        prodCodeField.setBounds(145, 175, 180, 30);          
	        qualtityField = new JTextField(); 
	        qualtityField.setBounds(145, 210, 180, 30);

	        // adding Label,TextField,RadioButton
	        frame.add(applicationTitle);
	        frame.add(comboBox);
	        frame.add(itemTypeLabel);
	        frame.add(idNumLabel);
	        frame.add(titleLabel);
	        frame.add(artistLabel);
	        frame.add(idNumField);
	        frame.add(prodCodeLabel);
	        frame.add(quantityLabel);
	        frame.add(artistField);
	        frame.add(titleField);	
	        frame.add(prodCodeField);
	        frame.add(qualtityField);
	        
	        // Defining Buttons
	        listAllButton = new JButton("List(ALL)"); 
	        listAllButton.setBounds(25, 250, 114, 25);
			
			
	        updateButton = new JButton("Update");
	        updateButton.setBounds(25, 285, 114, 25);

	        deleteButton = new JButton("Delete");
	        deleteButton.setBounds(25, 320, 114, 25);            
	        
	        listSingleButton = new JButton("List(Single)");
	        listSingleButton.setBounds(144, 250, 114, 25);

	        createButton = new JButton("Create");
	        createButton.setBounds(144, 285, 114, 25);
	        
	        quitButton = new JButton("Quit");
	        quitButton.setBounds(144, 320, 114, 25);
	        
	        // Adding Buttons
	        frame.add(listAllButton);
	        frame.add(listSingleButton);
	        frame.add(createButton);
	        frame.add(updateButton);
	        frame.add(deleteButton);
	        frame.add(quitButton); 

	        // Defining Panel
	        panel = new JPanel();
	        panel.setLayout(new GridLayout());
	        panel.setBounds(350, 20, 480, 330);
	        panel.setBorder(BorderFactory.createDashedBorder(Color.blue));

			final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);

			JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			// create JTable based on tableModel
			JTable resultTable = new JTable(tableModel);
			
			panel.add(new JScrollPane(resultTable), BorderLayout.CENTER);
			
			listSingleButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					// perform new query
					try
					{
						tableModel.setQuery(ITEM_QUERY);
					}
					catch (SQLException sqlException)
					{
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
					
				}
			});
			
			listSingleButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					// perform new query
					try
					{
						tableModel.setQuery(ITEM_QUERY);
					}
					catch (SQLException sqlException)
					{
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
					
				}
			});
			
			// create event listener for submitButton		// listAllButton  submitButton
			listAllButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					// perform new query
					try
					{
//						tableModel.setQuery(queryArea.getText());
						tableModel.setQuery(DEFAULT_QUERY);
					}
					catch (SQLException sqlException)
					{
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
					
				}
			});
			
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			resultTable.setRowSorter(sorter);
			
			/*
			// create listener for filterButton
			filterButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					String text = filterText.getText();
					
					if (text.length() == 0 ) {
						sorter.setRowFilter(null);
					}
					else 
					{
						try
						{
							sorter.setRowFilter(RowFilter.regexFilter(text));
						}
						catch(PatternSyntaxException pse)
						{
							JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
			});
			*/
			

			frame.add(panel, BorderLayout.CENTER);

			
			// ending frame
			frame.setLocation(100,700);
			frame.setVisible(true);
			
			
			// ensure database is closed when user quits application
			frame.addWindowListener(new WindowAdapter() 
			{
				// disconnect from database and exit when window has closed
				public void windowClosed(WindowEvent event) 
				{
					tableModel.disconnectFromDatabase();
					System.exit(0);
					
				}
			});
			
		
		}
		
		catch(SQLException sqlException)
		{
				JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
				tableModel.disconnectFromDatabase();
				System.exit(1);
		}
	
	}
	
		

}





















