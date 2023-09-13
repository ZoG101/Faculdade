package data;

public class Vertice {

    private String rotulo; // armazena o rótulo de cada vértice
    private boolean visitado; // indica se o vértice foi visitado 

    public Vertice (String rotulo) { // construtor classe Vertice

        this.rotulo = rotulo;
        this.visitado = false;

    }

    public String toString () { // método para converter o vértice em texto

        return this.rotulo;

    }

    public void setRotulo (String rotulo) { // método para alterar o rótulo

        this.rotulo = rotulo;

    }

    public Object getRotulo () { // método para receber o rótulo

        return this.rotulo;

    }

    public void foiVisitado () { // método para indicar visitado

        this.visitado = true;

    }
    public void naoFoiVisitado () { // método para indicar não foi visitado

        this.visitado = false;

    }

    public boolean getVisitado () { // método que retorna o estado de visitado

        return this.visitado;

    }
    
}
