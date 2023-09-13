package data;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

// implementação da classe Grafo
public class Grafo {

    private final int MAX_VERTICES = 20; // número máximo de vértices
    private Vertice listaVertice[]; // lista de vértices
    private int matriz[][]; // matriz adjacente
    private int numVertices; // número atual de vértices

    public Grafo () { // construtor da clase Grafo

        listaVertice = new Vertice[MAX_VERTICES]; // cria a lista de vértices
        matriz = new int[MAX_VERTICES][MAX_VERTICES]; // cria a matriz adjacente 
        numVertices = 0; // inicia número de vértices como 0

        for(int y = 0; y < MAX_VERTICES; y++) { // inicializa matriz zerada, sem arestas

            for(int x = 0; x < MAX_VERTICES; x++) {

                matriz[x][y] = 0;

            }

        }

    }// final construtor

    public void adicVertice (String rotulo) { // método para adicionar um novo vértice

        listaVertice[numVertices++] = new Vertice(rotulo);

    } // final adicVertice

    public void adicAresta (int inicio, int fim) { // método para adicionar uma aresta

        matriz[inicio][fim] = 1;
        matriz[fim][inicio] = 1;

    } // final adicAresta

    public void mostraVertice (int v) { // método para exibir um determinado vértice 

        System.out.print(listaVertice[v].getRotulo());

    } // final displayVértice

    public void DFS () { // pesquisa em profundidade no grafo

        Stack<Integer> p = new Stack<Integer>();
        listaVertice[0].foiVisitado(); // indica que o primeiro vértice foi visitado
        this.mostraVertice(0); // mostra o primeiro vértice
        p.push(0); // coloca na pilha

        while(!p.empty()) { // até que a pilha seja vazia

            // pega um vértice adjacente ainda não visitado para colocar na pilha
            int v = this.pegaVerticeNaoVisitado((int) p.peek());

            if(v == -1) { // se não encontrou, tira um da pilha

                p.pop();

            } else { // encontrou um vértice não visitado

                listaVertice[v].foiVisitado(); // marca como visitado 
                this.mostraVertice(v); // mostra o vértice na tela 
                p.push(v); // coloca na pilha
                
            }

        }

        // a pilha está vazia, basta resetar todas as marcações
        for(int j = 0; j < numVertices; j++) { // reset flags

            listaVertice[j].naoFoiVisitado();

        }

    } // final método DFS

    private int pegaVerticeNaoVisitado (int v) { // método encontra vértice ainda não visitado 

        for(int j = 0; j < numVertices; j++) {

            if(matriz[v][j] == 1 && listaVertice[j].getVisitado() == false) {

                return j;

            }

        }

        return -1;

    } // final pegaVerticeNaoVisitado

    public void BFS () { // pesquisa em profundidade no grafo

        Queue<Integer> f = new ConcurrentLinkedQueue<Integer>();
        listaVertice[0].foiVisitado(); // indica que o primeiro vértice foi visitado
        this.mostraVertice(0); // mostra o primeiro vértice
        f.add(0); // insere no final da fila
        int v2;

        while(!f.isEmpty()) { // até que a fila seja vazia

            int v1 = (int) f.remove(); // remove o vértice do início da fila

            // até que não haja mais adjacente não visitado
            while((v2 = this.pegaVerticeNaoVisitado(v1)) != (-1)) { // pegue um

                listaVertice[v2].foiVisitado(); // marca como visitado 
                this.mostraVertice(v2); // mostra o vértice na tela 
                f.add(v2); // insere no final da fila

            }

        }

        // a fila está vazia, basta resetar todas as marcações
        for(int j = 0; j < numVertices; j++) { // reset flags

            listaVertice[j].naoFoiVisitado();

        }

    } // final método BFS

    public void MST() { // Árvore geradora mínima

        Stack<Integer> p = new Stack<Integer>();
        listaVertice[0].foiVisitado(); // indica que o primeiro vértice foi visitado
        p.push(0); // coloca na pilha

        while(!p.empty()) { // até que a pilha seja vazia

            // pega do topo o vétice inicial.
            int verticeAtual = (int) p.peek();
            // pega um vértice adjacente ainda não visitado para colocar na pilha
            int v = this.pegaVerticeNaoVisitado(verticeAtual);

            if(v == -1) { // se não encontrou, tira um da pilha

                p.pop();

            } else { // encontrou um vértice não visitado

                listaVertice[v].foiVisitado(); // marca como visitado 
                p.push(v); // coloca na pilha
                this.mostraVertice(verticeAtual);
                this.mostraVertice(v); // mostra o vértice na tela 
                System.out.println("");
                
            }

        }

        // a pilha está vazia, basta resetar todas as marcações
        for(int j = 0; j < numVertices; j++) { // reset flags

            listaVertice[j].naoFoiVisitado();

        }

    }

} // final da classe Grafo
