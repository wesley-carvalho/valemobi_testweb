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
        Connection connection = null;
        
        Class.forName("com.mysql.jdbc.Driver");        

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://node156094-env-3196184.jelasticlw.com.br/testweb",
                    "root",
                    "IVGpgk51526");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
