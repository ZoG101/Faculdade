import data.ListaLigada;
import models.Cliente;

public class App {

    public static void main(String[] args) throws Exception {

        ListaLigada listaClientes = new ListaLigada(); // cria a lista de clientes
        Cliente c = new Cliente(221,"Produtos excelentes LTDA",
        "Rua sem fim, 200",
        5000.0);

        // inserindo elementos na Lista Ligada
        listaClientes.insereInicio(c); // usando uma variável cliente

        listaClientes.insereInicio(new Cliente(185,"Negócios Importantes SA",
        "Avenida Principal, 10",
        12000.0));
        listaClientes.insereInicio(new Cliente(443,"Parceiros Críticos LTDA",
        "Rua dos negócios, 2000",
        7000.0));

        // removendo um elemento da Lista Ligada
        // necessário type casting para a classe Cliente
        Cliente clienteRemovido = (Cliente) listaClientes.removeInicio();
        System.out.println(clienteRemovido);

        listaClientes.imprimeLista();

        c = new Cliente(221,"Produtos excelentes LTDA", "Rua sem fim, 200", 5000.0);

        // inserindo elementos na Lista Ligada
        listaClientes.insereInicio(c); // usando uma variável cliente 
        listaClientes.imprimeLista();
        listaClientes.insereInicio(new Cliente(185,"Negócios Importantes SA", "Avenida Principal, 10", 12000.0));
        listaClientes.imprimeLista();
        listaClientes.insereInicio(new Cliente(443,"Parceiros Críticos LTDA", "Rua dos negócios, 2000", 7000.0));
        listaClientes.imprimeLista();

        // busca do elemento na posição 2 da lista
        c = (Cliente) listaClientes.buscaElemento(2);
        
        if (c != null) {

            System.out.println("Elemento da posicao 2 da Lista Ligada");
            System.out.println(c);

        }

        // removendo um elemento da Lista Ligada
        // necessário type casting para a classe Cliente
        clienteRemovido = (Cliente) listaClientes.removeInicio();

        System.out.println("Elemento removido da Lista Ligada");
        System.out.println(c);
        listaClientes.imprimeLista();

        // liberando toda a lista
        System.out.println("Liberando toda a lista");
        listaClientes.liberaLista();
        listaClientes.imprimeLista();


    }

}
