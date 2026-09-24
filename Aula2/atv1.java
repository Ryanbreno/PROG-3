class Carro {
    String marca;
    String modelo;
    int ano;
    public void exibirInfo() {
        System.out.println("Detalhes do Veículo:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("-------------------------");
    }
}
public class TestaCarro {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        carro1.marca = "Honda";
        carro1.modelo = "Civic G9 2.0 LXR";
        carro1.ano = 2015;
        Carro carro2 = new Carro();
        carro2.marca = "Jeep";
        carro2.modelo = "Compass 2.0 Diesel";
        carro2.ano = 2022;
        carro1.exibirInfo();
        carro2.exibirInfo();
    }
}