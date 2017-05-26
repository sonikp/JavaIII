package week6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class StandaloneMain3
{
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/InventoryDatabase?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";

	
	
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData metaData = null;
		DefaultTableModel dataModel;
		String query;

		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
			statement = connection.createStatement();
			query = "SELECT * FROM Inventory";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int itemID = resultSet.getInt("itemID");
				String itemType = resultSet.getString("itemType");
				String title = resultSet.getString("title");
				String artist = resultSet.getString("artist");
				String productCode = resultSet.getString("productCode");
				String quantity = resultSet.getString("quantity");
				System.out.println(itemID + "\t" +
						itemType + "\t" +
						title + "\t" +
						artist + "\t" +
						productCode + "\t" +
						quantity + "\t");
				
			}



			
			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally
		{
			try
			{
				statement.close();
				resultSet.close();
				connection.close();
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
	}
}