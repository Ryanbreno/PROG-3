class Produto {
    private String nome;
    private double preco;
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Preço: R$ " + String.format("%.2f", preco);
    }
}

class LivroMedia extends Produto {

    private String autor;

    public LivroMedia(String nome, double preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
    @Override
    public String toString() {
        return super.toString() + " | Autor: " + autor;
    }
}

class Cd extends Produto {
    private int numeroFaixas;
    public Cd(String nome, double preco, int numeroFaixas) {
        super(nome, preco);
        this.numeroFaixas = numeroFaixas;
    }

    public int getNumeroFaixas() {
        return numeroFaixas;
    }
    @Override
    public String toString() {
        return super.toString() + " | Faixas: " + numeroFaixas;
    }
}

class Dvd extends Produto {

    private int duracao;

    public Dvd(String nome, double preco, int duracao) {
        super(nome, preco);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Duração: " + duracao + " min";
    }
}

class Conta {

    private int numero;
    private String nomeTitular;
    protected double saldo;

    public Conta(int numero, String nomeTitular) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.saldo = 0.0;
    }

    public Conta(int numero, String nomeTitular, double saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public void imprimirTipoConta() {
        System.out.println("Conta Comum");
    }
}

class ContaEspecial extends Conta {
    private double limite;
    public ContaEspecial(int numero, String nomeTitular, double limite) {
        super(numero, nomeTitular);
        this.limite = limite;
    }
    public ContaEspecial(int numero, String nomeTitular, double saldo, double limite) {
        super(numero, nomeTitular, saldo);
        this.limite = limite;
    }
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= this.limite + this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
    @Override
    public void imprimirTipoConta() {
        System.out.println("Conta Especial");
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, String nomeTitular) {
        super(numero, nomeTitular);
    }
    public ContaPoupanca(int numero, String nomeTitular, double saldo) {
        super(numero, nomeTitular, saldo);
    }
    public void reajustar(double percentual) {
        double saldoAtual = this.getSaldo();
        double reajuste = saldoAtual * percentual;
        this.depositar(reajuste);
    }
    @Override
    public void imprimirTipoConta() {
        System.out.println("Conta Poupança");
    }
}

public class Principal {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA LOJA DE MÍDIAS ===");
        Produto[] estoque = new Produto[5];
        estoque[0] = new LivroMedia("Java Básico", 89.90, "Ryan");
        estoque[1] = new Cd("Rock Nacional", 29.90, 12);
        estoque[2] = new Dvd("Filme de Ação", 45.00, 120);
        estoque[3] = new LivroMedia("Estrutura de Dados", 110.00, "Gustavo");
        estoque[4] = new Cd("Ao Vivo na Cidade", 35.50, 15);

        for (Produto item : estoque) {
            System.out.println(item);
        }

        System.out.println("\n=== TESTE DO SISTEMA BANCÁRIO ===");
        Conta contaComum = new Conta(101, "Matheus", 500.00);
        ContaEspecial contaEspecial = new ContaEspecial(102, "Paulo", 1000.00, 500.00);
        ContaPoupanca contaPoupanca = new ContaPoupanca(103, "Vitor", 2000.00);
        contaComum.imprimirTipoConta();
        contaEspecial.imprimirTipoConta();
        contaPoupanca.imprimirTipoConta();

        contaPoupanca.reajustar(0.05);
        System.out.println("Saldo da poupança após reajuste: R$ " + contaPoupanca.getSaldo());
    }
}