public class comparacaoIterativoOuRecursivo {

    public static int iterativo(int n) {

        int resultado = 1;

        for (int i = resultado; i <= n; i++) {

            resultado *= i;

        }

        return resultado;

    }

    public static int recursivo(int n) {

        if (n == 0) return 1;

        return n * recursivo(n - 1);

    }

    public static void main (String[] args) {

        System.out.println("O resultado fatorial pelo método iteratio é: " + iterativo(10));
        System.out.println("O resultado fatorial pelo método recursivo é: " + recursivo(10));

    }

}