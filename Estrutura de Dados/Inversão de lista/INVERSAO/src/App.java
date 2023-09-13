import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x[] = new int[n];
        int v[] = new int[n];

        for (int i = 0; i < n; i++) {

            v[i] = scan.nextInt();

        }

        for (int i = 0; i < n; i++) {

            x[i] = v[n-1-i];

        }

        System.out.println(Arrays.toString(v));

        for (int i = 0; i < n/2; i++) {

            int temp = v[i];

            v[i] = v[n-1-i];

            v[n-1-i] = temp;

        }

        scan.close();

        System.out.println(Arrays.toString(v));

    }

}
