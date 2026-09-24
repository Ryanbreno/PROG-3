import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o início do intervalo: ");
        int inicio = scanner.nextInt();

        System.out.print("Digite o fim do intervalo: ");
        int fim = scanner.nextInt();
        System.out.println("\nNúmeros primos no intervalo de " + inicio + " até " + fim + ":");
        int menor = Math.min(inicio, fim);
        int maior = Math.max(inicio, fim);
        boolean encontrouPrimo = false;
        for (int i = menor; i <= maior; i++) {
            if (ehPrimo(i)) {
                System.out.print(i + " ");
                encontrouPrimo = true;
            }
        }
        if (!encontrouPrimo) {
            System.out.print("Nenhum número primo foi encontrado nesse intervalo.");
        }
        System.out.println();
        scanner.close();
    }
    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}