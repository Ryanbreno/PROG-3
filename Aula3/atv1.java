public class Livro {
    String titulo;
    String autor;
    
    public Livro() {
        this.titulo = "Sem Título";
        this.autor = "Autor Desconhecido";
    }
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    public void exibirDados() {
        System.out.println("Título: " + titulo + " | Autor: " + autor);
    }
    public static void main(String[] args) {
        Livro obraPadrao = new Livro();
        Livro obraCadastrada = new Livro("Estruturas de Dados", "Ryan");
        obraPadrao.exibirDados();
        obraCadastrada.exibirDados();
    }
}