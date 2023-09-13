package data;

// Implementação da classe árvore binária, com construtor e o método insere() 
public class ArvoreBinaria {

    private No raiz;

    // construtor da classe Arvore Binaria
    public ArvoreBinaria () {

        this.raiz = null; // inicia a árvore vazia

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
                        return;

                    } // se não é nulo, vai tentar o próximo filho

                } else { // vai inserir à direita

                    atual = atual.getDir();

                    if (atual == null) { // pode inserir à direita

                        pai.setDir(novoNo);
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
