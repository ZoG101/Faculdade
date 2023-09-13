import java.util.ArrayList;
import java.util.List;

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

public class filaPrioridadeHeap {
    
    private List<Item<?>> itens = new ArrayList<Item<?>>();

    public int tamanho () {

        return this.itens.size();

    }

    public boolean ehVazia () {

        return this.itens.isEmpty();

    }

    public void adiciona (Item<?> i) {

        this.itens.add(i);
        this.siftUp(this.itens.size() - 1);

    }

    public Item<?> remove () {

        Item<?> removido = this.itens.get(0);

        this.itens.set(0, this.itens.get(this.itens.size() - 1));
        this.itens.remove(this.itens.size() - 1);
        this.siftDown(0);

        return removido;

    }

    private void siftUp (int n) {

        if (n > 0) {

            int pai = Math.floorDiv(n, 2);

            if (this.itens.get(n).getPrioridade() > this.itens.get(pai).getPrioridade()) {

                this.swap(n, pai);
                this.siftUp(pai);

            }

        }

    }

    private void siftDown (int n) {

        int esquerda = 2 * n + 1;
        int direita = 2 * n + 2;
        int maior = n;

        if ((esquerda < this.itens.size()) && this.itens.get(esquerda).getPrioridade() >= this.itens.get(maior).getPrioridade()) {

            maior = esquerda;

        } else if ((direita < this.itens.size()) && this.itens.get(direita).getPrioridade() >= this.itens.get(maior).getPrioridade()) {

            maior = direita;

        }

        if (maior != n) {

            this.swap(n, maior);
            this.siftDown(maior);

        }

    }

    private void swap (int a, int b) {

        Item<?> temp = this.itens.get(a);

        this.itens.set(a, this.itens.get(b));
        this.itens.set(b, temp);

    }

    @Override
    public String toString () {

        return this.itens.toString();

    }

}
