import gen.Generico;
import gen.PilhaGenerica;

public class App {

    public static void main(String[] args) {

        Integer[] inteiros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Double[] reais = {1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5};
        Character[] letras = {'A', 'N', 'D', 'R', 'E', 'Y'};
    
        System.out.println("Exibição do vetor de inteiros:");
        Generico.<Integer>exibe(inteiros);
        System.out.println("Exibição do vetor de reais:");
        Generico.<Double>exibe(reais);
        System.out.println("Exibição do vetor de letras:");
        Generico.<Character>exibe(letras);

        System.out.printf("Maior inteiro: %s\n", Generico.maior(10, 5, 20));
        System.out.printf("Maior real: %s\n", Generico.maior(10.5, 5.1, 20.5, 15.0, 20.6));
        System.out.printf("Maior letra: %s\n", Generico.maior('A', 'B', 'D', 'C'));

        PilhaGenerica<Integer> numeros = new PilhaGenerica<Integer>();
        numeros.empilha(1);
        System.out.println(numeros.desempilha());

        PilhaGenerica<String> nomes = new PilhaGenerica<String>();
        nomes.empilha("Andrey");
        System.out.println(nomes.desempilha());

    }

}
