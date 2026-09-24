public class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
class Aluno extends Pessoa {
    String matricula;
    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Matrícula: " + matricula);
    }
    public static void main(String[] args) {
        Aluno estudante = new Aluno("Ryan", 20, "202401928");
        estudante.exibirInformacoes();
    }
}