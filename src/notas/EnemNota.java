package notas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnemNota {

    public static int calcularNota(List<String> respostasAluno, List<String> gabarito) {
        int nota = 0;
        for (int i = 0; i < respostasAluno.size(); i++) {
            if (respostasAluno.get(i).equals(gabarito.get(i))) {
                nota++;
            }
        }
        return nota;
    }

    public static void main(String[] args) {
        List<List<String>> respostas = new ArrayList<>();
        List<String> gabarito = List.of("B", "C", "D", "C", "D", "A", "C", "A", "A", "E");

        respostas.add(List.of("BOB", "B", "E", "B", "E", "D", "B", "A", "A", "A", "E"));
        respostas.add(List.of("RODRIGO", "B", "E", "D", "A", "D", "A", "C", "A", "B", "D"));
        respostas.add(List.of("PEDRO", "B", "C", "D", "C", "D", "A", "C", "A", "C", "E"));
        respostas.add(List.of("GABRIELA", "B", "C", "A", "C", "D", "A", "D", "A", "A", "B"));
        respostas.add(List.of("LAURA", "B", "E", "B", "C", "B", "A", "C", "A", "A", "E"));
        respostas.add(List.of("CARLOS", "B", "B", "D", "A", "D", "D", "C", "A", "C", "B"));
        respostas.add(List.of("FLAVIO", "B", "C", "D", "C", "B", "A", "C", "B", "A", "E"));
        respostas.add(List.of("CLARA", "A", "C", "E", "D", "D", "B", "A", "A", "A", "A"));
        respostas.add(List.of("EDUARDA", "B", "C", "D", "C", "D", "A", "C", "A", "A", "E"));
        respostas.add(List.of("MARIA", "B", "D", "A", "C", "B", "C", "C", "A", "A", "E"));

        List<Result> resultados = new ArrayList<>();
        
        for (List<String> aluno : respostas) {
            String nome = aluno.get(0);
            List<String> respostasAluno = aluno.subList(1, aluno.size());
            int nota = calcularNota(respostasAluno, gabarito);
            resultados.add(new Result(nome, respostasAluno, nota));
        }

        Collections.sort(resultados, Comparator.comparingInt(Result::getNota).reversed());

        for (int i = 0; i < resultados.size(); i++) {
            Result result = resultados.get(i);
            System.out.println((i + 1) + "º colocado: " + result.getNome());
            System.out.println("Matriz de acertos: " + result.getRespostas());
            System.out.println("Nota final: " + result.getNota());
            System.out.println();
        }
    }

    static class Result {
        private final String nome;
        private final List<String> respostas;
        private final int nota;

        public Result(String nome, List<String> respostas, int nota) {
            this.nome = nome;
            this.respostas = respostas;
            this.nota = nota;
        }

        public String getNome() {
            return nome;
        }

        public List<String> getRespostas() {
            return respostas;
        }

        public int getNota() {
            return nota;
        }
    }
}
