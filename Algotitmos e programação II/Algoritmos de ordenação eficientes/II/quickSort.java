import java.util.Arrays;

public class quickSort {
    
    public static void sort (int[] x, int inicio, int fim) {

        if (inicio < fim) {

            int pivot = divide(x, inicio, fim);

            sort(x, inicio, pivot - 1);
            sort(x, pivot + 1, fim);

        }

    }

    public static int divide (int[] x, int inicio, int fim) {

        int pivot = x[inicio];
        int postPivot = inicio;

        for (int i = inicio + 1; i <= fim; i++) {

            if (x[i] < pivot) {

                x[postPivot] = x[i];
                x[i] = x[postPivot + 1];

                postPivot++;

            }

        }

        x[postPivot] = pivot;

        return postPivot;

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
