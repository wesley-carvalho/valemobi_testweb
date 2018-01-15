package br.com.testweb.dao;

import br.com.testweb.classes.Corrida;
import br.com.testweb.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class DaoCorrida {

    public static void cadastrar(Corrida corrida)
            throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO CORRIDA (motorista_id, passageiro_id, valor)"
                + " VALUES (?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, corrida.getMotorista().getId());
            preparedStatement.setInt(2, corrida.getPassageiro().getId());
            preparedStatement.setDouble(3, corrida.getValor());

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static List<Corrida> listar()
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM CORRIDA";

        List<Corrida> listaCorridas = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);            

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaCorridas == null) {
                    listaCorridas = new LinkedList<>();
                }
                Corrida corrida = new Corrida();
                corrida.setId(result.getInt("id"));
                corrida.setMotorista(
                        DaoMotorista.obter(result.getInt("motorista_id")));
                corrida.setPassageiro(
                        DaoPassageiro.obter(result.getInt("passageiro_id")));
                corrida.setValor(result.getDouble("valor"));

                listaCorridas.add(corrida);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return listaCorridas;
    }
}
