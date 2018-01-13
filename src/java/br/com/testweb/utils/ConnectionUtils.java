package br.com.testweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wesley oliveira de carvalho
 */

public class ConnectionUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDataSource");

        Connection connection;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/TestWeb",
                    "root",
                    "root");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
