import java.util.Scanner;

public class AnalisadorTexto {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite uma frase:");
        String textoBruto = entrada.nextLine();

        String textoLimpo = textoBruto.trim();
        int totalCaracteres = textoLimpo.length();
        String textoMaiusculo = textoLimpo.toUpperCase();
        String textoAlterado = textoLimpo.replace("Java", "Linguagem Java");
        char caractereNaPosicao = textoLimpo.charAt(5);
        System.out.println("\nFrase tratada: " + textoLimpo);
        System.out.println("Total de caracteres: " + totalCaracteres);
        System.out.println("Em maiúsculas: " + textoMaiusculo);
        System.out.println("Texto alterado: " + textoAlterado);
        System.out.println("Caractere no índice 5: " + caractereNaPosicao);

        entrada.close();
    }
}