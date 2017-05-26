package week6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;

public class StandaloneMain5
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

		try
		{
			connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
			statement = connection.createStatement();
			query = "SELECT * FROM Inventory";
			resultSet = statement.executeQuery(query);
			metaData = resultSet.getMetaData();
			model = new DefaultTableModel(new String[]{"itemID","itemType","title","artist","productCode","quantity"},0);
			int columnCount = metaData.getColumnCount();
			
			// https://www.google.com/search?q=java+datamodel+getcolumnname%28%29
			// get columnname
//		=>	https://stackoverflow.com/questions/696782/retrieve-column-names-from-java-sql-resultset
			// even better
			// https://stackoverflow.com/questions/19094999/java-how-to-get-column-name-on-result-set
			
			while (resultSet.next()) {
				Object rowData[] = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++ ) {
					rowData[i - 1] = resultSet.getObject( i );
					System.out.println("ItemID: "+ resultSet.getString("ItemID"));
				}
				model.addRow(rowData);
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
//			JOptionPane.showMessageDialog(null, "ERROR");
			e.printStackTrace();
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