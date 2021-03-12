
//type "main" and then ctrl + space (shortcut for function main)

import java.util.*;
import java.util.function.Consumer;

import static java.util.Comparator.comparing;

public class OrdenaStrings {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<String>();
        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

//        Comparator<String> comparador = new ComparadorPorTamanho();
//        Collections.sort(palavras, comparador);

//        palavras.sort(comparador); // JAVA 8
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length())); // JAVA 8

        palavras.sort((s1, s2) -> s1.length() - s2.length());

//        String s = "andre luna";
        palavras.sort(comparing(s -> s.length()));


//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("Executando um Runnable");
//            }
//
//        }).start();

        new Thread(() -> System.out.println("Executando um Runnable")).start();

        System.out.println(palavras);

        palavras.sort((s1, s2) -> {
           return Integer.compare(s1.length(), s2.length());
        });

        palavras.sort(comparing(s -> s.length()));
        palavras.sort(comparing(String::length));
        palavras.sort(comparing(s -> s.startsWith("a")));

        palavras.sort(String.CASE_INSENSITIVE_ORDER);
        palavras.forEach(System.out::println);

//        for (String p: palavras) {
//            System.out.println(p);
//        }

//        Consumer<String> consumidor = new ImprimeNaLinha();

//        Consumer<String> consumidor = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

//        palavras.forEach((String s) -> {   // JAVA 8 LAMBDA
//            System.out.println(s);
//        });

        palavras.forEach(s -> System.out.println(s)); // JAVA 8 LAMBDA
    }
}

class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

//class ComparadorPorTamanho implements Comparator<String> {
//
//    @Override
//    public int compare(String s1, String s2) {
//        if (s1.length() < s2.length())
//            return -1;
//        if (s1.length() > s2.length())
//            return 1;
//        return 0;
//    }
//}