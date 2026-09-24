public class ValidarBooleans {
    public static void main(String[] args) {
        boolean var1 = true;
        boolean var2 = false;
        boolean var3 = true;
        System.out.println("A variável 1 é: " + (var1 ? "VERDADEIRA" : "FALSA"));
        System.out.println("A variável 2 é: " + (var2 ? "VERDADEIRA" : "FALSA"));
        System.out.println("A variável 3 é: " + (var3 ? "VERDADEIRA" : "FALSA"));
        
        if (var1 && var2 && var3) {
            System.out.println("Resultado do conjunto: Todas as variáveis são VERDADEIRAS.");
        } else {
            System.out.println("Resultado do conjunto: Pelo menos uma das variáveis é FALSA.");
        }
    }
} 