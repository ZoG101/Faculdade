import java.util.Arrays;

public class passagens {

    public static void main(String[] args) {

        FilaPrioridade p = new FilaPrioridade();

        p.enfileira(new Ticket("Maria", Tipo.IDOSO));
        p.enfileira(new Ticket("Jose", Tipo.DEMAIS));
        p.enfileira(new Ticket("Carla", Tipo.GESTANTE));
        p.enfileira(new Ticket("Sofia", Tipo.IDOSO));
        p.enfileira(new Ticket("Manoel", Tipo.CRIANCA));
        p.enfileira(new Ticket("João", Tipo.DEMAIS));
        p.enfileira(new Ticket("Marisa", Tipo.DEMAIS));

        System.out.println(p);

        System.out.println(p.desenfileira());
        System.out.println(p.desenfileira());
        System.out.println(p.desenfileira());
        System.out.println(p.desenfileira());
        System.out.println(p.desenfileira());
        System.out.println(p.desenfileira());
        System.out.println(p.desenfileira());

    }

}

enum Tipo {

    IDOSO(0), GESTANTE(1), CRIANCA(2), DEMAIS(3);

    public int valor;

    private Tipo (int valor) {

        this.valor = valor;

    }

}

class Ticket {

    public String nome;
    public Tipo prioridade;

    public Ticket(String nome, Tipo tipo) {

        super();
        this.nome = nome;
        this.prioridade = tipo;

    }

    public String getNome() {

        return nome;
    
    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public Tipo getPrioridade() {

        return prioridade;

    }

}

class FilaPrioridade {

    private Ticket[] tickets;
    private int tamanho;
    private int capacidade;

    public FilaPrioridade (int capacidade) {

        this.tamanho = 0;
        this.capacidade = capacidade;
        this.tickets = new Ticket[this.capacidade];

    }

    public FilaPrioridade () {

        this(10);

    }

    public boolean ehVazia () {

        return this.tamanho == 0;

    }

    public int tamanho () {

        return this.tamanho;

    }

    public void enfileira (Ticket t) {

        if (this.capacidade == this.tamanho) {

            throw new RuntimeException("A fila está cheia.");

        }

        this.tickets[this.tamanho++] = t;

    }

    public Ticket desenfileira () {

        if (this.ehVazia()) {

            throw new RuntimeException("A fila está vazia.");

        }

        int indice = this.buscaMaiorPrioridade();

        Ticket altaPrioridade = this.tickets[indice];

        for (int i = indice; i < this.tamanho() - 1; i++) {

            this.tickets[i] = this.tickets[i + 1];

        }

        this.tamanho--;

        return altaPrioridade;

    }

    private int buscaMaiorPrioridade() {

        int p = 0;

        for (int i = 0; i < this.tamanho(); i++) {

            if (this.tickets[p].getPrioridade().valor > this.tickets[i].getPrioridade().valor) {

                p = i;

            }

        }

        return p;

    }

    @Override
    public String toString() {

        return Arrays.toString(this.tickets);

    }

}
