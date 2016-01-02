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
		
		
		// establish a connection to the MySQL database
		Connection connection = DriverManager.getConnection("jdbc:mysql://azarbakht.info/swithd_JavaDatabaseApplication");
		System.out.println("Database connection established");
		
//		// establish a connection to the Oracle database
//		Connection connection2 = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port#:oracleDBSID");
		
		
		
	}

}
