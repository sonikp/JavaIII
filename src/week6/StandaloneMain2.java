package week6;

import javax.swing.*;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;

public class StandaloneMain2
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
			
			// names of columns
			Vector<String> column = new Vector<String>();
			for (int i = 1; i <= columnCount; i++) {
				column.add(metaData.getColumnName(i));
			}
			
			// data of the table
			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while(resultSet.next()) {
				Vector<Object> vector = new Vector<Object>();
				for (int i = 1; i <= columnCount; i++ ) {
					vector.add(resultSet.getObject(i));
				}
				data.add(vector);
			}
			
			
			JFrame frame = new JFrame();
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			JTable table = new JTable(data, column);
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