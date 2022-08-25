import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class transporte {

    public static void main(String[] args) {
    
        ListaPedidos lista = new ListaPedidos();

        while (!lista.finalizou()) {

            System.out.println(lista.getPedido().getProduto());

        }

    }

}

class Pedido {

    private String produto;
    private int distanciaDaCentral;

    public Pedido (String produto, int distanciaDaCentral) {

        super();

        this.produto = produto;
        this.distanciaDaCentral = distanciaDaCentral;

    }

    public String getProduto () {

        return produto;

    }

    public void setProduto (String produto) {

        this.produto = produto;

    }

    public int getDistanciaDaCentral () {

        return distanciaDaCentral;

    }

}

class ListaPedidos {

    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public ListaPedidos () {

        pedidos.add(new Pedido("Computador", 10));
        pedidos.add(new Pedido("TV", 5));
        pedidos.add(new Pedido("Rack", 8));
        pedidos.add(new Pedido("Cadeira", 14));
        pedidos.add(new Pedido("Camera", 20));

        Collections.sort(pedidos, Comparator.comparing(Pedido::getDistanciaDaCentral));

    }

    public Pedido getPedido () {

        return pedidos.remove(pedidos.size() - 1);

    }

    public boolean finalizou () {

        return pedidos.isEmpty();

    }

}
