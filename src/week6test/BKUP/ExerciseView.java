package week6test.BKUP;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import week6.InventorySetTableModel;

public class ExerciseView
{
	JFrame frame;
	JPanel panel;
	JLabel itemLabel;
	JButton listAllButton;
	JTextField itemField;
	
	JTable table;
	DefaultTableModel model;
	JScrollPane scrollPane;
	
	
	
//	private static InventorySetTableModel tableModel;
	private ExerciseModel tableModel;
	
	public ExerciseView() throws SQLException
	{
		frame = new JFrame("Test JTable DataModel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(870, 420);
		frame.setLayout(null);
		
		// Defining Panel
        panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBounds(350, 20, 480, 330);
        panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
        frame.add(panel);
		
		// defining features
		itemLabel = new JLabel("Get Data");
		itemLabel.setBounds(30, 30, 110, 30);
		
		listAllButton = new JButton("Push");
		listAllButton.setBounds(100, 35, 114, 25);
		
        itemField = new JTextField(); 
        itemField.setBounds(40, 100, 230, 30);
		
        tableModel = new ExerciseModel();
        
        //Defining Model for table
        model = new DefaultTableModel();

        //Adding object of DefaultTableModel into JTable
        table = new JTable(model);

        //Fixing Columns move
        table.getTableHeader().setReorderingAllowed(false);
        
        // Defining Column Names on model
        model.addColumn("itemID");
        model.addColumn("itemType");
        model.addColumn("title");
        model.addColumn("artist");
        model.addColumn("productCode");
        model.addColumn("quantity");
        
        // Enable Scrolling on table
        scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);
		
        // button actions
        listAllButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Button Pushed!");
				
				itemField.setText("button X was pressed");
				tableModel.getModel();
				
			}
		});
        
		// adding features
		frame.add(itemLabel);
		frame.add(listAllButton);
		frame.add(itemField);
		
		// ending frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}