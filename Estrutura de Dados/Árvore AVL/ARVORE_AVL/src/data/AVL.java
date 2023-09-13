package data;

public class AVL {

    private No raiz;

    // construtor da classe Arvore Binaria
    public AVL () {

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

    // inserção na AVL
    public void insereAVL (long id, Object elemento) {

        No novoNo = new No(id,elemento,null,null);
        insereBalanceado(raiz, novoNo);

    } // final do método insereAVL

    // inserção ordenada
    private void insereBalanceado (No atual, No novo) {

        if (atual == null) { // árvore vazia, insere na raiz

            this.raiz = novo;
            return;

        }

        if (novo.getId() < atual.getId()) { // vai inserir à esquerda

            if(atual.getEsq() == null) { // achou a posição, basta inserir

                atual.setEsq(novo);
                novo.setPai(atual); 
                avaliaBalanceamento(atual);

            } else { // continua buscando resursivamente à esquerda

                insereBalanceado(atual.getEsq(), novo);

            }

        } else {

            if (novo.getId() > atual.getId()) { // vai inserir à direita

                if(atual.getDir() == null) { // achou a posição, basta inserir

                    atual.setDir(novo);
                    novo.setPai(atual);
                    avaliaBalanceamento(atual);

                } else { // continua buscando resursivamente à direita

                    insereBalanceado(atual.getDir(), novo);

                }

            } else {

                return; // achou o elemento igual, nada inserido

            }

        }

    } // final método insere

    // avaliar o balanceamento da árvore AVL
    private void avaliaBalanceamento (No atual) {

        calcBalanceamento(atual); // calcula o indicador B do nó atual
        long b = atual.getB();

        if (b == -2) { // b=-2 indica que a subárvore direita ficou maior

            if (altura(atual.getEsq().getEsq()) >= altura(atual.getEsq().getDir())) {

                // testa netos esq
                atual = rotacaoDir(atual); // subárvore esquerda do neto é maior, rotação simples

            } else {

                atual = duplaRotacaoDir(atual); // rotação dupla

            }

        } else {

            if (b == 2) { // b=2 indica que a subárvore esquerda ficou maior

                if (altura(atual.getDir().getDir()) >= altura(atual.getDir().getEsq())) {

                    // testa netos dir
                    atual = rotacaoEsq(atual); // subárvore direita do neto é maior, rotação simples

                } else {

                    atual = duplaRotacaoEsq(atual); // rotação dupla

                }

            }

        }

        if (atual.getPai() != null) {

            avaliaBalanceamento(atual.getPai()); // sempre vai testar o balanceamento do pai

        } else {

            this.raiz = atual; // senão atual passa a ser a raiz

        }

    } // final método avaliaBalanceamento

    // calcular o indicador B de um nó
    private void calcBalanceamento (No no) {

        no.setB(altura(no.getDir()) - altura(no.getEsq()));

    } // final método calcBalanceamento

    // calcula a altura da árvore
    private long altura (No atual) {

        if (atual == null) { // se o nó está vazio sempre retorna -1

            return -1;
        
        }

        if ((atual.getEsq() == null) && (atual.getDir() == null)) {

            return 0;

        } else {

            if (atual.getEsq() == null) {

                return 1 + altura(atual.getDir());

            } else {

                if (atual.getDir() == null) {

                    return 1 + altura(atual.getEsq());

                } else {

                    return 1 + Math.max(altura(atual.getEsq()), altura(atual.getDir()));

                }

            }

        }

    } // final método altura

    // realizar rotação à esquerda
    private No rotacaoEsq (No inicial) {

        No dir = inicial.getDir(); // salva apontamento do novo pai após rotação
        dir.setPai(inicial.getPai());
        inicial.setDir(dir.getEsq()); // Neto esquerdo do filho direito passa a ser filho direito

        if (inicial.getDir() != null) {

            inicial.getDir().setPai(inicial);

        }

        dir.setEsq(inicial); // filho esquerdo passa a ser pai
        inicial.setPai(dir);

        if (dir.getPai() != null) { // acerta os apontamentos do novo pai

            if (dir.getPai().getDir() == inicial) {

                dir.getPai().setDir(dir);

            } else if (dir.getPai().getEsq() == inicial) {

                dir.getPai().setEsq(dir);

            }

        }

        calcBalanceamento(inicial); // calcula os novos indicadores de balanceamento
        calcBalanceamento(dir);
        return dir;

    } // final método rotação esquerda

    // realizar rotação à direita
    private No rotacaoDir (No inicial) {

        No esq = inicial.getEsq(); // salva apontamento do novo pai após rotação
        esq.setPai(inicial.getPai());
        inicial.setEsq(esq.getDir()); // Neto direito do filho esquerdo passa a ser filho esquerdo

        if (inicial.getEsq() != null) {

            inicial.getEsq().setPai(inicial);

        }

        esq.setDir(inicial); // filho esquerdo passa a ser pai
        inicial.setPai(esq);

        if (esq.getPai() != null) { // acerta os apontamentos do novo pai

            if (esq.getPai().getDir() == inicial) {

                esq.getPai().setDir(esq);

            } else if (esq.getPai().getEsq() == inicial) {

                esq.getPai().setEsq(esq);

            }

        }

        calcBalanceamento(inicial);
        // calcula os novos indicadores de balanceamento
        calcBalanceamento(esq);
        return esq;

    } // final método rotação direita

    // realizar dupla rotação à direita
    private No duplaRotacaoDir (No inicial) {

        // rotaciona o filho esquerdo para a esquerda
        inicial.setEsq(rotacaoEsq(inicial.getEsq()));
        return rotacaoDir(inicial); // e depois rotaciona a árvore à direita

    } // final método dupla rotação direita
    
    // realizar dupla rotação à esqueda
    private No duplaRotacaoEsq (No inicial) {

        inicial.setDir(rotacaoDir(inicial.getDir())); // rotaciona o filho direito para a direita
        return rotacaoEsq(inicial); // e depois rotaciona a árvore à esquerda

    } // final método dupla rotação esquerda

}
