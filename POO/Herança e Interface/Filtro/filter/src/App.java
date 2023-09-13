import java.util.List;

import models.Filtro;

public class App {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Filtro<Integer> filtro = new Filtro<Integer>();

        List<Integer> pares = filtro.filtra(numeros, (valor) -> {

            return 0 == valor % 2;

        });

        List<Integer> impares = filtro.filtra(numeros, (valor) -> {

            return 1 == valor % 2;

        });

        List<String> nomes = List.of("Andrey", "Ana", "Joao", "Kathia", "Anabele", "Barbara", "Gerliane");
        Filtro<String> filtroNomes = new Filtro<String>();
        List<String> nomesComA = filtroNomes.filtra(nomes, nome -> nome.toUpperCase().startsWith("A"));

        System.out.printf("Números pares:%22s\n", pares);
        System.out.printf("Números ímpares:%20s\n", impares);
        System.out.printf("Nomes com A:%24s\n", nomesComA);

    }

}
