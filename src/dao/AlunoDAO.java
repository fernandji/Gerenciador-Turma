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


    public List<Aluno> listar(){
        List<Aluno> alunos = new ArrayList<>();
        String sql = """
        SELECT * FROM alunos
        """;

        try(Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();){


                    while(rs.next()){
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        double p1 = rs.getDouble("p1");
                        double p2 = rs.getDouble("p2");
                        Aluno aluno = new Aluno(id, nome, p1, p2);
                        alunos.add(aluno);
                    }
                    if(alunos.isEmpty()){
                        System.out.println("Nenhum aluno encontrado!");
                    }
                    

        }catch(SQLException e){
            e.printStackTrace();
        }
        return alunos;
    }

}
