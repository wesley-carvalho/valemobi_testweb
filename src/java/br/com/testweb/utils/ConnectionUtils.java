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
                    "https://node156094-env-3196184.jelasticlw.com.br",
                    "root",
                    "IVGpgk51526");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
