public class Contador {
    static int totalObjetos = 0;
    public Contador() {
        totalObjetos++;
    }
    public static void mostrarTotal() {
        System.out.println("Total de instâncias criadas: " + totalObjetos);
    }
    public static void main(String[] args) {
        System.out.println("Iniciando o programa...");
        Contador.mostrarTotal();
        Contador obj1 = new Contador();
        Contador obj2 = new Contador();
        Contador obj3 = new Contador();
        Contador obj4 = new Contador();
        Contador.mostrarTotal();
    }
}