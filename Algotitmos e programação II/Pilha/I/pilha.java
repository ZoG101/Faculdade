import java.util.Arrays;

class App {

    public static void main (String[] args) {

        pilha p = new pilha(3);

        System.out.printf("Pilha vazia: %s\n", p.toString());

        try {

            p.empilha(29);

            System.out.printf("Empilha: %s <= %d\n", p.toString(), 29);

            p.empilha(42);

            System.out.printf("Empilha: %s <= %d\n", p.toString(), 42);

            p.empilha(10);

            System.out.printf("Empilha: %s <= %d\n", p.toString(), 10);

            p.empilha(83);

            System.out.printf("Empilha: %s <= %d\n", p.toString(), 83);

        } catch (RuntimeException e) {

            System.err.println(e.getMessage());

        }

        System.out.printf("Pilha cheia: %s\n", p.toString());

        try {

            System.out.printf("Desempilha: %s\n", p.toString(), p.desempilha());
            System.out.printf("Desempilha: %s\n", p.toString(), p.desempilha());
            System.out.printf("Desempilha: %s\n", p.toString(), p.desempilha());
            System.out.printf("Desempilha: %s\n", p.toString(), p.desempilha());

        } catch (RuntimeException e) {

            System.err.println(e.getMessage());

        }

        System.out.printf("Pilha vazia: %s\n", p.toString());

    }

}

public class pilha {
    
    private int[] dados;
    private int topo;
    private int capacidade;

    public pilha(int capacidade) {

        this.capacidade = capacidade;
        this.dados = new int [this.capacidade];
        this.topo = -1;

    }

    public pilha () {

        this(10);

    }

    public boolean ehVazia () {

        return topo == -1;

    }

    public int topo () {

        return this.dados[this.topo];

    }

    public int tamanho () {

        return this.topo + 1;

    }

    public void empilha (int numero) {

        if ((this.topo + 1) >= this.capacidade) {

            throw new RuntimeException("A pilha está cheia");

        }

        this.dados[++this.topo] = numero;

    }

    public int desempilha () {

        if (this.ehVazia()) {

            throw new RuntimeException("A pilha está vazia.");

        }

        return this.dados[this.topo--] = 0;

    }

    @Override
    public String toString () {

        return Arrays.toString(this.dados);

    }

}
