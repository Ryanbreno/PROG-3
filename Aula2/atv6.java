import java.util.ArrayList;
import java.util.Iterator;

class ContaBancaria {
    int numero;
    String titular;
    double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }
}
public class GerenciamentoContas {
    public static void main(String[] args) {
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaBancaria(14502, "Ryan", 5400.00));
        contas.add(new ContaBancaria(21093, "Bruno", 8250.75));
        contas.add(new ContaBancaria(37418, "Junior", 3100.50));
        double saldoTotal = 0;
        Iterator<ContaBancaria> it = contas.iterator();
        while (it.hasNext()) {
            ContaBancaria conta = it.next();
            System.out.println("Conta: " + conta.numero + " | Titular: " + conta.titular);
            saldoTotal += conta.saldo;
        }
        System.out.printf("\nSaldo total acumulado: R$ %.2f\n", saldoTotal);
    }
}