import java.util.Scanner;

public class calc {

    static Scanner entrada = new Scanner(System.in);

    public static double dobro (double n) {

        double dobro = n * 2;

        return dobro;

    }

    public static void main(String[] args) {

        System.out.println("Programa do dobro");
        System.out.println("Informe um número");

        double n = entrada.nextDouble();
        double calc = dobro(n);

        System.out.println("O dobro é: " + calc);

    }

}
