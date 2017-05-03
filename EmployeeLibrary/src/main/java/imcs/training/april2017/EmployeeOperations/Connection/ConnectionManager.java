
package imcs.training.april2017.EmployeeOperations.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	 
	private static Connection connection;
	
	private ConnectionManager()
	{
		
	}
	
	/**
	 * This method will be used to establish connection with database
	 * @return connection
	 */
	public static Connection getConnection(){
	
		
		final String driver="com.mysql.jdbc.Driver";
		
		final String url="jdbc:mysql://localhost:3306/imcs";
		
		final String user="root";
		
		final String password="admin";

		
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) 
		{
			System.out.println("fail to give connection");
		} catch (ClassNotFoundException e)
		{
			System.out.println("fail to find the class");
		}
		return connection;
	}
	
	/**
	 * This method is used to close the connection variable
	 */
	public static void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fail to close the Connection");
		}
	}

}
