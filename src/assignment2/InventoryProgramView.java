package assignment2;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
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
	
	private String prompt = "\n#: ";
	
	private int menuOption = 0;
	static private boolean exit = false;
	
	// GUI Parameters
	JLabel applicationTitle, itemTypeLabel, idNumLabel, titleLabel, artistLabel, prodCodeLabel, quantityLabel;
    JTextField  idNumField, genderField, artistField, titleField, prodCodeField, qualtityField;	
    JButton listSingleButton, listAllButton,createButton,updateButton,deleteButton, quitButton; 

    JPanel panel;
    JTable table;

    DefaultTableModel model;

    JScrollPane scrollpane;
	
	
	// default constructor
	public InventoryProgramView(){
		JFrame frame = new JFrame("Inventory Application");
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
        frame.add(panel);

        //Defining Model for table
        model = new DefaultTableModel();

        //Adding object of DefaultTableModel into JTable
        table = new JTable(model);

        //Fixing Columns move
        table.getTableHeader().setReorderingAllowed(false);

        // Defining Column Names on model
        model.addColumn("ID#");
        model.addColumn("Item Type");
        model.addColumn("Title");
        model.addColumn("Artist");
        model.addColumn("ProdCode");
        model.addColumn("Quantity");
        // Enable Scrolling on table
        
        scrollpane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        panel.add(scrollpane);

        //Displaying Frame in Center of the Screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2,
                         dim.height/2-frame.getSize().height/2);
		
		
		// ending frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public InventoryProgramView(InventoryProgramModel theModel) {
		this.subject = theModel;
		this.theModel.add(this);
	}
	
	
	public void start() throws Exception {

		scanner = new Scanner(System.in);
		this.startMainMenu();
	}
	
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
	}
	
	public void startMainMenu() throws Exception {
		do 
		{

			this.mainMenu();
			menuOption = scanner.nextInt();

			
			if (menuOption < 0 || menuOption > 6 ) 
			{
				
				System.out.println("\nATTENTION: The option \"" + menuOption + "\" you selected is not a valid selection" + "\nTry again.\n\n");
				
			}
			else
			{	
				switch(menuOption)	
				{
					case 1:
					{
						// Retrieve ALL inventory list
						theController.getInventoryALL();
						break;
					}
					
					case 2:
					{
						// Retrieve SINGLE inventory list
						this.getItemNumber();
						theController.getInventorySingle(itemNum);
						break;
					}
					
					case 3:	// 
					{
						// Create a new inventory item
						this.createNewInventoryItem();
						theController.createNewInventoryItem(itemType, title, artist, productCode, quantity);
						break;
					}
					
					case 4:
					{						
						// Update the ARTIST in a single inventory item TODO next feature is to update other fields
						this.getItemNumber();
						theController.getInventorySingle(itemNum);				
						this.updateArtist();
						theController.updateArtistItemByNum(itemNum, artist);
						break;
					}
					
					case 5:
					{
						// Delete an item from inventory
						this.getItemNumber();
						theController.deleteItemByNum(itemNum);
						break;
					}
					

					case 6:
					{
						// Select to QUIT application
						exit = true;
						break;
					}
				
				}
							
			}
			
	
		} while ( exit == false);
		System.out.println("Thank you.");

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
		System.out.println("Return From Observer Pattern: \n" + theModel.getObserverState() 
		+ "\n");
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