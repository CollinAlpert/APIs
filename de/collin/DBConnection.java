package de.collin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Collin Alpert
 * @see <a href="https://github.com/CollinAlpert/APIs/blob/master/de/collin/DBConnection.java">GitHub</a>
 */
public class DBConnection implements AutoCloseable {

	public static String HOST;
	public static String DATABASE;
	public static String USERNAME;
	public static String PASSWORD;
	public static DatabaseTypes DATABASE_TYPE;
	public static int PORT;
	private Connection connection = null;
	private boolean isConnectionValid;

	public DBConnection() {
		try {
			String driver;
			String connectionString;
			if (PORT == 0) {
				switch (DATABASE_TYPE) {
					default:
					case MYSQL:
						PORT = 3306;
						break;
					case MICROSOFT:
						PORT = 1433;
						break;
					case ORACLE:
						PORT = 1521;
						break;
				}
			}
			switch (DATABASE_TYPE) {
				default:
				case MYSQL:
					driver = "com.mysql.cj.jdbc.Driver";
					connectionString = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?serverTimezone=UTC";
					break;
				case ORACLE:
					driver = "oracle.jdbc.driver.OracleDriver";
					connectionString = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":orcl";
					//Requires the Oracle JDBC driver library.
					//Delete this block if not needed
					OracleDataSource source = new OracleDataSource();
					source.setDatabaseName(SystemParameter.DATABASE);
					source.setURL(connectionString);
					source.setUser(SystemParameter.USERNAME);
					source.setPassword(SystemParameter.PASSWORD);
					connection = source.getConnection();
					break;
				case MICROSOFT:
					driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					connectionString = "jdbc:sqlserver://" + HOST + ":" + PORT + ";databaseName=" + DATABASE;
					break;
			}
			Class.forName(driver);
			DriverManager.setLoginTimeout(5);
			if (connection == null) {
				connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
			}
			isConnectionValid = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			isConnectionValid = false;
		} catch (Exception e) {
			System.err.println("The connection to the database failed. Please check if the MySQL server is reachable and if you have an internet connection.");
			isConnectionValid = false;
			System.exit(1);
		}
	}

	/**
	 * Checks if the connection is valid/successful.
	 *
	 * @return True if connection was successful, false if not.
	 */
	public boolean isValid() {
		return this.isConnectionValid;
	}


	/**
	 * Executes a DQL statement on the database without Java parameters.
	 *
	 * @param query The query to be executed.
	 * @return The <code>ResultSet</code> containing the result from the SELECT query.
	 */
	public ResultSet execute(String query) {
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Executes a DQL statement on the database with Java parameters.
	 *
	 * @param query  The query to be executed.
	 * @param params The Java parameters to be inserted into the query.
	 * @return The <code>ResultSet</code> containing the result from the SELECT query.
	 */
	public ResultSet execute(String query, Object... params) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			return statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Executes a DML or DDL statement on the database without Java parameters.
	 *
	 * @param query The query to be executed.
	 */
	public void update(String query) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Executes a DML or DDL statement on the database with Java parameters.
	 *
	 * @param query  The query to be executed.
	 * @param params The Java parameters to be inserted into the query.
	 */
	public void update(String query, Object... params) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Determines if a connection to the database still exists or not.
	 *
	 * @return <code>True</code> if a connection exists, <code>false</code> if not.
	 * This method will return <code>false</code> if an exception occurs.
	 */
	public boolean isOpen() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			System.err.println("Could not determine connection status");
			return false;
		}
	}

	/**
	 * Implements close action for when used in a disposable try block.
	 */
	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Could not close database connection");
		} finally {
			isConnectionValid = false;
		}
	}

	public enum DatabaseTypes {
		MYSQL, ORACLE, MICROSOFT
	}
}
