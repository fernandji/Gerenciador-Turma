package ui;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import service.AcoesTurma;

public class MenuTurma {
    Scanner leitor = new Scanner(System.in, StandardCharsets.UTF_8);
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
                    leitor.nextLine();
                    System.out.print("Insira o nome: ");
                    String nome = leitor.nextLine();
                    System.out.print("Insira a nota P1: ");
                    double p1 = leitor.nextDouble();
                    System.out.print("Insira a nota P2: ");
                    double p2 = leitor.nextDouble();
                    acoes.salvarAluno(nome, p1, p2);
                    break;

                // VISUALIZAR REGISTROS
                case 2:
                    System.out.print("O que deseja visualizar?");
                    System.out.println(
                            "\n 1 - Visualizar todos os registros\n 2 - Visualizar aluno específico\n 3 - Visualizar média da turma ");
                    int escolha = leitor.nextInt();
                    // TODOS OS ALUNOS
                    if (escolha == 1) {
                        acoes.visualizarTodos();
                    // ALUNO POR ID
                    } else if (escolha == 2) {
                        System.out.print("Digite o ID do aluno a ser visualizado: ");
                        int id = leitor.nextInt();
                        acoes.imprimirPorID(id);
                    //MEDIA DA TURMA 
                    } else if (escolha == 3) {
                        double media = acoes.calcularMediaTurma();
                        System.out.printf("Média da turma é %.2f%n", media);
                    } else {
                        System.out.println("Insira uma opção válida!");
                    }
                    break;

                // // EXCLUIR ALUNO
                case 3:
                    System.out.print("Digite o ID do aluno a ser excluído: ");
                    int id = leitor.nextInt();
                    acoes.excluirAluno(id);
                    break;

                // // ATUALIZAR ALUNO
                case 4:
                    System.out.println("O que deseja atualizar?");
                    System.out.println(" 1 - Nome\n 2 - P1\n 3 - P2");
                    opcao = leitor.nextInt();
                    if (opcao == 1) {
                        System.out.print("Digite o ID do aluno a ser atualizado: ");
                        id = leitor.nextInt();
                        leitor.nextLine();
                        System.out.print("Digite o nome atualizado: ");
                        nome = leitor.nextLine();
                        acoes.atualizarNome(id, nome);
                    } else if (opcao == 2) {
                        System.out.print("Digite o ID do aluno a ser atualizado: ");
                        id = leitor.nextInt();
                        System.out.print("Digite a nota P1 atualizada: ");
                        p1 = leitor.nextDouble();
                        acoes.atualizarP1(id, p1);
                    } else if (opcao == 3) {
                        System.out.print("Digite o ID do aluno a ser atualizado: ");
                        id = leitor.nextInt();
                        System.out.print("Digite a nota P2 atualizada: ");
                        p2 = leitor.nextDouble();
                        acoes.atualizarP2(id, p2);
                    } else {
                        System.out.println("Insira uma opção válida!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

    }
}