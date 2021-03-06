package week6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;

public class StandaloneMain4
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
		DefaultTableModel model = null;
		String query;
		// https://www.google.com/search?q=jtable+mysql+resultset
		// fahdshariff.blogspot.com/2010/02/display-any-resultset-in-jtable.html
		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
			statement = connection.createStatement();
			query = "SELECT * FROM Inventory";
			resultSet = statement.executeQuery(query);
			metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			model = new DefaultTableModel(new String[]{"itemID","itemType","title","artist","productCode","quantity"},0);
			while(resultSet.next()) {
				String itemID = resultSet.getString("itemID");
				String itemType = resultSet.getString("itemType");
				String title = resultSet.getString("title");
				String artist = resultSet.getString("artist");
				String productCode = resultSet.getString("productCode");
				String quantity = resultSet.getString("quantity");
				model.addRow(new Object[]{itemID, itemType, title, artist, productCode,quantity});
			}

			JFrame frame = new JFrame();
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			JTable table = new JTable(model);
			JScrollPane jsp = new JScrollPane(table);
			panel.setLayout(new BorderLayout());
			panel.add(jsp, BorderLayout.CENTER);
			frame.setContentPane(panel);
			frame.setVisible(true);
			
			
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