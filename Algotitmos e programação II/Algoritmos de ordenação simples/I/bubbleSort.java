import java.util.Arrays;

public class bubbleSort {

    public static void bubble(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[i] > vetor[j]) {

                    int aux = vetor[i];

                    vetor[i] = vetor[j];
                    vetor[j] = aux;

                }

            }

        }

    }

    public static void main(String[] args) {

        int a [] = {36, 15, 75, 2, 16, 48, 51};
        int b [] = {13, 45, 38, 20, 23, 7, 6, 5, 10, 11};
        int c [] = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        bubble(a);
        bubble(b);
        bubble(c);

        System.out.printf ("resultado a: -> %s \n", Arrays.toString(a));
        System.out.printf ("resultado b: -> %s \n", Arrays.toString(b)); 
        System.out.printf ("resultado c: -> %s \n", Arrays.toString(c)); 

    }
    
}
