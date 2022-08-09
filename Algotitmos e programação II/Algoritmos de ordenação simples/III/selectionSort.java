import java.util.Arrays;

public class selectionSort {

    public static void selection (int[] v) {

        for (int i = 0; i < v.length; i++) {

            int sindex = i;

            for (int j = i + 1; j < v.length; j++) {

                if (v[j] < v[sindex]) sindex = j;

            }

            trocar(v, i, sindex);  

        }

    }

    public static void trocar (int[] v, int a, int b) {

        int aux = v[a];

        v[a] = v[b];
        v[b] = aux;

    }

    public static void main (String[] args) {

        int [] a = {36, 15, 75, 2, 16, 48, 42, 51};
        int [] b = {13, 45, 38, 20, 23, 7, 6, 5, 10, 11};
        int [] c = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        selection(a);
        selection(b);
        selection(c);

        System.out.printf ("resultado a: -> %s \n", Arrays.toString(a));
        System.out.printf ("resultado b: -> %s \n", Arrays.toString(b));
        System.out.printf ("resultado c: -> %s \n", Arrays.toString(c));

    }
    
}
