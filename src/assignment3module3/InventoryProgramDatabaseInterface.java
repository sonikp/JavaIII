package assignment3module3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
import java.sql.PreparedStatement;

public class InventoryProgramDatabaseInterface extends AbstractTableModel
{
	private InventoryProgramModel theModel;
	private InventoryProgramDatabaseInterface theDatabase;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	
	// database URL, username, password
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/InventoryDatabase?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	
	// default query retrieves all data from Inventory table
	private static final String DEFAULT_QUERY = "SELECT * FROM Inventory";
//	private static final String ITEM_QUERY = "SELECT itemID, itemType, title, artist, productCode, quantity FROM Inventory WHERE itemID = 5";
//	private static final String CREATE_QUERY = "INSERT INTO Inventory (itemType, title, artist, productCode, quantity) VALUES ('BOOK', 'A Great Book', 'Sum Wryta', 'POQ55234','4')";
//	private static final String DELETE_QUERY = "DELETE FROM Inventory WHERE itemID = 58";
//	private static final String UPDATE_QUERY = "UPDATE Inventory SET artist = 'fOO bAR' WHERE itemID = 58";

	// creating prepared statements
	private PreparedStatement selectAllInventoryItems;
	private PreparedStatement selectSingleInventoryItem;
	private PreparedStatement insertNewInventoryItem;
	private PreparedStatement deleteInventoryItem;
	private PreparedStatement updateArtistInventoryItem;
	
	// keep track of the database connection status
	private boolean connectedToDatabase = false;
	
	// constructor
	public InventoryProgramDatabaseInterface() throws Exception
	{
		this(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
	}
	
	public InventoryProgramDatabaseInterface(String DATABASE_URL, String USERNAME, String PASSWORD, String DEFAULT_QUERY) throws SQLException // String url, String username, String password, String query
	{
		// connect to database
		connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		// prepared statements
		selectAllInventoryItems = connection.prepareStatement("SELECT * FROM Inventory");
		selectSingleInventoryItem = connection.prepareStatement("SELECT itemID, itemType, title, artist, productCode, quantity FROM Inventory WHERE itemID = ?");
		insertNewInventoryItem = connection.prepareStatement("INSERT INTO Inventory (itemType, title, artist, productCode, quantity) VALUES (?,?,?,?,?)");
		deleteInventoryItem = connection.prepareStatement("DELETE FROM Inventory WHERE itemID = ?");
		updateArtistInventoryItem = connection.prepareStatement("UPDATE Inventory SET artist = ? WHERE itemID = ?");
		
		// create statement to query database
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		// update database connection status
		connectedToDatabase = true;
		
		// set query and execute it
		setQuery(DEFAULT_QUERY);
	}
	
//	// model constructor
//	public InventoryProgramDatabaseInterface(InventoryProgramModel theModel) throws Exception
//	{
//		this();	// calls empty constructor to set up the data
//		this.theModel = theModel;
//	}
	
	
	/// Model Methods
	// LIST ALL
	public void getInventoryALL() throws IOException 
	{
	
		try 
		{
//			setQuery(DEFAULT_QUERY);
			// ensure database connection is available
			if (!connectedToDatabase) {
				throw new IllegalStateException("Not connected to database");
			}
			
			// specify query and execute it
			resultSet = selectAllInventoryItems.executeQuery();
			System.out.println("my first prepared statement");
			
			// obtain metadata for ResultSet
			metaData = resultSet.getMetaData();
			
			// determine number of rows in ResultSet
			resultSet.last();	// move to last row
			numberOfRows = resultSet.getRow();	// get row number
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} 
		catch (SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		}

	}
	
	// LIST SINGLE
	public void getInventorySingle(String itemNum) throws IOException 
	{
		try 
		{
			//TODO assign itemNum for specific search
//			setQuery(ITEM_QUERY);
			// ensure database connection is available
			if (!connectedToDatabase) {
				throw new IllegalStateException("Not connected to database");
			}
			
			// specify query and execute it
			selectSingleInventoryItem.setString(1, itemNum);
			resultSet = selectSingleInventoryItem.executeQuery();
			System.out.println("my first prepared statement");
			
			// obtain metadata for ResultSet
			metaData = resultSet.getMetaData();
			
			// determine number of rows in ResultSet
			resultSet.last();	// move to last row
			numberOfRows = resultSet.getRow();	// get row number
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} 
		catch (SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		}
		

	}
	
	// create
	public void createNewInventorySelectType(String itemType, String title, String artist, String productCode,
			String quantity) {
		// TODO need to create prepared statements
		
		try 
		{
//			setUpdate(CREATE_QUERY);
//			
//			setUpdate(UPDATE_QUERY);
			//TODO assign itemNum for specific search
//			setQuery(ITEM_QUERY);
			// ensure database connection is available
			if (!connectedToDatabase) {
				throw new IllegalStateException("Not connected to database");
			}
			System.out.println("Create Record prepared statement");
			System.out.println(itemType + " " 
					+ title  + " "
					+ artist  + " "
					+ productCode  + " "
					+ quantity);
			// specify query and execute it

			insertNewInventoryItem.setString(1, itemType);
			insertNewInventoryItem.setString(2, title);
			insertNewInventoryItem.setString(3, artist);
			insertNewInventoryItem.setString(4, productCode);
			insertNewInventoryItem.setString(5, quantity);
			insertNewInventoryItem.executeUpdate();
			resultSet = selectAllInventoryItems.executeQuery();
			

			
			// obtain metadata for ResultSet
			metaData = resultSet.getMetaData();
			
			// determine number of rows in ResultSet
			resultSet.last();	// move to last row
			numberOfRows = resultSet.getRow();	// get row number
			
			// notify JTable that model has changed
			fireTableStructureChanged();
			
			
			
		} 
		catch (SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		}
		
	}
	
	// update
	public void updateArtistInventoryItem(String itemNum, String artist) {

		
		try 
		{
//			setUpdate(UPDATE_QUERY);
			//TODO assign itemNum for specific search
//			setQuery(ITEM_QUERY);
			// ensure database connection is available
			if (!connectedToDatabase) {
				throw new IllegalStateException("Not connected to database");
			}
			System.out.println("Update Artist prepared statement");
			System.out.println(itemNum + " " + artist);
			// specify query and execute it

			updateArtistInventoryItem.setString(1, artist);
			updateArtistInventoryItem.setString(2, itemNum);
			updateArtistInventoryItem.executeUpdate();
			resultSet = selectAllInventoryItems.executeQuery();
			

			
			// obtain metadata for ResultSet
			metaData = resultSet.getMetaData();
			
			// determine number of rows in ResultSet
			resultSet.last();	// move to last row
			numberOfRows = resultSet.getRow();	// get row number
			
			// notify JTable that model has changed
			fireTableStructureChanged();
		} 
		catch (SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		}
		
	}

	// delete
	public void deleteItemFromInventory(String itemNum) {

		
		try 
		{
			
//			setUpdate(DELETE_QUERY);
			

			// ensure database connection is available
			if (!connectedToDatabase) {
				throw new IllegalStateException("Not connected to database");
			}
			
			System.out.println("Delete Artist prepared statement");
			System.out.println(itemNum);
			
			// specify query and execute it
			deleteInventoryItem.setString(1, itemNum);
			deleteInventoryItem.executeUpdate();
			resultSet = selectAllInventoryItems.executeQuery();
			
			
			
			// obtain metadata for ResultSet
			metaData = resultSet.getMetaData();
			
			// determine number of rows in ResultSet
			resultSet.last();	// move to last row
			numberOfRows = resultSet.getRow();	// get row number
			
			// notify JTable that model has changed
			fireTableStructureChanged();
			
			
		} 
		catch (SQLException sqlException ) 
		{
			sqlException.printStackTrace();
		}
		
	}
	
	
	// get class that represents column type
	public Class getColumnClass(int column) throws IllegalStateException
	{
		// ensure the database is connected
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not connected to database");
		}
		
		// determine java class of column
		try
		{
			String className = metaData.getColumnClassName(column + 1);
			
			// return class object that represents className
			return Class.forName(className);
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
		
		return Object.class;
	}
	
	// get number of columns
	public int getColumnCount() throws IllegalStateException
	{
		// ensure connected to database
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not connected to database");
		}
		
		// determine number of columns
		try
		{
			return metaData.getColumnCount();
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		return 0; // if problem occur above, return 0 for number of columns
		
	}
	
	// get name of a particular column in ResultSet
	public String getColumnName(int column) throws IllegalStateException
	{
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not connected to database");
		}
		
		// determine column name
		try
		{
			return metaData.getColumnName(column + 1);
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		return ""; // if problem, return empty string for column name
	}
	
	// return number of rows in ResultSet
	public int getRowCount() throws IllegalStateException 
	{
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not connected to database");
		}
		
		return numberOfRows; 
	}
	
	// obtain value in particular row and column
	public Object getValueAt(int row, int column) throws IllegalStateException
	{
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not connected to database");
		}
		
		// obtain a value at specified ResultSet row and column
		try
		{
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		// if problems, return empty string object
		return "";
	}
	
	// set new database query string
	public void setQuery(String query) throws SQLException, IllegalStateException
	{
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not connected to database");
		}
		
		// specify query and execute it
		resultSet = statement.executeQuery(query);
		
		// obtain metadata for ResultSet
		metaData = resultSet.getMetaData();
		
		// determine number of rows in ResultSet
		resultSet.last();	// move to last row
		numberOfRows = resultSet.getRow();	// get row number
		
		// notify JTable that model has changed
		fireTableStructureChanged();
	}
	
	// set new database query string
	public void setUpdate(String query) throws SQLException, IllegalStateException
	{
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not connected to database");
		}
		
		// specify query and execute it
		
		int returned = statement.executeUpdate(query);	
		resultSet = statement.executeQuery("SELECT * FROM Inventory");
		
		// obtain metadata for ResultSet
		metaData = resultSet.getMetaData();
		
		// determine number of rows in ResultSet
		resultSet.last();	// move to last row
		numberOfRows = resultSet.getRow();	// get row number
		
		// notify JTable that model has changed
		fireTableStructureChanged();
	}
	
	// close statement and connection
	public void disconnectFromDatabase()
	{
		if (connectedToDatabase)
		{
			// close Statement and Connection
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			finally // update database connection status
			{
				connectedToDatabase = false;
			}
		}
	}







	
	
}