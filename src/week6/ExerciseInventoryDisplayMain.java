package week6;
// fig 24.32
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class ExerciseInventoryDisplayMain extends JFrame
{
	private ExerciseInventory currentEntry;
	private ExerciseInventoryQueries inventoryQueries;
	private List<ExerciseInventory> results;
	private int numberOfEntries = 0;
	private int currentEntryIndex;
	
	private JButton browseButton;
	
	private JLabel productCodeLabel;
	private JTextField productCodeTextField;
	
	private JLabel titleLabel;
	private JTextField titleTextField;
	
	private JLabel itemTypeLabel;	
	private JTextField itemTypeTextField;
	
	private JTextField indexTextField;
	
	private JLabel artistLabel;
	private JTextField artistTextField;
	
	private JTextField maxTextField;
	private JButton nextButton;
	private JLabel ofLabel;
	
	private JLabel quantityLabel;
	private JTextField quantityTextField;
	
	private JButton previousButton;
	private JButton queryButton;
	private JLabel queryLabel;
	private JPanel queryPanel;
	private JPanel navigatePanel;
	private JPanel displayPanel;
	private JTextField queryTextField;
	private JButton insertButton;
	
	// establish JTABLE
	
	
	
	
	// constructor
	public ExerciseInventoryDisplayMain()
	{
		super("Inventory Items");
		
		// establish database connection and set up PreparedStatements
//		inventoryQueries = new PersonQueries();
		inventoryQueries = new ExerciseInventoryQueries();
		
		// create GUI
		navigatePanel = new JPanel();
		previousButton = new JButton();
		indexTextField = new JTextField(2);
		ofLabel = new JLabel();
		maxTextField = new JTextField(2);
		nextButton = new JButton();
		displayPanel = new JPanel();
		itemTypeLabel = new JLabel();
		itemTypeTextField = new JTextField(10);
		titleLabel = new JLabel();
		titleTextField = new JTextField(10);
		artistLabel = new JLabel();
		artistTextField = new JTextField(10);
		productCodeLabel = new JLabel();
		productCodeTextField = new JTextField(10);
		quantityLabel = new JLabel();
		quantityTextField = new JTextField(10);
		queryPanel = new JPanel();
		queryLabel = new JLabel();
		queryTextField = new JTextField(10);
		queryButton = new JButton();
		browseButton = new JButton();
		insertButton = new JButton();
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		setSize(400, 400);
		setResizable(false);
		
		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
		
		
		
		previousButton.setText("Previous");
		previousButton.setEnabled(false);
		previousButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				previousButtonActionPerformed(event);
				
			}
		});
		
		navigatePanel.add(previousButton);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		indexTextField.setHorizontalAlignment(JTextField.CENTER);
		indexTextField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				indexTextFieldActionPerformed(event);
				
			}
		});
		
		navigatePanel.add(indexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		ofLabel.setText("of");
		navigatePanel.add(ofLabel);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		maxTextField.setHorizontalAlignment(JTextField.CENTER);
		maxTextField.setEditable(false);
		navigatePanel.add(maxTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		
		nextButton.setText("Next");
		nextButton.setEnabled(false);
		nextButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				nextButtonActionPerformed(event);
			}
		});
		
		navigatePanel.add(nextButton);
		add(navigatePanel);
		
		displayPanel.setLayout(new GridLayout(5, 2, 4, 4));
		
		itemTypeLabel.setText("Address ID:");
		displayPanel.add(itemTypeLabel);
		
		itemTypeTextField.setEditable(false);
		displayPanel.add(itemTypeTextField);
		
		titleLabel.setText("First Name:");
		displayPanel.add(titleLabel);
		displayPanel.add(titleTextField);
		
		artistLabel.setText("Last Name:");
		displayPanel.add(artistLabel);
		displayPanel.add(artistTextField);
		
		productCodeLabel.setText("Email:");
		displayPanel.add(productCodeLabel);
		displayPanel.add(productCodeTextField);
		
		quantityLabel.setText("Phone Number:");
		displayPanel.add(quantityLabel);
		displayPanel.add(quantityTextField);
		add(displayPanel);
		
		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
		
		queryPanel.setBorder(BorderFactory.createTitledBorder("Find an entry by last name"));
		queryLabel.setText("Last Name:");
		queryPanel.add(Box.createHorizontalStrut(5));
		queryPanel.add(queryLabel);
		queryPanel.add(Box.createHorizontalStrut(10));
		queryPanel.add(queryTextField);
		queryPanel.add(Box.createHorizontalStrut(10));
		
		queryButton.setText("Find");
		queryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				queryButtonActionPerformed(event);
			}
		});
		
		queryPanel.add(queryButton);
		queryPanel.add(Box.createHorizontalStrut(5));
		add(queryPanel);
		
		browseButton.setText("Browse All Entries");
		browseButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				browseButtonActionPerformed(event);
			}
		});
		
		add(browseButton);
		
		insertButton.setText("Insert New Entry");
		insertButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				insertButtonActionPerformed(event);
				
			}
		});
		
		add(insertButton);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent event) {

				inventoryQueries.close();
				System.exit(0);
			}
			
		});
		
		setVisible(true);
		
	} // end constructor
	
	// handles call when previousButton is clicked
	private void previousButtonActionPerformed(ActionEvent event) 
	{
		currentEntryIndex--;
		
		if (currentEntryIndex < 0 ) {
			currentEntryIndex = numberOfEntries - 1;
		}
		
		indexTextField.setText(" " + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(event);
	}
	
	// handles call when nextButton is clicked
	private void nextButtonActionPerformed(ActionEvent event)
	{
		currentEntryIndex++;
		
		if (currentEntryIndex >= numberOfEntries) {
			currentEntryIndex = 0;
		}
		
		indexTextField.setText(" " + (currentEntryIndex + 1 ));
		indexTextFieldActionPerformed(event);
		
	}
	
	// handles call when queryButton is clicked
	private void queryButtonActionPerformed(ActionEvent event)
	{
		results = inventoryQueries.getItemByArtistName(queryTextField.getText());
		numberOfEntries = results.size();
		
		if (numberOfEntries != 0 ) {
			currentEntryIndex = 0;
			currentEntry = results.get(currentEntryIndex);
//			itemTypeTextField.setText(" " + currentEntry.getAddressID());
			itemTypeTextField.setText(" " + currentEntry.getItemType());
			titleTextField.setText(currentEntry.getTitle());
			artistTextField.setText(currentEntry.getArtist());
			productCodeTextField.setText(currentEntry.getProductCode());
			quantityTextField.setText(currentEntry.getQuantity());
			maxTextField.setText(" " + numberOfEntries);
			indexTextField.setText(" " + (currentEntryIndex + 1));
			nextButton.setEnabled(true);
			previousButton.setEnabled(true);
		}
		else {
			browseButtonActionPerformed(event);
		}
		
	}
	
	// handles call when a new value is entered in indexTextField
	private void indexTextFieldActionPerformed(ActionEvent event) 
	{
		currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);
		
		if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries)
		{
			currentEntry = results.get(currentEntryIndex);
			itemTypeTextField.setText("" + currentEntry.getItemType());
			titleTextField.setText(currentEntry.getTitle());
			artistTextField.setText(currentEntry.getArtist());
			productCodeTextField.setText(currentEntry.getProductCode());
			quantityTextField.setText(currentEntry.getQuantity());
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
		}
	}
		
	// handles call when browserButton is clicked
	private void browseButtonActionPerformed(ActionEvent event)
	{
		try
		{
			results = inventoryQueries.getAllItems();
			numberOfEntries = results.size();
			
			if (numberOfEntries != 0)
			{
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				itemTypeTextField.setText("" + currentEntry.getItemType());
				titleTextField.setText(currentEntry.getTitle());
				artistTextField.setText(currentEntry.getArtist());
				productCodeTextField.setText(currentEntry.getProductCode());
				quantityTextField.setText(currentEntry.getQuantity());
				maxTextField.setText("" + numberOfEntries);
				indexTextField.setText("" + (currentEntryIndex + 1 ));
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			}
		}
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}
	
	// handles call when insertButton is clicked
	private void insertButtonActionPerformed(ActionEvent event)
	{
		
		int result = inventoryQueries.addInventoryItem(itemTypeTextField.getText(),
				titleTextField.getText(), 
				artistTextField.getText(),
				productCodeTextField.getText(),
				quantityTextField.getText());
		
		if (result == 1 ) {
			JOptionPane.showMessageDialog(this,  "Person added!", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this, "Person NOT added!", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		
		browseButtonActionPerformed(event);
	}
	
	public static void main(String[] args)
	{
		new ExerciseInventoryDisplayMain();
	}
	
	
}























