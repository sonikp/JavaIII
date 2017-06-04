package assignment3module3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


public class InventoryProgramView extends Observer
{

	private InventoryProgramController theController;
	private InventoryProgramModel theModel;	
		
	// GUI Parameters
	JLabel applicationTitle, itemTypeLabel, idNumLabel, titleLabel, artistLabel, prodCodeLabel, quantityLabel;
    JTextField  idNumField, artistField, titleField, prodCodeField, quantityField;	
    JButton listAllButton, listSingleButton, createButton, updateButton, deleteButton, quitButton; 
    
    JFrame frame;
    JTextArea displayText;
    JPanel panel;
    JTable resultTable;
	JScrollPane scrollpane;

    
    private InventoryProgramDatabaseInterface tableModel;
	
	// default (empty) constructor
	public InventoryProgramView() throws Exception {
	}
	
	public void init() 
	{
				
		try
		{
			frame = new JFrame("Inventory Application Assignment 3");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(870, 420);
			frame.setLayout(null);
	        applicationTitle = new JLabel("Inventory Application Assignment 3");			
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
	        quantityField = new JTextField(); 
	        quantityField.setBounds(145, 210, 180, 30);
	
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
	        frame.add(quantityField);
	        
	        // Defining Buttons
	        listAllButton = new JButton("List(ALL)"); 
	        listAllButton.setBounds(25, 250, 114, 25);
	        listAllButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					
					try {
						
						theController.getInventoryALL();
						
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						getTableModel().disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	        
	        updateButton = new JButton("Update(artist)");
	        updateButton.setBounds(25, 285, 114, 25);
	        updateButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					
					try {

						theController.updateArtistItemByNum(idNumField.getText(), artistField.getText());
						
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						getTableModel().disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	
	        deleteButton = new JButton("Delete");
	        deleteButton.setBounds(25, 320, 114, 25);
	        deleteButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					
					try {

						theController.deleteItemByNum(idNumField.getText());
						
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						getTableModel().disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	        
	        listSingleButton = new JButton("List(Single)");
	        listSingleButton.setBounds(144, 250, 114, 25);
	        listSingleButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					
					try {
						
						theController.getInventorySingle(idNumField.getText());						
						
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						getTableModel().disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	
	        createButton = new JButton("Create");
	        createButton.setBounds(144, 285, 114, 25);
	        createButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					
					try {

						theController.createNewInventoryItem((String)comboBox.getSelectedItem(), titleField.getText(), artistField.getText(), prodCodeField.getText(), quantityField.getText());
						
						// clear fields
						titleField.setText("");
						artistField.setText("");
						prodCodeField.setText("");
						quantityField.setText("");
						
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						getTableModel().disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	        
	        quitButton = new JButton("Quit");
	        quitButton.setBounds(144, 320, 114, 25);
	        quitButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					
					try {			
						
						getTableModel().disconnectFromDatabase();
						System.exit(1);
						frame.dispose();
					} catch (Exception sqlException)
					{
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						getTableModel().disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	        
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
	        
			// create JTable based on tableModel
	        resultTable =  this.update(); // update from the observer pattern
			panel.add(new JScrollPane(resultTable), BorderLayout.CENTER);
	        
	        frame.add(panel, BorderLayout.CENTER);
		  		
			// ending frame
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			// ensure database is closed when user quits application
			frame.addWindowListener(new WindowAdapter() 
			{
				// disconnect from database and exit when window has closed
				public void windowClosed(WindowEvent event) 
				{
					getTableModel().disconnectFromDatabase();
					System.exit(0);
					
				}
			});
			
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
			getTableModel().disconnectFromDatabase();
			System.exit(1);
		}
	}
	
	public InventoryProgramView(InventoryProgramModel theModel) {
		this.subject = theModel;
		this.theModel.add(this);
	}
	
	
	public void start() throws Exception {

		this.init();

	}
	

	
	////////////////View Methods//////////////////////////////
	
	// Observer pattern update view
	public JTable update(){
		resultTable = new JTable(this.getTheModel().getTableModel());
		return resultTable;
	}
	
	
	// MVC setters and getters
	public void setTheModel(InventoryProgramModel theModel) {
		this.theModel = theModel;
		this.setTableModel(theModel.getTableModel());
	}
	
	public InventoryProgramModel getTheModel() {
		return theModel;	
	}

	public void setTheController(InventoryProgramController theController) {
		this.theController = theController;	
	}
	
	public InventoryProgramController getTheController() {
		return theController;	
	}
	
	// Set tableModel in view
	public InventoryProgramDatabaseInterface getTableModel() {
		return tableModel;
	}
	
	public void setTableModel(InventoryProgramDatabaseInterface tableModel) {
		this.tableModel = tableModel;
	}

	
}