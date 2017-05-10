package assModule2;
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
public class NewViewFrameEDIT extends JFrame{   

      Connection con;
      Statement stmt;

      PreparedStatement preStatement,updatePreStmt;
      JLabel title, idLabel, nameLabel, genderLabel, addressLabel, contactLabel, itemTypeLabel;
      JTextField idField, nameField, genderField, addressField, contactField;
      JButton registerButton, exitButton,updateButton,deleteButton,resetButton, refresh, quitButton;
//      JRadioButton male, female;
//      ButtonGroup bg;
      JPanel panel;
      JTable table;

      DefaultTableModel model;

      JScrollPane scrollpane;
      public NewViewFrameEDIT() {
           // TODO Auto-generated constructor stub
           super("Inventory Application");
            setSize(770, 420);
            setLayout(null);
            // Calling connect method, this will connect us to database
            connect();
            // Defining Labels 
            title = new JLabel("Inventory Application");			//Registration Form
            title.setBounds(60, 7, 200, 30);
            idLabel = new JLabel("ArtistName");
            idLabel.setBounds(30, 50, 60, 30);
            nameLabel = new JLabel("ItemName"); 
            nameLabel.setBounds(30, 85, 60, 30);
            
//            genderLabel = new JLabel("Gender"); 
//            genderLabel.setBounds(30, 120, 60, 30);
            
            
            addressLabel = new JLabel("ProdCode"); 
            addressLabel.setBounds(30, 155, 60, 30); 
            contactLabel = new JLabel("Quantity"); 
            contactLabel.setBounds(30, 120, 60, 30);		// moved from 190
            
            itemTypeLabel = new JLabel("ItemType"); 
            itemTypeLabel.setBounds(30, 190, 60, 30);		// moved from 190

            // Defining ID field // heights :: 50, 85, 120, 155, 190
            idField = new JTextField(); 
            idField.setBounds(95, 50, 130, 30);
            idField.setEnabled(false);

            // Defining Name field
            nameField = new JTextField(); 
            nameField.setBounds(95, 85, 130, 30);  
            
            /*
            // Defining Gender Buttons
            male = new JRadioButton("Male");
            male.setBounds(95, 120, 60, 30);

            female = new JRadioButton("Female");
            female.setBounds(155, 120, 70, 30);            

            bg = new ButtonGroup(); 
            bg.add(male); 
            bg.add(female); 
            */
            //
            contactField = new JTextField(); 
            contactField.setBounds(95, 120, 130, 30);
            addressField = new JTextField(); 
            addressField.setBounds(95, 155, 130, 30);
            
    		String names[] = {"CD", "DVD", "BOOK" };
    		JComboBox<String> comboBox = new JComboBox<String>(names);
    		comboBox.setBounds(95, 190, 130, 30);

 
            // fixing all Label,TextField,RadioButton
            add(title);
            add(idLabel);
            add(nameLabel);
//            add(genderLabel);
            add(addressLabel);
            add(contactLabel);
            add(idField);
            add(nameField);
            add(itemTypeLabel);
//            add(male);
//            add(female);
            add(addressField);
            add(contactField);
            add(comboBox);

            // Defining Exit Button
            exitButton = new JButton("List(ALL)"); 
            exitButton.setBounds(25, 250, 80, 25);            

            // Defining Register Button
            registerButton = new JButton("List(Single)");
            registerButton.setBounds(110, 250, 100, 25);

            // Defining Update Button
            updateButton = new JButton("Create");
            updateButton.setBounds(110, 285, 100, 25);
//            updateButton.setEnabled(false);

            // Defining Delete Button
            deleteButton = new JButton("Update");
            deleteButton.setBounds(25, 285, 80, 25);
//            deleteButton.setEnabled(false);

            // Defining Reset Button
            resetButton = new JButton("Delete");
            resetButton.setBounds(25, 320, 80, 25);
//            resetButton.setEnabled(false); 
            
            // Defining Reset Button
            quitButton = new JButton("Quit");
            quitButton.setBounds(110, 320, 100, 25);
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
            panel.setBounds(250, 20, 480, 330);
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
            model.addColumn("ItemType");
            model.addColumn("ArtistName");
            model.addColumn("ItemName");
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
}