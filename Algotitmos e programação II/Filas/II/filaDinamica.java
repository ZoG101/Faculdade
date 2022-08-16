import java.util.ArrayList;
import java.util.List;

public class filaDinamica {

    private final List dados = new ArrayList();

    public int primeiro () {

        return (int) this.dados.get(0);

    }

    public boolean ehVazia () {

        return this.dados.isEmpty();

    }

    public int tamanho () {

        return this.dados.size();

    }

    public void enfileira (int numero) {

        this.dados.add(numero);

    }

    public int desenfileira () {

        if (this.ehVazia()) {

            throw new RuntimeException("A fila está vazia");

        }

        return (int) this.dados.remove(0);

    }

    @Override
    public String toString () {

        return this.dados.toString();

    }

    public static void main (String[] args) {

        filaDinamica fila = new filaDinamica();
        filaDinamica filaPrioritaria = new filaDinamica();

        fila.enfileira(101);
        fila.enfileira(102);
        fila.enfileira(103);
        fila.enfileira(104);
        fila.enfileira(105);

        filaPrioritaria.enfileira(201);
        filaPrioritaria.enfileira(202);
        filaPrioritaria.enfileira(203);
        filaPrioritaria.enfileira(204);
        filaPrioritaria.enfileira(205);

        int cont = 1;

        while (!fila.ehVazia() || !filaPrioritaria.ehVazia()) {

            if (cont <= 2 && !filaPrioritaria.ehVazia()) {

                System.out.println(filaPrioritaria.desenfileira());

                cont++;

            } else {

                System.out.println(fila.desenfileira());

                cont = 1;

            }

        }

    }
    
}
