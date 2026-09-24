public class Produto {

    int codigo;
    String descricao;
    double valor;

    public Produto(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }
    public void aplicarDesconto(double porcentagem) {
        double abatimento = this.valor * (porcentagem / 100);
        this.valor = this.valor - abatimento;
    }
    public void exibirDetalhes() {
        System.out.printf("ID: %d | Item: %s | Preço: R$ %.2f%n", codigo, descricao, valor);
    }
    public static void main(String[] args) {
        Produto itemUm = new Produto(101, "Teclado Mecânico", 250.00);
        Produto itemDois = new Produto(102, "Mouse Gamer", 120.00);
        itemUm.aplicarDesconto(10);
        itemDois.aplicarDesconto(15);
        System.out.println("--- Produtos com Desconto ---");
        itemUm.exibirDetalhes();
        itemDois.exibirDetalhes();
    }
}