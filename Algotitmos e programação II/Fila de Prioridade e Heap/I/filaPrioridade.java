import java.util.Arrays;

class App {

    public static void main(String[] args) {
    
        filaPrioridade f = new filaPrioridade(6);

        try {

            f.enfileira(new Item<>("roxo", 5));
            f.enfileira(new Item<>("roxo", 1));
            f.enfileira(new Item<>("roxo", 0));
            f.enfileira(new Item<>("roxo", 4));
            f.enfileira(new Item<>("roxo", 1));
            f.enfileira(new Item<>("roxo", 3));
            f.enfileira(new Item<>("roxo", 2));

        } catch (RuntimeException e) {

            System.err.println(e.getMessage());

        }

        System.out.printf("%s\n\n", f.toString());

        try {

            while (!f.ehVazia()) {

                System.out.println(f.desenfileira());

            }

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

    }

}

class Item<T> {

    private T valor;
    private int prioridade;

    public Item (T valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
    }

    public T getValor () {

        return valor;

    }

    public int getPrioridade () {

        return prioridade;

    }

    @Override
    public String toString () {

        return String.format("(%d - %s)", this.prioridade, this.valor.toString());

    }

}

public class filaPrioridade {

    private Item<?>[] itens;
    private int tamanho;
    private int capacidade;

    public filaPrioridade (int capacidade) {

        this.tamanho = 0;
        this.capacidade = capacidade;
        this.itens = new Item[this.capacidade];

    }

    public filaPrioridade () {

        this(10);

    }

    public boolean ehVazia () {

        return this.tamanho == 0;

    }

    public int tamanho () {

        return this.tamanho;

    }

    public void enfileira (Item<?> i) {

        if (this.capacidade == this.tamanho) {

            throw new RuntimeException("A fila está cheia.");

        }

        this.itens[this.tamanho++] = i;

    }

    public Item<?> desenfileira () {

        if (this.ehVazia()) {

            throw new RuntimeException("A fila está vazia.");

        }

        int indice = this.buscaMaiorPrioridade();
        Item<?> altaPrioridade = this.itens[indice];

        for (int i = indice; i < this.tamanho() - 1; i++) {

            this.itens[i] = this.itens [i + 1];

        }

        this.tamanho--;

        return altaPrioridade;

    }

    private int buscaMaiorPrioridade () {

        int p = 0;

        for (int i = 0; i < this.tamanho(); i++) {

            if (this.itens[p].getPrioridade() > this.itens[i].getPrioridade()) {

                p = i;

            }

        }

        return p;

    }

    @Override
    public String toString () {

        return Arrays.toString(this.itens);

    }
    
}
