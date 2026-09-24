public class Fibonacci {
    public static void main(String[] args) {
        int n = 30;
        long primeiro = 1;
        long segundo = 1;
        System.out.println("Os " + n + " primeiros elementos da série de Fibonacci:");
        System.out.print(primeiro + ", " + segundo);
        for (int i = 3; i <= n; i++) {
            long proximo = primeiro + segundo;
            System.out.print(", " + proximo);
            primeiro = segundo;
            segundo = proximo;
        }

        System.out.println();
    }
}