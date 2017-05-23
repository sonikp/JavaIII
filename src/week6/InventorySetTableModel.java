package week6;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class InventorySetTableModel extends AbstractTableModel
{
	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	
	// keep track of the database connection status
	private boolean connectedToDatabase = false;
	
	// constructor
	public InventorySetTableModel(String url, String username, String password, String query)
	{
		// connect to database
		connection = DriverManager.getConnection(url, username, password);
		
		// create statement to query database
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		// update database connection status
		connectedToDatabase = true;
		
		// set query and execute it
		setQuery(query);
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
		catch (SQLException sqlException) 
		{
			sqlException.printStackTrace();
		}
		
		return Object.class;
	}
	
	// get number of columns
	public Class getColumnCount() throws IllegalStateException
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
	
	
}













