import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class roundRobin {

    public static void main (String[] args) {

        Escalonador escalonador = new Escalonador();
        escalonador.executa();

    }

}

class Pedido {

    private ArrayList<String> produtos = new ArrayList<String>();
    private int numero;

    public Pedido (int numero) {

        this.numero = numero;

        for (int i = 1; i <= 10; i++) {

            this.produtos.add("Produto " + i);

        }

    }

    public String entregarNoCaminho() {

        return produtos.remove(0);

    }

    public boolean noCaminhao() {

        return produtos.isEmpty();

    }

    public int getNumero() {

        return numero;

    }

    public int restantes() {

        return produtos.size();

    }
    
}

class Escalonador {

    private static Queue<Pedido> pedidos = new LinkedList<Pedido>();
    private static int[] tempoExecucao = {2, 3, 1};

    static {

        pedidos.offer(new Pedido(1));
        pedidos.offer(new Pedido(2));
        pedidos.offer(new Pedido(3));

    }

    public void executa () {

        while (!pedidos.isEmpty()) {

            int qtdePedidos = pedidos.size();
            Pedido p = pedidos.poll();

            for (int i = 0; i < qtdePedidos; i++) {

                int tempo = tempoExecucao[i];

                for (int j = 0; j <= tempo; j++) {

                    if (!p.noCaminhao()) {

                        System.out.println("Pedido: " + p.getNumero() + " - produto " + p.entregarNoCaminho() + " no caminhão.");

                    }

                }

                if (!p.noCaminhao()) {

                    pedidos.offer(p);
                    p = pedidos.poll();

                }

            }

        }

    }

}
