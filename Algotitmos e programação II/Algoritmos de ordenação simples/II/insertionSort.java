import java.util.Arrays;

public class insertionSort {

    public static void insertion (int[] v) { 

        for (int i = 1; i < v.length; i++) {

            int x = v[i]; 

            for (int j = i - 1; j >= 0 && v[j] > x; j--) {

                v[j + 1] = v[j];
                v[j] = x;

            }

        }

    }

    public static void main(String[] args) {

        int [] a = {36, 15, 75, 2, 16, 48, 42, 51};
        int [] b = {13, 45, 38, 20, 23, 7, 6, 5, 10, 11};
        int [] c = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        insertion(a);
        insertion(b);
        insertion(c);

        System.out.printf ("resultado a: -> %s \n", Arrays.toString(a));
        System.out.printf ("resultado b: -> %s \n", Arrays.toString(b));
        System.out.printf ("resultado c: -> %s \n", Arrays.toString(c));

    }
    
}
