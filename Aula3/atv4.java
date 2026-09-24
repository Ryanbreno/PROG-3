public class Animal {
    public void emitirSom() {
        System.out.println("Som genérico de animal");
    }
    public static void main(String[] args) {
        Animal[] bichos = new Animal[2];
        bichos[0] = new Cachorro();
        bichos[1] = new Gato();

        for (Animal pet : bichos) {
            pet.emitirSom();
        }
    }
}
class Cachorro extends Animal {

    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }
}

class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }
}