package data;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

// implementação da classe Grafo
public class Grafo {

    private final int MAX_VERTICES = 20; // número máximo de vértices
    private final int INFINITO = 1000000; // número muito grande 
    private Vertice listaVertice[]; // lista de vértices
    private int matriz[][]; // matriz adjacente
    private int numVertices; // número atual de vértices
    private int numFechados; // número de vértices com distância fechada
    private DistanciaEstimada menor[]; // vetor com o caminho mais curto 
    private int verticeAtual; // vértice atual
    private int distParaAtual; // distância para o vértice atual
    
    public Grafo () { // construtor da clase Grafo

        listaVertice = new Vertice[MAX_VERTICES]; // cria a lista de vértices
        matriz = new int[MAX_VERTICES][MAX_VERTICES]; // cria a matriz adjacente 
        numVertices = 0; // inicia número de vértices como 0
        numFechados = 0; // inicia com nenhum vértice fechado

        for(int y = 0; y < MAX_VERTICES; y++) { // inicia matriz com valor infinito

            for(int x = 0; x < MAX_VERTICES; x++) {

                matriz[x][y] = INFINITO;

            }

        }

        menor = new DistanciaEstimada[MAX_VERTICES];

    }// final construtor

    public void adicVertice (String rotulo) { // método para adicionar um novo vértice

        listaVertice[numVertices++] = new Vertice(rotulo);

    } // final adicVertice

    public void adicAresta (int inicio, int fim) { // método para adicionar uma aresta

        matriz[inicio][fim] = 1;
        matriz[fim][inicio] = 1;

    } // final adicAresta

    public void adicAresta (int inicio, int fim, int peso) { // método para adicionar uma aresta

        matriz[inicio][fim] = peso;
        matriz[fim][inicio] = peso;

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

    private int pegaMinimo () { // pega o índice com a menor distância 

        int minimo = INFINITO; // inicia o mínimo
        int indice = 0;

        for (int j = 1; j < numVertices; j++) { // acessa cada vértice

            if (!listaVertice[j].getVisitado() && menor[j].getDistancia() < minimo) {

                // se for menor que o anterior, marca como menor
                minimo = menor[j].getDistancia();
                indice = j;

            }
        }

        return indice;

    } // final pegaMinimo

    private void ajustaMenor () { // ajusta o vetor com os caminhos mais curtos

        int coluna = 1; // pula o vértice inicial

        while (coluna < numVertices) { // percorre as colunas

            if (listaVertice[coluna].getVisitado()) {
                
                // se vértice já está fechado, pula a coluna
                coluna++;
                continue;

            }

            // calcula a distância para uma entrada de menor[]
            int atualParaMargem = matriz[verticeAtual][coluna]; 
            int inicioParaMargem = distParaAtual + atualParaMargem;
            int menorDistancia = menor[coluna].getDistancia();

            if (inicioParaMargem < menorDistancia) {

                menor[coluna].setPaiVertice(verticeAtual);
                menor[coluna].setDistancia(inicioParaMargem);

            }

            coluna++;
            
        }

    } // final ajustaMenor

    private void mostraMenor () { // mostra o menor caminho encontrado

        for(int j = 0; j < numVertices; j++) { // mostra o conteúdo de menor[]

            System.out.print(listaVertice[j].getRotulo() + "=");

            if (menor[j].getDistancia() == INFINITO) {

                System.out.print("inf");

            } else {

                System.out.print(menor[j].getDistancia());

            }

            String pai = (String) listaVertice[menor[j].getPaiVertice()].getRotulo();
            System.out.print("(" + pai + ") ");

        }

        System.out.println("");
        
    } // final mostraMenor

    public void menorCaminho () { // encontra o menor caminho 

        int inicio = 0; // começa pelo vértice 0
        listaVertice[inicio].foiVisitado(); // primeiro vértice marcado como fechado
        numFechados = 1; // inclui o vértice inicial como fechado

        for(int j = 0; j <= numVertices; j++) { // transfere as distâncias para o vetor menor

            // distância armazenada na matriz de adjacências
            int distancia = matriz[inicio][j];
            // pai recebe inicio=0 e a distância
            menor[j] = new DistanciaEstimada(inicio, distancia);

        }

        while(numFechados < numVertices) { // até que todos os vértices estejam fechados

            // sempre trata o mínimo do vetor menor
            int indiceParaMinimo = this.pegaMinimo();
            // pega a distância mínima
            int minimaDistancia = menor[indiceParaMinimo].getDistancia();

            if(minimaDistancia == INFINITO) { // existe vértice não encontrado
                // só ocorre quando todos os vértices alcançáveis são fechados

                // e ainda existem vértices
                System.out.println("Existem vértices não endereçados");
                break; // termina o loop while

            } else { // vai redefinir o verticeAtual

                // passa a ser o vértice mais próximo a ser fechado
                verticeAtual = indiceParaMinimo;
                distParaAtual = menor[indiceParaMinimo].getDistancia(); // distância mínima

            }

            listaVertice[verticeAtual].foiVisitado(); // marca vértice atual como fechado
            numFechados++; // incrementa o número de vértices fechados 
            this.ajustaMenor();

        }

        this.mostraMenor(); // mostra o conteúdo de menor[]
        numFechados = 0;

        // limpa o número de vértices fechados para a próxima busca
        for(int j = 0; j < numVertices; j++) // reset flags
        listaVertice[j].naoFoiVisitado();

    } // final método menorCaminho

} // final da classe Grafo
