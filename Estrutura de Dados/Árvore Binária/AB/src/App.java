import data.ArvoreBinaria;

public class App {

    public static void main(String[] args) throws Exception {

        ArvoreBinaria a = new ArvoreBinaria(); // cria a árvore binária
        a.insere(10,"A");
        a.insere(5,"B"); 
        a.insere(15,"C"); 
        a.insere(2,"D");
        a.insere(7,"E");
        a.insere(12,"F"); 
        a.insere(6,"G");
        a.insere(8,"H");

        System.out.println("Pré-fixado:");
        a.imprimeElementosArvorePreFix();
        System.out.println("\nPós-fixado");
        a.imprimeElementosArvorePosFix();   
        System.out.println("\nSim-fixado");
        a.imprimeElementosArvoreSimFix();
        System.out.println("Altura: " + a.alturaArvore());

        //representação de notação polonesa reversa(infix) 
        //através da árvore binária.
        ArvoreBinaria b = new ArvoreBinaria();
        b.insere(20, "-");
        b.insere(10, "x");
        b.insere(5, "+");
        b.insere(1, "5");
        b.insere(8, "3");
        b.insere(15, "7");
        b.insere(30, "/");
        b.insere(25, "-");
        b.insere(22, "8");
        b.insere(28, "2");
        b.insere(33, "2");

        System.out.println();
        b.imprimeElementosArvorePosFix();
        System.out.println("Altura: " + b.alturaArvore());

    }

}
