import java.util.Scanner;

public class MenuTurma {
    Scanner leitor = new Scanner(System.in);
    AcoesTurma acoes = new AcoesTurma();

    public void menuPrincipal() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("|------ GERENCIADOR DE TURMA ------|");
            System.out.println(
                    "1 - Incluir Aluno\n2 - Visualizar Registros\n3 - Excluir Aluno\n4 - Atualizar Registro\n0 - Encerrar Programa");

            opcao = leitor.nextInt();
            switch (opcao) {
                // ENCERRA PROGRAMA
                case 0:
                    System.out.println("Encerrando...");
                    break;

                // INCLUIR ALUNO
                case 1:
                    System.out.print("Insira o nome: ");
                    String nome = leitor.next();
                    System.out.print("Insira a nota P1: ");
                    double p1 = leitor.nextDouble();
                    System.out.print("Insira a nota P2: ");
                    double p2 = leitor.nextDouble();
                    acoes.incluirAluno(nome, p1, p2);
                    break;

                // VISUALIZAR REGISTROS
                case 2:
                    System.out.println(
                            "\n1 - Visualizar todos os registros\n2 - Visualizar aluno específico\n3 - Visualizar média da turma ");
                    int escolha = leitor.nextInt();
                    if (escolha == 1) {
                        acoes.imprimirTodos();
                    } else if (escolha == 2) {
                        System.out.print("Digite o nome do aluno a ser visualizado: ");
                        nome = leitor.next();
                        acoes.imprimirEspecifico(nome);
                    } else if (escolha == 3) {
                        acoes.calcularMediaTurma();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                // EXCLUIR ALUNO
                case 3:
                    System.out.print("Digite o nome do aluno a ser excluído: ");
                    nome = leitor.next();
                    acoes.excluirAluno(nome);
                    break;

                // ATUALIZAR ALUNO
                case 4:
                    System.out.print("Digite o nome do aluno para atualizar cadastro: ");
                    nome = leitor.next();
                    if (acoes.verificarAluno(nome)) {
                        System.out.println("Sobrescreva as informações: ");
                        System.out.print("Insira o nome: ");
                        String nome2 = leitor.next();
                        System.out.print("Insira a nota P1: ");
                        p1 = leitor.nextDouble();
                        System.out.print("Insira a nota P2: ");
                        p2 = leitor.nextDouble();
                        acoes.atualizarAluno(nome, nome2, p1, p2);
                        break;
                    } else {
                        System.out.println("\nAluno não encontrado!\n");
                        break;
                    }
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

    }
}