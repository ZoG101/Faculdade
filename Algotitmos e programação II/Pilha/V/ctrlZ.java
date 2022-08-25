import java.util.Scanner;
import java.util.Stack;

public class ctrlZ {
  
    public static void main (String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            Stack<String> pilha = new Stack<String>();

            int opcao = 0;
            String texto = "";

            while (opcao != 3) {

                System.out.println ("Digite: \n1-para inserir texto;" + "\n2-Para desfazer; \n3-Para encerrar.");

                opcao = scan.nextInt();

                if (opcao == 1) {

                    System.out.println("Entre com o texto: ");

                    String temp = scan.next() + " ";

                    pilha.push(temp);

                    texto += temp;

                } else if (opcao == 2) {

                    System.out.println("Desfazendo... ");

                    texto = texto.replace(pilha.pop(), "");

                }

                System.out.println(texto);
                
            }

        }

    }
    
}
