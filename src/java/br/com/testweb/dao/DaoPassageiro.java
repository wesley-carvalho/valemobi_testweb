package br.com.testweb.dao;

import br.com.testweb.classes.Passageiro;
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
public class DaoPassageiro {

    public static void cadastrar(Passageiro passageiro)
            throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO PASSAGEIRO (nome, cpf, dtNascimento, sexo) "
                + "VALUES (?, ?, ?, ?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, passageiro.getNome());
            preparedStatement.setString(2, passageiro.getCpf());
            preparedStatement.setTimestamp(3,
                    new Timestamp(passageiro.getDt_nascimento().getTime()));
            preparedStatement.setString(4, passageiro.getSexo());

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

    public static void atualizar(Passageiro passageiro)
            throws ClassNotFoundException, SQLException {
        String sql = "UPDATE PASSAGEIRO SET nome=?, cpf=?, dtNascimento=?, "
                + "sexo=? WHERE (PASSAGEIRO.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, passageiro.getNome());
            preparedStatement.setString(2, passageiro.getCpf());
            preparedStatement.setTimestamp(3,
                    new Timestamp(passageiro.getDt_nascimento().getTime()));
            preparedStatement.setString(4, passageiro.getSexo());
            preparedStatement.setInt(5, passageiro.getId());

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

    public static List<Passageiro> listar()
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM PASSAGEIRO";

        List<Passageiro> listaPassageiros = null;

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);            

            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaPassageiros == null) {
                    listaPassageiros = new LinkedList<>();
                }
                Passageiro passageiro = new Passageiro();
                passageiro.setId(result.getInt("id"));
                passageiro.setNome(result.getString("nome"));
                passageiro.setCpf(result.getString("cpf"));
                passageiro.setDt_nascimento(
                        new Date(result.getTimestamp("dtNascimento").getTime()));
                passageiro.setSexo(result.getString("sexo"));

                listaPassageiros.add(passageiro);
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

        return listaPassageiros;
    }

    public static Passageiro obter(int id)
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM PASSAGEIRO WHERE (PASSAGEIRO.id=?)";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setId(result.getInt("id"));
                passageiro.setNome(result.getString("nome"));
                passageiro.setCpf(result.getString("cpf"));
                passageiro.setDt_nascimento(
                        new Date(result.getTimestamp("dtNascimento").getTime()));
                passageiro.setSexo(result.getString("sexo"));

                return passageiro;
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
        String sql = "DELETE FROM PASSAGEIRO WHERE (PASSAGEIRO.id=?)";

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
