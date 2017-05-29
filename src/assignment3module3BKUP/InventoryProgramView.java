package assignment3module3BKUP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class InventoryProgramView extends Observer
{

	private InventoryProgramController theController;
	private InventoryProgramModel theModel;
	
	private Scanner scanner;
	private String itemNum;
	private String itemType;
	private String title;
	private String artist;
	private String productCode;
	private String quantity;
	
	private String listInventoryViewALL;
	
	private String prompt = "\n#: ";
	
	private int menuOption = 0;
	static private boolean exit = false;
	
	// GUI Parameters
	JLabel applicationTitle, itemTypeLabel, idNumLabel, titleLabel, artistLabel, prodCodeLabel, quantityLabel;
    JTextField  idNumField, artistField, titleField, prodCodeField, quantityField;	
    JButton listAllButton, listSingleButton, createButton, updateButton, deleteButton, quitButton; 
    
    JFrame frame;
    JTextArea displayText;
    JPanel panel;
    JScrollPane scrollpane;
    
    private static InventoryProgramDatabaseInterface tableModel;
	
	// default constructor
	public InventoryProgramView() throws Exception
	{
		tableModel = new InventoryProgramDatabaseInterface();
				
		try
		{
			frame = new JFrame("Inventory Application");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(870, 420);
			frame.setLayout(null);
	        applicationTitle = new JLabel("Inventory Application Version 2");			
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
					System.out.println("ListAll Button pressed");
					try {
						
						tableModel.getInventoryALL();
						
						/*
						theController.getInventoryALL();
						displayText.setText(getListInventoryViewALL());
						*/
					} catch (Exception exception) {
//						e.printStackTrace();
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	        
	        updateButton = new JButton("Update(artist)");
	        updateButton.setBounds(25, 285, 114, 25);
	        updateButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					System.out.println("Update Button pressed");
					try {
						System.out.println("Update pushed");
						tableModel.updateArtistInventoryItem(idNumField.getText(), artistField.getText());
						/*
						String itemNum = idNumField.getText();
						String artist = artistField.getText();
						theController.updateArtistItemByNum(itemNum, artist);
						theController.getInventoryALL();
						displayText.setText(getListInventoryViewALL());
						// clear input fields
						idNumField.setText("");
						artistField.setText("");
						*/
						
					} catch (Exception exception) {
//						e.printStackTrace();
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	
	        deleteButton = new JButton("Delete");
	        deleteButton.setBounds(25, 320, 114, 25);
	        deleteButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					System.out.println("Delete Button pressed");
					try {
						System.out.println("Delete pushed " + idNumField.getText());
						tableModel.deleteItemFromInventory(idNumField.getText());
						/*
						String itemNum = idNumField.getText();
						theController.deleteItemByNum(itemNum);
						theController.getInventoryALL();
						displayText.setText(getListInventoryViewALL());
						// clear input fields
						idNumField.setText("");
						*/
						
					} catch (Exception exception) {
//						e.printStackTrace();
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	        
	        listSingleButton = new JButton("List(Single)");
	        listSingleButton.setBounds(144, 250, 114, 25);
	        listSingleButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					System.out.println("List Single Button pressed");
					try {
						
						System.out.println("List item " + idNumField.getText());
						tableModel.getInventorySingle(idNumField.getText());
						
						/*
						String itemNum = idNumField.getText();
						theController.getInventorySingle(itemNum);
						displayText.setText(getListInventoryViewALL());
						*/
						
					} catch (Exception exception) {
//						e.printStackTrace();
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	
	        createButton = new JButton("Create");
	        createButton.setBounds(144, 285, 114, 25);
	        createButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					System.out.println("Create Button pressed");
					try {
						System.out.println("Create pushed");
						System.out.println(comboBox.getSelectedItem() + " " + 
								titleField.getText() + " " + 
								artistField.getText() + " " +
								prodCodeField.getText() + " " +
								quantityField.getText());
						tableModel.createNewInventorySelectType((String)comboBox.getSelectedItem(), titleField.getText(), artistField.getText(), prodCodeField.getText(), quantityField.getText());
						artistField.setText("");
						
						// clear fields
						titleField.setText("");
						artistField.setText("");
						prodCodeField.setText("");
						quantityField.setText("");
						
						
						/*
						String itemType = (String)comboBox.getSelectedItem();
						String title = titleField.getText();
						String artist = artistField.getText();
						String productCode = prodCodeField.getText();
						String quantity = qualtityField.getText();
						theController.createNewInventoryItem(itemType, title, artist, productCode, quantity);
						theController.getInventoryALL();
						displayText.setText(getListInventoryViewALL());
						// clear input fields
						titleField.setText("");
						artistField.setText("");
						prodCodeField.setText("");
						qualtityField.setText("");
						*/
						
						
					} catch (Exception exception) {
//						e.printStackTrace();
						JOptionPane.showMessageDialog(null, exception.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
						System.exit(1);
					}
					
				}
			});
	        
	        quitButton = new JButton("Quit");
	        quitButton.setBounds(144, 320, 114, 25);
	        quitButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					System.out.println("Quit Button pressed");
					try {			
						
						System.out.println("Quit pushed");
						tableModel.disconnectFromDatabase();
						System.exit(1);
						frame.dispose();
					} catch (Exception sqlException)
					{
						JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
						
						// ensure database connection is closed
						tableModel.disconnectFromDatabase();
						
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
//	        frame.add(panel);
	        
			// create JTable based on tableModel
			JTable resultTable = new JTable(tableModel);			
			panel.add(new JScrollPane(resultTable), BorderLayout.CENTER);
	        
	        /*
	        // old 
	        displayText = new JTextArea();	
	        displayText.setLineWrap(false);
	        
	        scrollpane = new JScrollPane(displayText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        scrollpane.setBounds(5, 5, 100, 100);
	        panel.add(scrollpane);
	        */
	        
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
					tableModel.disconnectFromDatabase();
					System.exit(0);
					
				}
			});
			
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
			tableModel.disconnectFromDatabase();
			System.exit(1);
		}
	}
	
	public InventoryProgramView(InventoryProgramModel theModel) {
		this.subject = theModel;
		this.theModel.add(this);
	}
	
	
	public void start() throws Exception {

		scanner = new Scanner(System.in);

	}
	


	////////////////View Methods//////////////////////////////
	
	public void mainMenu(){
		System.out.println("------------------Inventory Program-----------------------------");
		System.out.println("| Enter Selection: 1 = LIST (ALL), 2 = LIST (Item), 3 = CREATE |");
		System.out.print("| \t\t   4 = UPDATE, 5 = DELETE, 6 = QUIT            |\n");
		System.out.print("----------------------------------------------------------------");
		System.out.print(prompt);
	}
	
	
	public String getItemNumber() {	
		scanner = new Scanner(System.in);
		System.out.print("\nPlease enter item number you wish to view");
		System.out.print(prompt);
		itemNum = scanner.nextLine();
		return itemNum;
	}
	
	// CREATE:
	public void createNewInventoryItem() throws Exception {
		scanner = new Scanner(System.in);

		System.out.println("CREATE a NEW inventory record."
				+ "\nEnter the item details & hit <enter> for each item\n"
				+ "To start, enter type of item: CD, DVD, BOOK");	
		System.out.print(prompt);
		itemType = scanner.nextLine().toUpperCase();
		
		System.out.print("\nTitle: ");
		System.out.print(prompt);
		title = scanner.nextLine();
		
		System.out.print("\nArtist: ");
		System.out.print(prompt);
		artist = scanner.nextLine();
		
		System.out.print("\nProductCode: ");
		System.out.print(prompt);
		productCode = scanner.nextLine();
		
		System.out.print("\nQuantity:");
		System.out.print(prompt);
		quantity = scanner.nextLine();
	}
	
	// UPDATE:
	public String updateArtist() throws Exception {
		System.out.print("\nEnter the new ARTIST name you wish to update: ");
		System.out.print(prompt);
		artist = scanner.nextLine();
		return artist;
	}
		

	// Observer pattern update method
	public void update(){
		listInventoryViewALL = theModel.getObserverState();
		// Debug code
		//System.out.println("Return From Observer Pattern: \n" + listInventoryViewALL + "\n");	
	}
	
	public String getListInventoryViewALL() {
		return listInventoryViewALL;
	}
	
	// MVC setters and getters
	public void setTheModel(InventoryProgramModel theModel) {
		this.theModel = theModel;
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

	
}