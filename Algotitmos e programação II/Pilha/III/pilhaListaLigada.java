import java.util.Arrays;

public class pilhaListaLigada {

    private Elemento topo;
    private int tamanho;

    public boolean ehVazia () {

        return this.topo == null;

    }

    public Elemento topo () {

        return this.topo;

    }

    public int tamanho () {

        return this.tamanho;

    }
    
    public void empilha (int numero) {

        Elemento novo = new Elemento(numero, null);

        if (this.ehVazia()) {

            this.topo = novo;

        } else {

            novo.setProximo(this.topo);

            this.topo = new Elemento();
            this.topo = novo;

        }

        this.tamanho++;

    }

    public Elemento desempilha () {

        if (this.ehVazia()) {

            throw new RuntimeException("A pilha está vazia");

        }

        Elemento removido = this.topo;

        this.topo = this.topo.getProximo();
        this.tamanho--;

        return removido;

    }

    @Override
    public String toString () {

        StringBuilder sb = new StringBuilder("[");

        if (!this.ehVazia()) {

            Elemento e = this.topo;

            while (e != null) {

                sb.append(e.getValor());

                if (e.getProximo() != null) sb.append(",");

                e = e.getProximo();

            }

        }

        sb.append("]");

        return sb.toString();

    }

}

class Elemento {

    private int valor;

    private Elemento proximo;

    public Elemento () {

        this.valor = -1;
        this.proximo = null;

    }

    public Elemento (int valor, Elemento proximo) {

        this.valor = valor;
        this.proximo = proximo;

    }

    public int getValor () {

        return valor;

    }

    public void setProximo (Elemento proximo) {

        this.proximo = proximo;

    }

    public Elemento getProximo () {

        return proximo;

    }

}
