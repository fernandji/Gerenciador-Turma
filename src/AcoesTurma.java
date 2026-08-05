import java.util.LinkedHashMap;
import java.util.Map;

public class AcoesTurma {

    Map<String, Aluno> alunos = new LinkedHashMap<>();

    public void incluirAluno(String nome, double p1, double p2) {
        try{
            Aluno aluno = new Aluno(nome, p1, p2);
            alunos.put(nome, aluno);
            System.out.println("\nAluno adicionado com sucesso!\n");
            aluno.imprimeAluno();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public void imprimirTodos() {
        if (alunos.isEmpty()) {
            System.out.println("\nNenhum registro encontrado!\n");
        } else {
            for (Aluno aluno : alunos.values()) {
                aluno.imprimeAluno();
            }
        }
    }

    public void imprimirEspecifico(String nome) {
        if (alunos.containsKey(nome)) {
            Aluno aluno = alunos.get(nome);
            aluno.imprimeAluno();
        } else {
            System.out.println("\nAluno não encontrado!\n");
        }
    }

    public void excluirAluno(String nome) {
        if (alunos.containsKey(nome)) {
            alunos.remove(nome);

            System.out.println("\nAluno excluído!\n");
        } else {

            System.out.println("\nAluno não encontrado!\n");
        }
    }

    public boolean verificarAluno(String nome) {
        if (alunos.containsKey(nome)) {
            return true;
        } else {
            return false;
        }
    }

    public void atualizarAluno(String nome, String nome2, double p1, double p2) {
        Aluno aluno = alunos.get(nome);
        try{
            Aluno aluno2 = new Aluno(nome2, p1, p2);
            alunos.remove(nome, aluno);
            alunos.put(nome2, aluno2);
            aluno2.imprimeAluno();
            System.out.println("\nAluno atualizado com sucesso!\n");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }

    public void calcularMediaTurma() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado. ");
        } else {
            double soma = 0;
            for (Aluno aluno : alunos.values()) {
                soma += aluno.getMedia();
            }
            double mediaTurma = soma / alunos.size();
            System.out.printf("Média da Turma: %.2f%n", mediaTurma);
        }
    }
}
