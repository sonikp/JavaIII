package week6;
// fig 24.23


// uses DB file demo.sql

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;




public class DisplayEmployees 
{
	public static void main(String[] args) throws Exception
	{
		final String DATABASE_URL = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
		final String SELECT_QUERY = "SELECT id, last_name, first_name FROM employees";
		
		// use try-with-resource to connect to and query the database
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "mysql");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {
			
			// get ResultSet's meta data
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			
			System.out.printf("Employees Table of Folks:%n%n");
			
			// display the names of the columns in the ResultSet
			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.printf("%-8s\t", metaData.getColumnName(i));
			}
			System.out.println();
			
			// display query results
			while (resultSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++) 	{
					System.out.printf("%-8s\t", resultSet.getObject(i));
				}
				System.out.println();
			}	// AutoClosable objects' close methods are called now
		}
			catch (SQLException sqlException) {			
				sqlException.printStackTrace();
		}
	}
		
}
	

