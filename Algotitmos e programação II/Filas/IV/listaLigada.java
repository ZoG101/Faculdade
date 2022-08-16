class Elemento {

    private int valor;
    private Elemento proximo;

    public Elemento () {

        this.valor = -1;
        this.proximo = null;

    }

    public Elemento (int valor) {

        this.valor = valor;
        this.proximo = null;

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

public class listaLigada {

    private Elemento primeiro = null;
    private Elemento ultimo = null;
    private int tamanho = 0;

    public Elemento primeiro () {

        return this.primeiro;

    }

    public boolean ehVazio () {

        return this.tamanho == 0;

    }

    public int tamanho () {

        return this.tamanho;

    }

    public void enfileira (int numero) {

        if (this.primeiro == null) {

            this.primeiro = new Elemento(numero);

        } else if (this.ultimo == null) {

            this.ultimo = new Elemento(numero);
            this.primeiro.setProximo(this.ultimo);

        } else {

            Elemento e = new Elemento (numero);

            this.ultimo.setProximo(e);
            this.ultimo = new Elemento();
            this.ultimo = e;

        }

        this.tamanho++;

    }

    public Elemento desenfileira () {

        if (this.ehVazio()) {

            throw new RuntimeException("A fila está vazia");

        }

        Elemento e = this.primeiro;

        this.primeiro = this.primeiro.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {

            this.primeiro = null;
            this.ultimo = null;

        }

        return e;

    }

}
