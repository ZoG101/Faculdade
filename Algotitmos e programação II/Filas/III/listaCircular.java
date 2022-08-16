import java.util.Arrays;

public class listaCircular {

    private final int[] dados;
    private final int capacidade;
    private int primeiro;
    private int ultimo;
    private int tamanho;

    public listaCircular (int capacidade) { 

        this.capacidade = capacidade; 
        this.dados = new int[this.capacidade]; 
        this.primeiro = 0; 
        this.ultimo = 0; 
        this.tamanho = 0; 

    } 

    public listaCircular () { 

        this(10);

    } 

    public int primeiro() { 

        return this.dados[this.primeiro]; 

    } 

    public boolean ehVazia() { 

        return primeiro == ultimo && this.tamanho == 0; 

    } 

    public int tamanho() { 

        return this.tamanho; 

    } 

    public void enfileira(int numero) {

        if(this.tamanho == this.capacidade) { 

            throw new RuntimeException("A fila está com a capacidade máxima."); 

        }

        this.dados[this.ultimo] = numero; 
        this.ultimo = (this.ultimo + 1) % this.capacidade; 
        this.tamanho++; 

    } 

    public int desenfileira() { 

        if(this.ehVazia()) { 

            throw new RuntimeException("A fila está vazia."); 

        }

        int numero = this.dados[this.primeiro]; 
        this.dados[this.primeiro] = -1; 
        this.primeiro = (this.primeiro + 1) % this.capacidade; 
        this.tamanho--; 
        return numero; 

    } 

    @Override 
    public String toString() { 

        return Arrays.toString(this.dados); 

    } 
    
}
