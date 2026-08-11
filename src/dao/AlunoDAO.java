package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import database.ConnectionFactory;
import java.sql.SQLException;
import model.Aluno;

public class AlunoDAO {

    public Aluno buscarPorID(int id) {
        String sql = """
                SELECT * FROM alunos
                WHERE id = ?
                """;

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                double p1 = rs.getDouble("p1");
                double p2 = rs.getDouble("p2");
                return new Aluno(id, nome, p1, p2);
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean salvar(Aluno aluno) {
        String sql = """
                INSERT INTO alunos (nome, p1, p2)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setString(1, aluno.getNome());
            statement.setDouble(2, aluno.getP1());
            statement.setDouble(3, aluno.getP2());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = """
                SELECT * FROM alunos
                """;

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double p1 = rs.getDouble("p1");
                double p2 = rs.getDouble("p2");
                Aluno aluno = new Aluno(id, nome, p1, p2);
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return alunos;
    }

    public boolean deletar(int id) {
        String sql = """
                DELETE FROM alunos
                WHERE id = ?
                """;

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarNome(int id, String nome) {
        String sqlNome = """
                UPDATE alunos
                SET nome = ?
                WHERE id = ?
                """;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlNome);
            statement.setString(1, nome);
            statement.setInt(2, id);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarP1(int id, double p1) {
        String sqlP1 = """
                UPDATE alunos
                SET p1 = ?
                WHERE id = ?
                """;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlP1);
            statement.setDouble(1, p1);
            statement.setInt(2, id);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizarP2(int id, double p2) {
        String sqlP2 = """
                UPDATE alunos
                SET p2 = ?
                WHERE id = ?
                """;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlP2);
            statement.setDouble(1, p2);
            statement.setInt(2, id);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
