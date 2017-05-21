package week6;
// fig 24.25
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel 
{
	private final Connection connection;
	private final Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	
	// keep track of database connection status
	private boolean connectedToDatabase = false;
	
	//
	public ResultSetTableModel(String url, String username, String password, String query) throws SQLException
	{
		// connected to database
		connection = DriverManager.getConnection(url, username, password);
		
		// create statement to query database
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		// update database connection status
		connectedToDatabase = true;
		
		// set query and execute it
		setQuery(query);
	}
	
	// get number of columns in ResultSet
	public int getColumnCount() throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
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
		
		// if problems occur above, return 0 for number of columns
		return 0;
	}
	
	// get name of a particular column in ResultSet
	public String getColumnName(int column) throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
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
		
		// if problems, return empty string for column name
		return "";
	}
	
	// return number of rows in ResultSet
	public int getRowCount() throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}
		
		return numberOfRows;
	}
	
	// obtain value in particular row and column
	public Object getValueAt(int row, int column) throws IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
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
	public void setQuery(String query) throws SQLException, IllegalStateException {
		// ensure database connection is available
		if (!connectedToDatabase) {
			throw new IllegalStateException("Not Connected to Database");
		}
		
		// specify query and execute it
		resultSet = statement.executeQuery(query);
		
		// obtain metadata for ResultSet
		metaData = resultSet.getMetaData();
		
		// determine number of rows in ResultSet
		resultSet.last();					// move to last row
		numberOfRows = resultSet.getRow(); // get row number
		
		// notify JTable that model has changed
		fireTableStructureChanged();
	}
	
	// close Statement and connection
	public void disconnectFromDatabase()
	{
		if (connectedToDatabase) {
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



















