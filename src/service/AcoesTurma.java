package service;

import java.util.List;

import dao.AlunoDAO;
import model.Aluno;

public class AcoesTurma {
    AlunoDAO alunoDAO = new AlunoDAO();

    // SALVAR ALUNO
    public void salvarAluno(String nome, double p1, double p2) {
        Aluno aluno = new Aluno(nome, p1, p2);
        if (alunoDAO.salvar(aluno)) {
            System.out.println("\nAluno adicionado com sucesso!\n");
        } else {
            System.out.println("\nNão foi possível adicionar o aluno.\n");
        }
    }

    // IMPRIMIR TODOS OS ALUNOS
    public void visualizarTodos() {
        try {
            List<Aluno> alunos = alunoDAO.listar();

            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno encontrado!");
                return;
            }
            int maiorNome = "Nome".length();

            for (Aluno aluno : alunos) {
                if (aluno.getNome().length() > maiorNome) {
                    maiorNome = aluno.getNome().length();
                }
            }

            String linhaNome = "─".repeat(maiorNome + 2);

            System.out.println("┌────┬" + linhaNome + "┬────────┬────────┬────────┬────────────┐");

            System.out.printf(
                    "│ %-2s │ %-" + maiorNome + "s │ %-6s │ %-6s │ %-6s │ %-10s │%n",
                    "ID", "Nome", "P1", "P2", "Média", "Status");

            System.out.println("├────┼" + linhaNome + "┼────────┼────────┼────────┼────────────┤");

            for (Aluno aluno : alunos) {
                System.out.printf(
                        "│ %-2d │ %-" + maiorNome + "s │ %-6.2f │ %-6.2f │ %-6.2f │ %-10s │%n",
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getP1(),
                        aluno.getP2(),
                        aluno.getMedia(),
                        aluno.alunoStatus());
            }

            System.out.println("└────┴" + linhaNome + "┴────────┴────────┴────────┴────────────┘");

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // IMPRIMIR POR BUSCA DE ID
    public void imprimirPorID(int id) {
        Aluno aluno = alunoDAO.buscarPorID(id);

        if (aluno != null) {
            System.out.println(aluno);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    // EXCLUIR ALUNO
    public void excluirAluno(int id) {
        if (alunoDAO.deletar(id)) {
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Não foi possível excluir o aluno.");
        }
    }

    // ATUALIZA NOME
    public void atualizarNome(int id, String nome) {
        if (alunoDAO.atualizarNome(id, nome)) {
            System.out.println("\nNome de ID:" + id + " foi atualizado com sucesso!\n");
        } else {
            System.out.println("Não foi possível atualizar o aluno.");
        }
    }

    // ATUALIZA NOTA P1
    public void atualizarP1(int id, double p1) {
        if (alunoDAO.atualizarP1(id, p1)) {
            System.out.println("\nA P1 de ID:" + id + " foi atualizado com sucesso!\n");
        } else {
            System.out.println("Não foi possível atualizar o aluno.");
        }
    }

    // ATUALIZA NOTA P2
    public void atualizarP2(int id, double p2) {
        if (alunoDAO.atualizarP2(id, p2)) {
            System.out.println("\nA P2 de ID:" + id + " foi atualizado com sucesso!\n");
        } else {
            System.out.println("Não foi possível atualizar o aluno.");
        }
    }

    // CALCULA MÉDIA DA TURMA
    public double calcularMediaTurma() {
        try{
            List<Aluno> alunos = alunoDAO.listar();
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno encontrado!");
            }
            double total = 0;
            for (Aluno aluno : alunos) {
                total += aluno.getMedia();
            }
            return total / alunos.size();   
        } catch(NullPointerException e){
            e.printStackTrace();
            return 0;
        } catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        
    }
}
