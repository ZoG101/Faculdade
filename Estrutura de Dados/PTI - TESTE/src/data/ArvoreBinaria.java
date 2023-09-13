package data;

// Implementação da classe árvore binária, com construtor e o método insere() 
public class ArvoreBinaria {

    private No raiz;
    private long tamanho;

    // construtor da classe Arvore Binaria
    public ArvoreBinaria () {

        this.raiz = null; // inicia a árvore vazia
        this.tamanho = 0; // insere o tamanho da árvore atual a 0 (zero)

    }

    // retorna o tamanho atual da árvore
    public long getTamanho () {

        return tamanho; 

    }

    // método para inserção de elemento
    public void insere (long id, Object elemento) {

        No novoNo = new No(id, elemento, null, null);

        if (raiz == null) {

            raiz = novoNo;

        } else {

            No atual = raiz; 
            No pai;

            while (true) {

                pai = atual;

                if (id < atual.getId()) { // vai inserir à esquerda

                    atual = atual.getEsq();

                    if (atual == null) { // pode inserir à esquerda

                        pai.setEsq(novoNo);
                        tamanho++;
                        return;

                    } // se não é nulo, vai tentar o próximo filho

                } else { // vai inserir à direita

                    atual = atual.getDir();

                    if (atual == null) { // pode inserir à direita

                        pai.setDir(novoNo);
                        tamanho++;
                        return;

                    }

                }

            }

        }

    }

    // caminhamento pré-fixado da árvore binária
    private void preFixado (No atual) {

        if (atual != null) {

            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());

            preFixado(atual.getEsq());
            preFixado(atual.getDir());

        }

    } // final método preFixado

    // caminhamento pós-fixado da árvore binária
    private void posFixado (No atual) {

        if (atual != null) {

            posFixado(atual.getEsq()); 
            posFixado(atual.getDir());

            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());

        }

    } // final método posFixado

    // caminhamento simétrico fixado da árvore binária
    private void simFixado (No atual) {

        if (atual != null) {

            simFixado(atual.getEsq());

            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());

            simFixado(atual.getDir());

        }

    } // final método inFixado

    // Utilizando um caminhamento pré-fixado para percorrer a árvore e contar os filhos da esquerda.
    private long calcEsquerda (No atual, long cont) {

        if (atual != null) {

            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());

            cont = calcEsquerda(atual.getEsq(), cont) + 1;
            calcEsquerda(atual.getDir(), cont);

        }

        return cont;

    } // final método calcEsquerdaFestiva

    // Caminhamento pré-fixado para percorrer a árvore e executar o recuo de margem.
    private void arvoreFormatada (No atual, int nivel) {

        // imprime o recuo proporcional ao nível do nó
        for (int i = 0; i < nivel; i++) {

            System.out.print("  ");

        }

        // imprime o ID do nó
        if (atual.getElemento() != null) {

            System.out.println(atual.getId());

        } else {

            System.out.println("-");

        }

        // chama o método recursivamente para os filhos
        if (atual.getEsq() != null) {

            arvoreFormatada(atual.getEsq(), nivel + 1);

        } 
        
        if (atual.getDir() != null) {

            arvoreFormatada(atual.getDir(), nivel + 1);

        }

    }

    // Imprime a árvore formatada com recuo de margem com base no ID do nó.
    private void arvoreFormatadaID (No atual) {

        // imprime o recuo proporcional ao nível do nó
        for (int i = 0; i < atual.getId(); i++) {

            System.out.print("  ");


        }

        // imprime o ID do nó
        if (atual.getElemento() != null) {

            System.out.println(atual.getId());

        } else {

            System.out.println("-");

        }

        // chama o método recursivamente para os filhos
        if (atual.getEsq() != null) {

            arvoreFormatadaID(atual.getEsq());

        } 
        
        if (atual.getDir() != null) {

            arvoreFormatadaID(atual.getDir());

        }

    }

    public void imprimeArvoreFormatada () {

        arvoreFormatada(raiz, 0);

    }

    public void imprimeArvoreFormatadaID () {

        arvoreFormatadaID(raiz);

    }

    public long calcEsquerdaFestiva () {

        /*Se inicializa o contador em 1 pois durante o cominhamento
        o primeiro elemento a esquerda da raiz não é contabilizado.*/
        long contEsq = 1;
        return calcEsquerda(raiz, contEsq);

    }

    // impressão dos elementos da árvore
    public void imprimeElementosArvorePreFix () {

        preFixado(raiz);

    } // final do método para impressão

    // impressão dos elementos da árvore
    public void imprimeElementosArvorePosFix () {

        posFixado(raiz);

    } // final do método para impressão

    // impressão dos elementos da árvore
    public void imprimeElementosArvoreSimFix () {

        simFixado(raiz);

    } // final do método para impressão

    private long calcAltura (No atual, long a) {

        if (atual != null) {

            long e,d;
            e = calcAltura(atual.getEsq(), a) + 1;
            d = calcAltura(atual.getDir(), a) + 1;

            if (e > d) {

                return a + e;

            } else {

                return a + d;

            }

        }

        return a;

    } // final método calcAltura

    public long alturaArvore () {

        long a = 0;
        return calcAltura(raiz, a);

    } // final do método alturaArvore

}
