package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import database.ConnectionFactory;
import java.sql.SQLException;
import model.Aluno;

public class AlunoDAO {

    public void salvar(Aluno aluno) {

        String sql = """
                INSERT INTO alunos (nome, p1, p2)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);) {
                    
            statement.setString(1, aluno.getNome());
            statement.setDouble(2, aluno.getP1());
            statement.setDouble(3, aluno.getP2());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
