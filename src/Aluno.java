public class Aluno {
    private String nome;
    private double p1;
    private double p2;

    public Aluno(String nome, double p1, double p2) {
        if(p1 < 0 || p1 > 10){
            throw new IllegalArgumentException("Erro ao adicionar aluno. \nNota deve ser um número de 0 a 10!");
        }
        if(p2 < 0 || p2 > 10){
            throw new IllegalArgumentException("Erro ao adicionar aluno. \nNota deve ser um número de 0 a 10!");
        }
        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2; 
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getP1() {
        return p1;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getP2() {
        return p2;
    }

    public double getMedia() {
        return (p1 + 2 * p2) / 3;
    }

    public void imprimeAluno() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Nota P1: " + this.p1);
        System.out.println("Nota P2: " + this.p2);
        System.out.printf("%s%.2f%n", "Média: ", getMedia());
        System.out.println("Status: " + alunoStatus());
        System.out.println("----------------");
    }

    public String alunoStatus() {
        if (getMedia() >= 6) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

}
