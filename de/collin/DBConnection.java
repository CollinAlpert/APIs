package de.collin;

import javax.swing.*;
import java.sql.*;

/**
 * @author Collin Alpert
 * @see <a href="https://github.com/CollinAlpert/APIs/blob/master/de/collin/DBConnection.java">GitHub</a>
 */
public class DBConnection {

    private final String host = "";
    private final String database = "";
    private final String username = "";
    private final String password = "";
    private Connection connection = null;
    private boolean isConnectionValid = false;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.setLoginTimeout(5);
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?autoReconnect=true", username, password);
            isConnectionValid = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Die Datenbank ist nicht online!", "Error", JOptionPane.ERROR_MESSAGE);
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
     * Executes an SELECT SQL statement on the database without Java parameters.
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
     * Executes an SELECT SQL statement on the database with Java parameters.
     * @param query The query to be executed.
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
     * This command is used for any querys that are supposed to update the database, such as UPDATE, DELETE, TRUNCATE etc.
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
     * This command is used for any querys that are supposed to update the database, such as UPDATE, DELETE, TRUNCATE etc.
     * @param query The query to be executed.
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
}
