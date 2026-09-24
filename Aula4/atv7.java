import java.util.Arrays;

enum NivelAtleta {
    NOVATO,
    AMADOR,
    PROFISSIONAL
}

interface Corredor {
    void correr();
}

interface Nadador {
    void nadar();
}

interface Ciclista {
    void pedalar();
}

abstract class Atleta {

    private String nome;
    private int idade;
    private NivelAtleta nivel;

    public Atleta(String nome, int idade, NivelAtleta nivel) {
        setNome(nome);
        setIdade(idade);
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
        this.idade = idade;
    }

    public NivelAtleta getNivel() {
        return nivel;
    }

    public void setNivel(NivelAtleta nivel) {
        this.nivel = nivel;
    }

    public abstract void exibirModalidades();

    public void exibirInformacoes() {
        System.out.println("Atleta: " + nome + " | Idade: " + idade + " | Nível: " + nivel);
    }
}

class CorredorProfissional extends Atleta implements Corredor {

    public CorredorProfissional(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " está correndo em ritmo de maratona.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidade principal: Corrida");
    }
}

class NadadorProfissional extends Atleta implements Nadador {

    public NadadorProfissional(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando estilo livre na piscina.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidade principal: Natação");
    }
}

class Triatleta extends Atleta implements Corredor, Nadador, Ciclista {

    public Triatleta(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " está correndo o trecho final do triatlo.");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando o primeiro trecho em águas abertas.");
    }

    @Override
    public void pedalar() {
        System.out.println(getNome() + " está pedalando no percurso de ciclismo.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidades: Natação, Ciclismo e Corrida (Triatlo)");
    }
}

public class Principal {

    public static void main(String[] args) {
        Atleta[] atletas = new Atleta[4];

        try {
            atletas[0] = new CorredorProfissional("Ryan", 22, NivelAtleta.PROFISSIONAL);
            atletas[1] = new NadadorProfissional("Gustavo", 19, NivelAtleta.AMADOR);
            atletas[2] = new Triatleta("Matheus", 25, NivelAtleta.PROFISSIONAL);
            atletas[3] = new Triatleta("Vitor", 18, NivelAtleta.NOVATO);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar atleta: " + e.getMessage());
        }

        System.out.println("=== APRESENTAÇÃO DE TODOS OS ATLETAS ===");
        for (Atleta atleta : atletas) {
            if (atleta != null) {
                atleta.exibirInformacoes();
                atleta.exibirModalidades();
                System.out.println("-----------------------------------");
            }
        }

        System.out.println("\n=== EXECUÇÃO DE MODALIDADES (INTERFACES) ===");
        
        System.out.println("\n-> Executando atletas através da interface Corredor:");
        for (Atleta atleta : atletas) {
            if (atleta instanceof Corredor) {
                Corredor corredor = (Corredor) atleta;
                corredor.correr();
            }
        }

        System.out.println("\n-> Executando atletas através da interface Nadador:");
        for (Atleta atleta : atletas) {
            if (atleta instanceof Nadador) {
                Nadador nadador = (Nadador) atleta;
                nadador.nadar();
            }
        }

        System.out.println("\n-> Executando atletas através da interface Ciclista:");
        for (Atleta atleta : atletas) {
            if (atleta instanceof Ciclista) {
                Ciclista ciclista = (Ciclista) atleta;
                ciclista.pedalar();
            }
        }

        System.out.println("\n=== DEMONSTRAÇÃO DE MÚLTIPLAS INTERFACES NA MESMA CLASSE ===");
        Atleta triatletaExemplo = atletas[2];
        if (triatletaExemplo instanceof Triatleta) {
            Triatleta tri = (Triatleta) triatletaExemplo;
            System.out.println("O atleta " + tri.getNome() + " é uma única instância que executa todas as modalidades:");
            tri.nadar();
            tri.pedalar();
            tri.correr();
        }

        System.out.println("\n=== TESTES DE VALIDAÇÃO (EXCEÇÕES) ===");
        
        try {
            System.out.println("Tentando criar atleta com idade negativa:");
            Atleta invalido1 = new CorredorProfissional("Paulo", -5, NivelAtleta.AMADOR);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        try {
            System.out.println("Tentando criar atleta com nome vazio:");
            Atleta invalido2 = new NadadorProfissional("   ", 20, NivelAtleta.NOVATO);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}