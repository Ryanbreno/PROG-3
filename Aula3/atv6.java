public class ContaBancaria {
    private String numero;
    public ContaBancaria(String numero) {
        this.numero = numero;
    }
    public String getNumero() {
        return numero;
    }
    @Override
    public String toString() {
        return "Conta Bancária Nº: " + numero;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ContaBancaria outra = (ContaBancaria) obj;
        return numero != null ? numero.equals(outra.numero) : outra.numero == null;
    }

    public static void main(String[] args) {
        ContaBancaria contaUm = new ContaBancaria("12345-X");
        ContaBancaria contaDois = new ContaBancaria("12345-X");
        System.out.println("Teste do toString():");
        System.out.println(contaUm);
        System.out.println("\nTeste do equals():");
        boolean saoIguais = contaUm.equals(contaDois);
        System.out.println("As contas são iguais? " + (saoIguais ? "Sim" : "Não"));
    }
}