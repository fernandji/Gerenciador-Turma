package service;

import java.util.List;

import dao.AlunoDAO;
import model.Aluno;

public class AcoesTurma {
    AlunoDAO alunoDAO = new AlunoDAO();

    public void salvarAluno(String nome, double p1, double p2) {
        try {
            Aluno aluno = new Aluno(nome, p1, p2);
            alunoDAO.salvar(aluno);
            System.out.println("\nAluno adicionado com sucesso!\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void visualizarTodos() {
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
    }

    public void imprimirPorID(int id) {
        Aluno aluno = alunoDAO.buscarPorID(id);

        if (aluno != null) {
            System.out.println(aluno);
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    public void excluirAluno(int id) {
        alunoDAO.deletar(id);
        System.out.println("Aluno excluído com sucesso!");
    }

    // public boolean verificarAluno(String nome) {
    // if (alunos.containsKey(nome)) {
    // return true;
    // } else {
    // return false;
    // }
    // }

    public void atualizarNome(int id, String nome) {
        if (alunoDAO.atualizarNome(id, nome)) {
            System.out.println("\nNome de ID:" + id + " foi atualizado com sucesso!\n");
        } else {
            System.out.println("Não foi possível atualizar o aluno.");
        }
    }

    public void atualizarP1(int id, double p1) {
        if (alunoDAO.atualizarP1(id, p1)) {
            System.out.println("\nA P1 de ID:" + id + " foi atualizado com sucesso!\n");
        } else {
            System.out.println("Não foi possível atualizar o aluno.");
        }
    }

    public void atualizarP2(int id, double p2) {
        if (alunoDAO.atualizarP2(id, p2)) {
            System.out.println("\nA P2 de ID:" + id + " foi atualizado com sucesso!\n");
        } else {
            System.out.println("Não foi possível atualizar o aluno.");
        }
    }

    // public void calcularMediaTurma() {
    //     if (alunos.isEmpty()) {
    //         System.out.println("Nenhum aluno cadastrado. ");
    //     } else {
    //         double soma = 0;
    //         for (Aluno aluno : alunos.values()) {
    //             soma += aluno.getMedia();
    //         }
    //         double mediaTurma = soma / alunos.size();
    //         System.out.printf("Média da Turma: %.2f%n", mediaTurma);
    //     }
    // }
}
