package gen;

import java.util.ArrayList;
import java.util.List;

public class PilhaGenerica<E> {

    private List<E> elementos = new ArrayList<E>();

    public void empilha (E elemento) {

        elementos.add(elemento);

    }

    public E desempilha () {

        if (elementos.isEmpty()) throw new IllegalStateException("ERROR: A pilha está vazia!");

        return elementos.remove(elementos.size() - 1);

    }
    
}
