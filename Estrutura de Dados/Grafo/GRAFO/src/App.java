import data.Grafo;

public class App {

    public static void main(String[] args) throws Exception {

        Grafo g = new Grafo(); // criação do novo Grafo com até 20 vértices

        // inserção dos vértices
        g.adicVertice("A"); // será índice 0 
        g.adicVertice("B"); // será índice 1 
        g.adicVertice("C"); // será índice 2 
        g.adicVertice("D"); // será índice 3

        // inserção das arestas
        g.adicAresta(0,1); // aresta AB
        g.adicAresta(0,2); // aresta AC
        g.adicAresta(0,3); // aresta AD 
        g.adicAresta(2,3); // aresta CD

        Grafo f = new Grafo(); // criação do novo Grafo com até 20 vértices
        // inserção dos vértices
        f.adicVertice("A"); // será índice 0 
        f.adicVertice("B"); // será índice 1 
        f.adicVertice("C"); // será índice 2 
        f.adicVertice("D"); // será índice 3 
        f.adicVertice("E"); // será índice 4 
        f.adicVertice("F"); // será índice 5 
        f.adicVertice("G"); // será índice 6

        // inserção das arestas
        f.adicAresta(0,1); // aresta AB
        f.adicAresta(0,2); // aresta AC
        f.adicAresta(0,3); // aresta AD 
        f.adicAresta(1,4); // aresta BE 
        f.adicAresta(4,6); // aresta EG 
        f.adicAresta(2,5); // aresta CF 
        f.adicAresta(2,3); // aresta CD

        System.out.print("DFS - Vertices visitados: ");

        f.DFS(); // pesquisa em profundidade
        System.out.println();

        g.BFS(); // pesquisa em profundidade
        System.out.println();   

        f.MST(); // Árvore geradora mínima
        System.out.println();

    }

}
