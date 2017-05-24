package week6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ExerciseInventoryQueries
{
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/InventoryDatabase?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	
	private Connection connection;
	private PreparedStatement selectAllItems;
	private PreparedStatement selectArtistByName;
	private PreparedStatement insertNewItem;
	
	// constructor
	public ExerciseInventoryQueries()
	{
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			// create statement to get all inventory items
			selectAllItems = connection.prepareStatement("SELECT * FROM Inventory");
			
			// create query that selects entries with a specific artist name
			selectArtistByName = connection.prepareStatement("SELECT * FROM Inventory WHERE artist = ?");
			
			// create insert that inserts a new inventory item
			insertNewItem = connection.prepareStatement("INSERT INTO Inventory (itemType, title, artist, productCode, quantity) VALUES (?, ?, ?, ?, ? )");
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<ExerciseInventory> getAllItems()
	{
		List<ExerciseInventory> results = null;
		ResultSet resultSet = null;
		
		try
		{
			// executeQuery returns ResultSet containing all entries
			resultSet = selectAllItems.executeQuery();
			results = new ArrayList<ExerciseInventory>();
			
			while (resultSet.next())
			{
				results.add(new ExerciseInventory(resultSet.getString("itemType"),
						resultSet.getString("title"),
						resultSet.getString("artist"),
						resultSet.getString("productCode"),
						resultSet.getString("quantity")));
			}
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally
		{
			try
			{
				resultSet.close();
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
				close();
			}
		}
		
		return results;
	}
	
	// select artist by name
	public List<ExerciseInventory> getItemByArtistName(String name)
	{
		List<ExerciseInventory> results = null;
		ResultSet resultSet = null;
		
		try
		{
			selectArtistByName.setString(1, name);	// specify name
			
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectArtistByName.executeQuery();
			
			results = new ArrayList<ExerciseInventory>();
			
			while (resultSet.next())
			{
				results.add(new ExerciseInventory(resultSet.getString("itemType"),
						resultSet.getString("title"),
						resultSet.getString("artist"),
						resultSet.getString("productCode"),
						resultSet.getString("quantity")));
			}
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally
		{
			try
			{
				resultSet.close();
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
				close();
			}
		}
		
		return results;
	}
	
	// add an entry
	public int addInventoryItem(String itemType, String title, String artist, String productCode, String quantity)
	{
		int results = 0;
		
		// set parameters, then execute insertNewItem
		try
		{
			insertNewItem.setString(1, itemType);
			insertNewItem.setString(2, title);
			insertNewItem.setString(3, artist);
			insertNewItem.setString(4, productCode);
			insertNewItem.setString(5, quantity);
			
			results = insertNewItem.executeUpdate();
			
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			close();
		}
		
		return results;
	}
	
	// close the database connection
	public void close()
	{
		try
		{
			connection.close();
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
	}
}































