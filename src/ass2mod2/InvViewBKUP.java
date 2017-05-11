package ass2mod2;
//https://www.mindstick.com/Articles/1799/simple-registration-form-using-java-swing-step2-connecting-gui-with-mysql-database-using-jdbc

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//@SuppressWarnings("serial")
public class InvViewBKUP extends JFrame{   

//      Connection con;
//      Statement stmt;
//
//      PreparedStatement preStatement,updatePreStmt;
      JLabel applicationTitle, itemType, idNumLabel, genderLabel, titleLabel, artistLabel, prodCodeLabel, quantityLabel;
      JTextField OLDidField, idNumField, genderField, artistField, titleField, prodCodeField, qualtityField;
      JButton registerButton, exitButton,updateButton,deleteButton,resetButton, refresh, quitButton;
//      JRadioButton male, female;
//      ButtonGroup bg;
      JPanel panel;
      JTable table;

      DefaultTableModel model;

      JScrollPane scrollpane;
      public InvViewBKUP() {

           super("Inventory Application");
            setSize(870, 420);
            setLayout(null);

            applicationTitle = new JLabel("Inventory Application");			//Registration Form
            applicationTitle.setBounds(60, 2, 200, 30);
            
    		String names[] = {"CD", "DVD", "BOOK" };
    		JComboBox<String> comboBox = new JComboBox<String>(names);
    		comboBox.setBounds(145, 35, 180, 30);	// 	// 95, 190, 130, 30
                        
            itemType = new JLabel("Item Type");
            itemType.setBounds(30, 35, 110, 30);		// 50 (15)
            idNumLabel = new JLabel("ID#"); 
            idNumLabel.setBounds(30, 70, 60, 30);
            titleLabel = new JLabel("Title"); 
            titleLabel.setBounds(30, 105, 60, 30); 
            artistLabel = new JLabel("Artist"); 
            artistLabel.setBounds(30, 140, 100, 30);		// moved from 190
            prodCodeLabel = new JLabel("Product Code"); 
            prodCodeLabel.setBounds(30, 175, 100, 30);		// moved from 190          
            quantityLabel = new JLabel("Quantity"); 
            quantityLabel.setBounds(30, 210, 100, 30);		// moved from 190

            

            
            // Defining ID field // heights :: 50, 85, 120, 155, 190
            OLDidField = new JTextField(); 
//            idField.setBounds(95, 35, 130, 30);
            OLDidField.setEnabled(false);
            
            // Defining Name field
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
            


 
            // fixing all Label,TextField,RadioButton
            add(applicationTitle);
            add(comboBox);
            add(itemType);
            add(idNumLabel);
            add(titleLabel);
            add(artistLabel);
            add(OLDidField);
            add(idNumField);
            add(prodCodeLabel);
            add(quantityLabel);
            add(artistField);
            add(titleField);	
            add(prodCodeField);
            add(qualtityField);
            
  

            // Defining Exit Button
            exitButton = new JButton("List(ALL)"); 
            exitButton.setBounds(25, 250, 114, 25);      
            
            // Defining Delete Button
            deleteButton = new JButton("Update");
            deleteButton.setBounds(25, 285, 114, 25);
//            deleteButton.setEnabled(false);

            // Defining Reset Button
            resetButton = new JButton("Delete");
            resetButton.setBounds(25, 320, 114, 25);
//            resetButton.setEnabled(false); 
            
            
            // Defining Register Button
            registerButton = new JButton("List(Single)");
            registerButton.setBounds(144, 250, 114, 25);

            // Defining Update Button
            updateButton = new JButton("Create");
            updateButton.setBounds(144, 285, 114, 25);
//            updateButton.setEnabled(false);
            
            // Defining Reset Button
            quitButton = new JButton("Quit");
            quitButton.setBounds(144, 320, 114, 25);
//            quitButton.setEnabled(false); 

            // fixing all Buttons
            add(exitButton);
            add(registerButton);
            add(updateButton);
            add(deleteButton);
            add(resetButton);
            add(quitButton); 

            // Defining Panel
            panel = new JPanel();
            panel.setLayout(new GridLayout());
            panel.setBounds(350, 20, 480, 330);
            panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
            add(panel);

            // Defining Refresh Button
//            refresh = new JButton("Refresh Table");
//            refresh.setBounds(350, 350, 270, 15);
//            add(refresh);

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
      /*
      // Connection with Database
      public void connect(){
            try{
                  Class.forName("com.mysql.jdbc.Driver");
                  con =DriverManager.getConnection(
                                  "jdbc:mysql://localhost:3306/test","root","1234");
                  stmt = con.createStatement();
                  preStatement = con.prepareStatement("insert into regForm(name,gender,address,contact) values(?,?,?,?)");
            }catch(Exception e){
                  System.out.print(e.getMessage());
            }
      }
      */
}