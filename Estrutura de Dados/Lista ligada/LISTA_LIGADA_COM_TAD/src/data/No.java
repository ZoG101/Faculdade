package data;

public class No {

    private No proximo; // aponta para o próximo No da Lista
    private Object elemento; // armazena o elemento de cada No 

    public No (Object elemento, No proximo) {

        this.elemento = elemento; this.proximo = proximo;

    }

    // método que altera próximo No da Lista
    public void setProximo (No proximo) {

        this.proximo = proximo;

    }

    // método que recebe o próximo No da Lista
    public No getProximo () {

        return this.proximo;

    }

    // método para alterar o elemento
    public void setElemento (Object elemento) {

        this.elemento = elemento;

    }

    // método para receber o objeto contido no No
    public Object getElemento () {

        return this.elemento;

    }

}
