public class Aluno {
    private String nome;
    private double p1;
    private double p2;

    public Aluno(String nome, double p1, double p2) {
        this.nome = nome;
        setP1(p1);
        setP2(p2);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean setP1(double p1) {
        if (p1 > 10 || p1 < 0) {
            System.out.println("Nota inválida! A nota deve ser um número de 0 a 10!");
            return false;
        } else {
            this.p1 = p1;
            return true;
        }

    }

    public double getP1() {
        return p1;
    }

    public boolean setP2(double p2) {
        if (p2 > 10 || p2 < 0) {
            System.out.println("Nota inválida! A nota deve ser um número de 0 a 10!");
            return false;
        } else {
            this.p2 = p2;
            return true;
        }

    }

    public double getP2() {
        return p2;
    }

    public void imprimeAluno() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Nota P1: " + this.p1);
        System.out.println("Nota P2: " + this.p2);
        System.out.printf("%s%.2f%n", "Média: ", calculoMedia());
        System.out.println("Status: " + alunoStatus());
        System.out.println("----------------");
    }

    public double calculoMedia() {
        return (p1 + 2 * p2) / 3;
    }

    public String alunoStatus() {
        if (calculoMedia() >= 6) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

}
