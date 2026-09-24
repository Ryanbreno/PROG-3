abstract class ContaBancaria {
    private String titular;
    protected double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}

class ContaCorrente extends ContaBancaria {

    private double taxaSaque = 1.00;

    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor + taxaSaque;
        if (valorTotal <= saldo) {
            saldo -= valorTotal;
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }
    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        ContaCorrente corrente = new ContaCorrente("Ryan", 100.00);
        ContaPoupanca poupanca = new ContaPoupanca("Gustavo", 100.00);

        System.out.println("=== DEPÓSITOS INICIAIS ===");
        corrente.depositar(50.00);
        poupanca.depositar(50.00);
        System.out.println("Saldo Conta Corrente (" + corrente.getTitular() + "): R$ " + corrente.getSaldo());
        System.out.println("Saldo Conta Poupança (" + poupanca.getTitular() + "): R$ " + poupanca.getSaldo());
        System.out.println("\n=== SAQUES VÁLIDOS ===");
        if (corrente.sacar(40.00)) {
            System.out.println("Saque de R$ 40,00 realizado na Conta Corrente (Taxa de R$ 1,00 aplicada).");
        }
        if (poupanca.sacar(40.00)) {
            System.out.println("Saque de R$ 40,00 realizado na Conta Poupança.");
        }
        System.out.println("\n=== TESTANDO SAQUE INVÁLIDO (SALDO INSUFICIENTE) ===");
        double valorSaqueInvalido = 200.00;
        System.out.println("Tentando sacar R$ " + valorSaqueInvalido + " na Conta Corrente...");
        if (!corrente.sacar(valorSaqueInvalido)) {
            System.out.println("Operação cancelada: Saldo insuficiente!");
        }
        System.out.println("Tentando sacar R$ " + valorSaqueInvalido + " na Conta Poupança...");
        if (!poupanca.sacar(valorSaqueInvalido)) {
            System.out.println("Operação cancelada: Saldo insuficiente!");
        }
        System.out.println("\n=== SALDOS FINAIS ===");
        System.out.println("Saldo Final Conta Corrente (" + corrente.getTitular() + "): R$ " + corrente.getSaldo());
        System.out.println("Saldo Final Conta Poupança (" + poupanca.getTitular() + "): R$ " + poupanca.getSaldo());
    }
}