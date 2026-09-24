import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CadastroAlunos {
    public static void main(String[] args) {
        List<String> turma = new ArrayList<>();
        turma.add("Ryan");
        turma.add("Gustavo");
        turma.add("Matheus");
        turma.add("Paulo");
        turma.add("Vitor");
        System.out.println("--- Chamada do dia ---");
        Iterator<String> ponteiro = turma.iterator();
        while (ponteiro.hasNext()) {
            String alunoAtual = ponteiro.next();
            System.out.println("Aluno: " + alunoAtual);
        }
        System.out.println("\nRemovendo o Matheus da turma...");
        Iterator<String> busca = turma.iterator();
        while (busca.hasNext()) {
            String nome = busca.next();
            if (nome.equals("Matheus")) {
                busca.remove();
                break;
            }
        }
        System.out.println("\n--- Lista atualizada ---");
        Iterator<String> leitor = turma.iterator();
        while (leitor.hasNext()) {
            System.out.println("Aluno: " + leitor.next());
        }
    }
}