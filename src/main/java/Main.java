
import java.util.Scanner;
import java.util.*;
import java.sql.*;
import java.sql.ResultSet;


public class Main
{
    public static void main(String args[])
    {
        
        //MysqlConnection mysql_conn=new MysqlConnection();
        //Connection con=mysql_conn.conn("root", "rootpass");

        
    	
        String url = "jdbc:mysql://localhost:3306/online_grocerystore_management_system";
		String username = "root";
		String password = "rootpass";

		System.out.println("Loading driver...");

		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
	    	System.out.println("Database connected!");
	    	
			} catch (SQLException e) {
	    throw new IllegalStateException("Cannot connect the database!", e);
		}
		

	}
}
