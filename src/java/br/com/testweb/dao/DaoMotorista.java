package br.com.testweb.dao;

import br.com.testweb.classes.Motorista;
import br.com.testweb.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author wesley oliveira de carvalho
 */
public class DaoMotorista {

    public static void cadastrar(Motorista motorista)
            throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO MOTORISTA (nome, cpf, dtNascimento, sexo, "
                + "modelo_do_carro, status) VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, motorista.getNome());
            preparedStatement.setString(2, motorista.getCpf());
            preparedStatement.setTimestamp(3,
                    new Timestamp(motorista.getDt_nascimento().getTime()));
            preparedStatement.setString(4, motorista.getSexo());
            preparedStatement.setString(5, motorista.getModelo_carro());
            preparedStatement.setBoolean(6, motorista.isStatus());

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

    public static void atualizar(Motorista motorista)
            throws ClassNotFoundException, SQLException {
        String sql = "UPDATE MOTORISTA SET nome=?, cpf=?, dtNascimento=?, "
                + "sexo=?, modelo_do_carro=?, status=? WHERE (MOTORISTA.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, motorista.getNome());
            preparedStatement.setString(2, motorista.getCpf());
            preparedStatement.setTimestamp(3,
                    new Timestamp(motorista.getDt_nascimento().getTime()));
            preparedStatement.setString(4, motorista.getSexo());
            preparedStatement.setString(5, motorista.getModelo_carro());
            preparedStatement.setBoolean(6, motorista.isStatus());
            preparedStatement.setInt(7, motorista.getId());

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

    public static List<Motorista> listar()
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM MOTORISTA";

        List<Motorista> listaMotoristas = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            
            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaMotoristas == null) {
                    listaMotoristas = new LinkedList<>();
                }
                Motorista motorista = new Motorista();
                motorista.setId(result.getInt("id"));
                motorista.setNome(result.getString("nome"));
                motorista.setCpf(result.getString("cpf"));
                motorista.setDt_nascimento(
                        new Date(result.getTimestamp("dtNascimento").getTime()));
                motorista.setSexo(result.getString("sexo"));
                motorista.setModelo_carro(result.getString("modelo_do_carro"));
                motorista.setStatus(result.getBoolean("status"));

                listaMotoristas.add(motorista);
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

        return listaMotoristas;
    }

    public static Motorista obter(int id)
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM MOTORISTA WHERE (MOTORISTA.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                Motorista motorista = new Motorista();
                motorista.setId(result.getInt("id"));
                motorista.setNome(result.getString("nome"));
                motorista.setCpf(result.getString("cpf"));
                motorista.setDt_nascimento(
                        new Date(result.getTimestamp("dtNascimento").getTime()));
                motorista.setSexo(result.getString("sexo"));
                motorista.setModelo_carro(result.getString("modelo_do_carro"));
                motorista.setStatus(result.getBoolean("status"));

                return motorista;
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

        return null;
    }

    public static void excluir(int id)
            throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM MOTORISTA WHERE (MOTORISTA.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

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
}
