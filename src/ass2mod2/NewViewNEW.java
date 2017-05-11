package ass2mod2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

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

import assignment2.InventoryProgramController;
import assignment2.InventoryProgramModel;
import assignment2.Observer;

public class NewViewNEW extends Observer
{
	private InventoryProgramController theController;
	private InventoryProgramModel theModel;
	
	JLabel applicationTitle, itemType, idNumLabel, titleLabel, artistLabel, prodCodeLabel, quantityLabel;
    JTextField  idNumField, genderField, artistField, titleField, prodCodeField, qualtityField;	//OLDidField,
    JButton listSingleButton, listAllButton,createButton,updateButton,deleteButton, quitButton; //refresh

    JPanel panel;
    JTable table;

    DefaultTableModel model;

    JScrollPane scrollpane;
    
    // constructor
    public NewViewNEW()
    {
    	super("Inventory Application");
    	setSize(870, 420);
        setLayout(null);
        applicationTitle = new JLabel("Inventory Application");			
        applicationTitle.setBounds(60, 2, 200, 30);
        
		String names[] = {"CD", "DVD", "BOOK" };
		JComboBox<String> comboBox = new JComboBox<String>(names);
		comboBox.setBounds(145, 35, 180, 30);	
		
		// Naming the labels
        itemType = new JLabel("Item Type");
        itemType.setBounds(30, 35, 110, 30);		
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
        add(applicationTitle);
        add(comboBox);
        add(itemType);
        add(idNumLabel);
        add(titleLabel);
        add(artistLabel);
        add(idNumField);
        add(prodCodeLabel);
        add(quantityLabel);
        add(artistField);
        add(titleField);	
        add(prodCodeField);
        add(qualtityField);
        
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
        add(listAllButton);
        add(listSingleButton);
        add(createButton);
        add(updateButton);
        add(deleteButton);
        add(quitButton); 

        // Defining Panel
        panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBounds(350, 20, 480, 330);
        panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
        add(panel);

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
        this.setLocation(dim.width/2-this.getSize().width/2,
                         dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    	
    }
}