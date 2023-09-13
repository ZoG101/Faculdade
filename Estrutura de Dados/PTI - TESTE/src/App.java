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
        a.insere(11,null);

        System.out.println();
        System.out.println("Quantidade de esquerdas festivas: " + a.calcEsquerdaFestiva());
        System.out.println();
        System.out.println("Altura: " + a.alturaArvore());

        //Imprime a árvore com níveis de recuo de margem crescentes.
        a.imprimeArvoreFormatada();
        System.out.println();
        //Imprime a árvore com níveis de recuo de margem baseados no ID.
        a.imprimeArvoreFormatadaID();

    }

}
