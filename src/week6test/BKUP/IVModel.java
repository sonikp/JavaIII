package week6test.BKUP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IVModel
{
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/InventoryDatabase?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private DefaultTableModel model;
	private String query;
	
	public IVModel() throws SQLException
	{
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
			
			this.setModel(model);
			

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
	
	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
}