package models;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro<T> {

    public List<T> filtra (List<T> numeros, Predicado<T> predicado) {

        return numeros.stream()
        .filter(numero -> predicado.teste(numero))
        .collect(Collectors.toList());

    }
    
}
