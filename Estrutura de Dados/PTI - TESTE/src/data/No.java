package data;

//Implementação da classe No de uma árvore 
public class No {

    private long id; // identificador do elemento
    private Object elemento; // armazena o elemento de cada No
    private No esq; // aponta para o filho esquerdo do nó
    private No dir; // aponta para o filho direito do nó

    // construtor classe No
    public No (long id, Object elemento, No esq, No dir) {

        this.id = id;
        this.elemento = elemento; 
        this.esq = esq;
        this.dir = dir;

    }

    // método para alterar o identificador do nó
    public void setId (long id) {

        this.id = id;

    }

    // método para receber o identificador do nó
    public long getId () {

        return this.id;

    }

    // método para alterar o elemento
    public void setElemento (Object elemento) {

        this.elemento = elemento;

    }

    // método para receber o objeto contido no No
    public Object getElemento () {

        return elemento;

    }

    // método que altera o filho esquerdo
    public void setEsq (No esq) {

        this.esq = esq;

    }

    // método que recebe o filho esquerdo do nó
    public No getEsq () {

        return esq;

    }

    // método que altera o filho direito
    public void setDir (No dir) {

        this.dir = dir;

    }

    // método que recebe o filho direito do nó
    public No getDir () {

        return dir;

    }

}
