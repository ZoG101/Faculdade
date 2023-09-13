package data;

public class ListaLigada {

    private No inicio;

    // construtor da classe Lista inicializada vazia
    public ListaLigada () {
        
        this.inicio = null;

    }

    public Boolean ehVazia () {

        return this.inicio == null;

    }

    public void insereInicio (Object elemento) {
        
        No novoNo = new No(elemento, null); // passo 1 
        novoNo.setProximo(this.inicio); // passo 2  
        this.inicio = novoNo; // passo 3 

    }

    public Object removeInicio () {

        if (!ehVazia()) {

            No auxiliar = this.inicio; // passo 1
            this.inicio = auxiliar.getProximo(); // passo 2 
            return auxiliar.getElemento(); // passo 3

        }

        return null;

    }

    // método para imprimir todo o conteúdo da lista
    public void imprimeLista () {

        //auxiliar percorre a lista do início ao fim
        No auxiliar = this.inicio; 
        System.out.println("Inicio da Lista Ligada");

        // testa se ainda não chegou no final da lista
        while (auxiliar != null) {

            // imprime com o método toString  
            System.out.println(auxiliar.getElemento()); 
            // passa para o próximo Nó da lista
            auxiliar = auxiliar.getProximo();

        }

        System.out.println("Final da Lista Ligada");        

    }

    // busca o elemento na posição da lista
    public Object buscaElemento (long posicao) {

        No auxiliar = this.inicio;

        while ((posicao >= 0) && (auxiliar != null)) {

            if (posicao == 0) return auxiliar.getElemento();

            posicao--;

            // passa para o próximo Nó da lista
            auxiliar = auxiliar.getProximo(); 

        }

        // a lista não possui elemento na posição indicada
        return null; 

    }

    // libera todos os nós da lista
    public void liberaLista () {

        while (inicio != null) {

            // o garbage collector de Java libera automaticamente o nó eliminado
            inicio = inicio.getProximo();
            
        }

    }

}
