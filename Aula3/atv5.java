public class Calculadora {
    public int somar(int primeiro, int segundo) {
        return primeiro + segundo;
    }

    public double somar(double valorUm, double valorDois) {
        return valorUm + valorDois;
    }
    public int somar(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int resultadoInteiros = calc.somar(10, 25);
        double resultadoDoubles = calc.somar(12.5, 7.3);
        int resultadoTresInteiros = calc.somar(5, 15, 30);
        System.out.println("Soma de 2 inteiros: " + resultadoInteiros);
        System.out.println("Soma de 2 doubles: " + resultadoDoubles);
        System.out.println("Soma de 3 inteiros: " + resultadoTresInteiros);
    }
}