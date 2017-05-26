package week6;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

			int columnCount = metaData.getColumnCount();

			String columnName[] = new String[columnCount];
			String rowData[] = new String[columnCount];
			
			// get column names
			for (int i = 1; i <= columnCount; i++ ) {
				columnName[i - 1] = metaData.getColumnName(i);
			}
			model = new DefaultTableModel(columnName, 0);
			
			// get row information
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++ ) {
					rowData[i - 1] = resultSet.getString( i );
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
			JOptionPane.showMessageDialog(null, "ERROR");
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