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
 		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "swithd_javadba", "emerson(&)");
		// if localhost

//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4000/swithd_JavaDatabaseApplication", "swithd_javadba", "emerson(&)");
//		// if connecting to my hosting cpanel database, since ssh remote SQL connections is disabled, do SSH (via terminal) instead: ssh -L 4000:127.0.0.1:3306 -p 21098 -l swithd -N server53.web-hosting.com
 		
//		// establish a connection to the Oracle database
//		Connection connection2 = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port#:oracleDBSID");

 		System.out.println("Database connection established");
		
		
		// create a SQL statement
		Statement statement = connection.createStatement();
		System.out.println("Database statement created");

		
		// execute a statement (which returns nothing)
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS Emerson (col1 char(5), col2 char(5))");
		System.out.println("Database statement executed");
		
		// get results of executing a statement (which returns something)
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Movies");
		System.out.println("Database statement executed and loaded to resultSet");
		
		// process the result retrieved from the database
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
		}
		
		// parameterized SQL statement
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Movies (movie_id, title, director, year_released, category_id) " + "values (?, ?, ?, ?, ?)");
		preparedStatement.setInt(1, 3);
		preparedStatement.setString(2, "Close-Up");
		preparedStatement.setString(3,"Kiarostami");
		preparedStatement.setInt(4, 1989);
		preparedStatement.setInt(5, 1);
		preparedStatement.executeUpdate();
		System.out.println("Database preparedStatement executed, database updated successfully");
		
		String queryString = "SELECT * FROM Members WHERE gender = ?";
		PreparedStatement preparedStatement2 = connection.prepareStatement(queryString);
		preparedStatement2.setString(1, "Female");
		
		ResultSet resultSet2 = preparedStatement2.executeQuery();

		System.out.println("2nd preparedStatement executed");
		while (resultSet2.next()) {
			System.out.println(resultSet2.getString(2) + " ");
		}
		
		
//		// callable statement: to call SQL functions with our parameters of choice
//		CallableStatement callableStatement = connection.prepareCall("{? = call functionNameFindMovies(?, ?)}");
//		callableStatement.setString(2, "Close-Up");
//		callableStatement.setString(3, "Ghost Rider");
//		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
//		callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
//		ResultSet resultSet3 = callableStatement.executeQuery();
//		System.out.println("Callable statement executed");
//
//		while (resultSet3.next()) {
//			System.out.println(resultSet3.getString(2) + " " + resultSet3.getString(3));
//		}
		
		
		
		// getting the database's metadata
		DatabaseMetaData dbMetaData = connection.getMetaData();
		System.out.println(dbMetaData.getURL());
		System.out.println(dbMetaData.getUserName());
		System.out.println(dbMetaData.getDatabaseProductName());
		System.out.println(dbMetaData.getDriverName());
		System.out.println(dbMetaData.getMaxTableNameLength());
		ResultSet resultSet4 = dbMetaData.getTables(null, null, null, new String[] {"TABLE"});
		while(resultSet4.next()){
			System.out.println(resultSet4.getString("TABLE_NAME") + " ");
		}
		
		// getting the ResultSet's metadata to see what it contains
		ResultSetMetaData resultSetMetaData = resultSet4.getMetaData();
		for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
			System.out.println(resultSetMetaData.getColumnName(i));
		}
		
		while(resultSet4.next()){
			for (int j = 1; j < resultSetMetaData.getColumnCount(); j++) {
				System.out.println(resultSet4.getObject(j));
			}
			
		}
		
		
		connection.close();
	}

}
