package gen;

public class Generico {

    public static <T> void exibe (T[] elementos) {

        System.out.print("[");

        for (T element : elementos) {

            System.out.printf("%s, ", element);

        }

        System.out.println("]");
        System.out.println();

    }

    public static <T extends Comparable<T>> T maior (T... valores) {

        T maior = null;

        for (T valor : valores) {

            if (maior == null || valor.compareTo(maior) > 0) {

                maior = valor;

            }

        }

        return maior;

    }
    
}
