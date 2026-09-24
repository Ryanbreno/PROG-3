public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}

class Aluno extends Pessoa {
    private String matricula;
    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public static void main(String[] args) {
        Aluno estudante = new Aluno("Ryan", 20, "202401928");
        System.out.println("--- Dados Iniciais ---");
        System.out.println("Nome: " + estudante.getNome());
        System.out.println("Idade: " + estudante.getIdade());
        System.out.println("Matrícula: " + estudante.getMatricula());
        estudante.setNome("Vitor");
        estudante.setIdade(22);
        estudante.setMatricula("202409999");

        System.out.println("\n--- Dados Alterados ---");
        System.out.println("Nome: " + estudante.getNome());
        System.out.println("Idade: " + estudante.getIdade());
        System.out.println("Matrícula: " + estudante.getMatricula());
    }
}