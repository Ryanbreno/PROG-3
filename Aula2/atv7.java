import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CadastroPessoa {
    public static boolean validarNome(String nome) {
        if (nome == null) {
            return false;
        }
        String textoLimpo = nome.trim();
        return !textoLimpo.isEmpty() && textoLimpo.length() >= 3;
    }

    public static boolean buscarUsuario(List<String> registros, String termoBusca) {
        Iterator<String> leitor = registros.iterator();
        while (leitor.hasNext()) {
            String pessoa = leitor.next();
            if (pessoa.equalsIgnoreCase(termoBusca)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> usuarios = new ArrayList<>();
        String[] candidatos = {"Ryan", "Gustavo", "Matheus", "Paulo"};
        for (String nome : candidatos) {
            if (validarNome(nome)) {
                usuarios.add(nome);
            }
        }
        String procura = "gustavo";
        boolean achou = buscarUsuario(usuarios, procura);
        System.out.println("Usuários cadastrados: " + usuarios);
        System.out.println("Busca por '" + procura + "': " + (achou ? "Encontrado" : "Não encontrado"));
    }
}