public class fibonacci {
    
    public static int iterativo(int n) {

        int f = -1;
        int fibMenos1 = 1;
        int fibMenos2 = 0;

        System.out.println("Fibonacci (iterativo): " + fibMenos2);
        System.out.println("Fibonacci (iterativo): " + fibMenos1);

        for (int i = 3; i <= n; i++) {

            f = fibMenos1 + fibMenos2;

            System.out.println("Fibonacci (iterativo): " + f);

            fibMenos2 = fibMenos1;
            fibMenos1 = f;

        }

        return f;

    }

    public static int recursivoBinario(int n) {

        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;

        return recursivoBinario(n - 2) + recursivoBinario(n - 1);

    }

    public static int recursivoLinear(int n, int a, int b) {

        if (n == 0) return a;
        if (n == 1) return b;

        return recursivoLinear(n - 1, b, a + b);

    }

    public static void main(String[] args) {

        System.out.println("Fibonacci (iterativo): " + iterativo(13));
        System.out.println("Fibonacci (recursivo binário): " + recursivoBinario(13));
        System.out.println("Fibonacci (recursivo linear): " + recursivoLinear(13, 1, 0));

    }

}
