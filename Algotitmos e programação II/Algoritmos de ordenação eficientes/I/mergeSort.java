import java.util.Arrays;

public class mergeSort {
    
    public static void sort (int[] x, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            sort(x, inicio, meio);
            sort(x, meio + 1, fim);

            merge(x, inicio, meio, fim);

        }

    }

    private static void merge (int[] x, int inicio, int meio, int fim) {

        int i, esquerda, direita;
        int[] aux = new int[x.length];

        for (i = inicio; i <= fim; i++) aux[i] = x[i];

        esquerda = inicio;
        direita = meio + 1;
        i = inicio;

        while (esquerda <= meio && direita <= fim) {

            if (aux[esquerda] <= aux[direita]) x[i++] = aux[esquerda++];

            else x[i++] = aux[direita++];

        }

        while (esquerda <= meio) x[i++] = aux[esquerda++];

    }

    public static void main (String[] args) {

        int[] a = {36, 15, 75, 2, 16, 48, 42, 51};
        int[] b = {13, 45, 38, 20, 23, 7, 6, 5, 10, 11};
        int[] c = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort(a, 0, a.length - 1);
        sort(b, 0, b.length - 1);
        sort(c, 0, c.length - 1);

        System.out.printf("Ordenado: %s \n", Arrays.toString(a));
        System.out.printf("Ordenado: %s \n", Arrays.toString(b));
        System.out.printf("Ordenado: %s \n", Arrays.toString(c));

    }

}
