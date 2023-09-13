package data;

// Implementação da classe árvore binária, com construtor e o método insere() 
public class ABB {

    private No raiz;

    // construtor da classe Arvore Binaria
    public ABB () {

        this.raiz = null; // inicia a árvore vazia

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

    // caminhamento in fixed da árvore binária
    private void inFixado (No atual) {

        if (atual != null) {

            inFixado(atual.getEsq());

            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());

            inFixado(atual.getDir());

        }

    }

    // caminhamento in fixed da árvore binária com contador de repetidos
    private void inFixadoRepetido (No atual) {

        if (atual != null) {

            inFixado(atual.getEsq());

            System.out.println("Id: " + atual.getId() + " REPETIDOS: " + atual.getCont());

            inFixado(atual.getDir());

        }

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

    // impressão dos elementos da árvore
    public void imprimeElementosArvoreInFix () {

        inFixado(raiz);

    } // final do método para impressão da árvore

    // impressão dos elementos da árvore com contador de repetidos
    public void imprimeElementosArvoreInFixRepetidos () {

        inFixadoRepetido(raiz);

    } // final do método para impressão da árvore

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

    // inserção na ABB
    public void insereABB (long id, Object elemento) {

        if (raiz == null) {

            raiz = new No(id, elemento, null, null);

        } else {

            No novoNo = new No(id, elemento, null, null);
            insere(raiz, novoNo);

        }

    } // final do método insereABB

    // inserção ordenada
    private void insere (No atual, No novo) {

        if (atual.getId() == novo.getId()) { // achou o elemento, nada inserido 

            return;

        }

        if (novo.getId() < atual.getId()) { // vai inserir à esquerda

            if(atual.getEsq() == null) { // achou a posição, basta inserir

                atual.setEsq(novo);

            } else { // continua buscando resursivamente à esquerda

                insere(atual.getEsq(), novo);

            }

        }

        if (novo.getId() > atual.getId()) { // vai inserir à direita

            if(atual.getDir() == null) { // achou a posição, basta inserir

                atual.setDir(novo);

            } else { // continua buscando resursivamente à direita

                insere(atual.getDir(), novo);

            }

        }

    } // final método insere

    // busca de um elemento na ABB
    public No buscaABB (long id) {

        return busca(raiz, id);

    } // final do método buscaABB

    // busca recursiva na ABB
    private No busca (No atual, long id) {

        if (atual == null) { // não encontrou e retorna nulo 

            return null;

        } else {

            if (id == atual.getId()) { // achou o elemento

                return atual;

            } else {

                if (id < atual.getId()) {

                    // busca só na subárvore esquerda
                    return busca(atual.getEsq(), id);

                } else { 

                    // busca só na subárvore direita 
                    return busca(atual.getDir(), id);

                }

            }

        }

    } // final do método buscaABB

    // remove um elemento da ABB
    public boolean removeABB (long id) { // a ABB não pode ser vazia

        No atual = raiz;
        No pai = raiz;
        boolean filhoEsq = true;

        while (atual.getId() != id) { // busca o elemento

            pai = atual;

            if (id < atual.getId()) { // busca à esquerda

                filhoEsq = true;
                atual = atual.getEsq();

            } else { // busca à direita

                filhoEsq = false;
                atual = atual.getDir();

            }

            if (atual == null) { // não achou e termina

                return false;

            }

        }

        // caso 1: elemento não possui filhos
        if (atual.getEsq() == null && atual.getDir() == null) {

            if (atual == raiz) { // eliminando a raiz da ABB

                raiz = null;

            } else {

                if (filhoEsq) { // o elemento era filho esquerdo

                    pai.setEsq(null);

                } else { // o elemento era filho direito

                    pai.setDir(null);

                }

            }

        } else {

            if (atual.getDir() == null) { // Caso 2: com apenas o filho esquerdo

                if (atual == raiz) { // eliminando a raiz

                    raiz = atual.getEsq();

                } else {

                    if (filhoEsq) { // o elemento era filho esquerdo

                        pai.setEsq(atual.getEsq());

                    } else { // o elemento era filho direito

                        pai.setDir(atual.getEsq());

                    }

                }

            } else {

                if (atual.getEsq() == null) { // Caso 2: com apenas o filho direito

                    if (atual == raiz) { // eliminando a raiz

                        raiz = atual.getDir();

                    } else {

                        if (filhoEsq) { // o elemento era filho esquerdo

                            pai.setEsq(atual.getDir());

                        } else { // o elemento era filho direito

                            pai.setDir(atual.getDir());

                        }

                    }

                } else { // Caso 3: elemento possui os dois filhos

                    No sucessor = getSucessor(atual); // busca o elemento sucessor

                    if (atual == raiz) { // raiz passa a ser o sucessor

                        raiz = sucessor;

                    } else {

                        if (filhoEsq) { // o elemento era filho esquerdo

                            pai.setEsq(sucessor);

                        } else { // o elemento era filho direito

                            pai.setDir(sucessor);
                        
                        }

                    }

                    sucessor.setEsq(atual.getEsq());

                }

            }

        }

        return true;

    } // final método removeABB

    // encontra o próximo menor valor
    private No getSucessor (No eliminado) {

        No sucessorPai = eliminado;
        No sucessor = eliminado;
        No atual = eliminado.getDir(); // ir para o filho da direita

        while (atual != null) { // até não haver mais filhos à esquerda

            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.getEsq();

        }

        if (sucessor != eliminado.getDir()) { // se não for o próprio filho direito 

            sucessorPai.setEsq(sucessor.getDir());
            sucessor.setDir(eliminado.getDir());

        }

        return sucessor;

    } // final método getSucessor

    // Contagem de nós repetidos
    public void contaRepeticao (long id, Object elemento) {

        if (raiz == null) {

            raiz = new No(id, elemento, null, null);

        } else {

            No novoNo = new No(id, elemento, null, null);
            insereContaRepetido(raiz, novoNo);

        }

    }

    // Inserção ordenada contando o repetido
    private void insereContaRepetido (No atual, No novoNo) {

        if (atual.getId() == novoNo.getId()) {// achou, nada inserido

            atual.incrementaCont();
            return;

        }

        if (novoNo.getId() < atual.getId()) {// vai inserir a esquerda

            if (atual.getEsq() == null) {// achou a posição, vai inserir

                atual.setEsq(novoNo);

            } else {// continua buscando a esquerda

                insereContaRepetido(atual.getEsq(), novoNo);

            }

        }

        if (novoNo.getId() > atual.getId()) {// vai inserir a direita

            if (atual.getDir() == null) {// achou a posição, vai inserir

                atual.setDir(novoNo);

            } else {// continua buscando a direita

                insereContaRepetido(atual.getDir(), novoNo);

            }

        }    

    }

}
