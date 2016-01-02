package databaseApplication;

import java.sql.*;


public class DatabaseApplication {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Emerson Amirhosein  Azarbakht's Java Database Program Application");
		
		// load the mySQL driver
		Class.forName("com.mysql.jdbc.Driver");
		// for this to work, you need to include the mysqljdbc.jar as an External JAR library, or to the build PATH

//		// load the Access driver
//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

//		// load the Oracle database driver
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("Database driver loaded");
		
//		// establish a connection to the MySQL database
// 		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "swithd_javadba", "emerson(&)");
//		// if localhost
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4000/swithd_JavaDatabaseApplication", "swithd_javadba", "emerson(&)");
		// if connecting to my hosting cpanel database, since ssh remote SQL connections is disabled, do SSH (via terminal) instead: ssh -L 4000:127.0.0.1:3306 -p 21098 -l swithd -N server53.web-hosting.com
		System.out.println("Database connection established");
		
//		// establish a connection to the Oracle database
//		Connection connection2 = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port#:oracleDBSID");
		
		// create a SQL statement
		Statement statement = connection.createStatement();
		System.out.println("Database statement created");
		
//		// execute a statement (which returns nothing)
		statement.executeUpdate("create table Emerson (col1 char(5), col2 char(5))");
		System.out.println("Database statement executed");
		
		// get results of executing a statement (which returns something)
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Temp");
		System.out.println("Database statement executed and loaded to resultSet");
		
		// process the result retrieved from the database
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
		}
		
	}

}
