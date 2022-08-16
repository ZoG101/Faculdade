public class fila {
    
    private final int[] dados;
    private final int capacidade;
    private int fim;

    public fila (int capacidade) {

        this.capacidade = capacidade;
        this.dados = new int[this.capacidade];
        this.fim = 0;

    }

    public fila () {

        this(10);

    }

    public int primeiro () {

        return this.dados[0];

    }

    public boolean ehVazia () {

        return this.fim == 0;

    }

    public int tamanho () {

        return this.fim;

    }

    public void enfileira (int numero) {

        if ((this.fim + 1) > this.capacidade) {

            throw new RuntimeException("A fila está com a capacidade máxima.");

        }

        this.dados[this.fim++] = numero;

    }

    public int desenfileira () {

        if (this.ehVazia()) {

            throw new RuntimeException("A fila está vazia.");

        }

        int numero = this.dados[0];

        for (int i = 0; i < this.fim - 1; i++) {

            this.dados[i] = this.dados[i + 1];

        }

        this.fim--;

        return numero;

    }

    public static void main(String[] args) {

        fila f = new fila(3);

        System.out.printf("Fila atual: %s.\n", f.toString()); 

        try {

            f.enfileira(29);

            System.out.printf("Fila %s <= %s enfileirado.\n", f.toString(), 29);

            f.enfileira(10);

            System.out.printf("Fila %s <= %s enfileirado.\n", f.toString(), 10);

            f.enfileira(83);

            System.out.printf("Fila %s <= %s enfileirado.\n", f.toString(), 83);

            f.enfileira(36);

            System.out.printf("Fila %s <= %s enfileirado.\n", f.toString(), 36);

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

        System.out.printf("Fila atual: %s.\n", f.toString());

        try {

            System.out.printf("Desenfileirando %d <= fila %s.\n", f.desenfileira(), f.toString());
            System.out.printf("Desenfileirando %d <= fila %s.\n", f.desenfileira(), f.toString());
            System.out.printf("Desenfileirando %d <= fila %s.\n", f.desenfileira(), f.toString());
            System.out.printf("Desenfileirando %d <= fila %s.\n", f.desenfileira(), f.toString());

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }

    }

}
