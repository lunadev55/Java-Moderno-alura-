import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {
    private String nome;
    private int alunos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();

        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("Javascript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 45));

        cursos.sort(Comparator.comparing(Curso::getAlunos));
//        cursos.forEach(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .forEach(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .map(c -> c.getAlunos())
                .forEach(total -> System.out.println(total));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .forEach(System.out::println);

        Stream<String> nomes = cursos.stream()
                .map(c -> c.getNome());

        Stream<String> nomes2 = cursos.stream().map(Curso::getNome);

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .map(Curso::getAlunos)
                .forEach(System.out::println);

        Optional<Curso> optionalCurso = cursos
                .stream()
                .filter(c -> c.getAlunos() >= 1000)
                .findAny();

        optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

        // user of collectors to pass the result into a List
        List<Curso> resultado = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());

        // returns {Javascript=150, Java 8=113}
        Map<String, Integer> result = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()
                ));

        cursos.stream().mapToInt(c -> c.getAlunos()).average(); // returns average of stream list of cursos (numeroAlunos)

        List<Curso> streamList = cursos
                .stream()
                .filter(c -> c.getAlunos() > 50)
                .collect(Collectors.toList());

        // research for "parallelStream"

        System.out.println(result);

    }
}
