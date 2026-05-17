import java.util.LinkedHashMap;
import java.util.Map;

public class AcoesTurma {

    Map<String, Aluno> alunos = new LinkedHashMap<>();

    public void incluirAluno(String nome, double p1, double p2) {
        Aluno aluno = new Aluno(nome, p1, p2);
        alunos.put(nome, aluno);
        System.out.println("\nAluno adicionado com sucesso!\n");
        aluno.imprimeAluno();
    }

    public void imprimirTodos() {
        if (alunos.isEmpty()) {
            System.out.println("\nNenhum registro encontrado!\n");
        } else {
            for (String nome : alunos.keySet()) {
                Aluno aluno = alunos.get(nome);
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
        Aluno aluno2 = new Aluno(nome2, p1, p2);
        alunos.remove(nome, aluno);
        alunos.put(nome2, aluno2);
        aluno2.imprimeAluno();
        System.out.println("\nAluno atualizado com sucesso!\n");

    }
}
