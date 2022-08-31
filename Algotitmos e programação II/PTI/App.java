import java.util.Arrays;
import java.util.Scanner;

public class App {

    static Scanner entrada = new Scanner(System.in);

    public static iniciaVetor novoVetor (iniciaVetor dados) {

        String desejo = "n";

        if (dados.vetorIniciado) {

            System.out.println("\nJá existe um vetor iniciado. Caso você prossiga, o vetor anterior será deletado e um novo será criado. Deseja continuar? (s/n)\n");

            desejo = entrada.nextLine();

            if (((!desejo.equals("s")) && (!desejo.equals("S"))) && ((!desejo.equals("N")) && (!desejo.equals("n")))) throw new RuntimeException("\nERRO: Essa não é uma das opções. Tente novamente!");

        }

        if ((desejo.equals("s")) || (desejo.equals("S"))) {

            dados = new iniciaVetor();

        }

        return dados;

    }

    public static void main(String[] args) {

        String menu;
        iniciaVetor dados = new iniciaVetor();

        do{

            System.out.println("\n1.Criar novo vetor;\n2.Ordenar vetor;\n3.Calcular a diferença entre dois elementos no vetor;\n4.Verificar ordenação do vetor;\n5.Sair.\n");

            menu = entrada.nextLine();

            switch (menu) {

                case "1":

                    try{

                        dados = novoVetor(dados);

                    } catch (Exception e) {

                        System.err.println(e.getMessage());

                    }

                break;

                case "2":

                    try {

                        dados.ordenar();

                    } catch (Exception e) {

                        System.err.println(e.getMessage());

                    }

                    System.out.println(dados);

                break;

                case "3":

                    try {

                        dados.calculoDeDiferenca();

                    } catch (Exception e) {

                        System.err.println(e.getMessage());

                    }

                break;

                case "4":

                    try {

                        dados.crescenteOuDecrescente();

                    } catch (Exception e) {

                        System.err.println(e.getMessage());

                    }

                    System.out.println(dados);

                break;

            }

        } while (!menu.equals("5"));

    }

}

class iniciaVetor {

    static Scanner entrada = new Scanner(System.in);

    public boolean vetorIniciado = false;
    public boolean ordenadoDeFormaCrescente = false;
    public boolean ordenadoDeFormaDecrescente = false; 
    private int[] dados;
    private int capacidade;
    private int tamanho;

    public iniciaVetor (int n) {

        n = criarVetor();

        this.tamanho = 0;
        this.capacidade = n;
        this.dados = new int [this.capacidade];
        this.vetorIniciado = true;

        for (int i = 0; i < getCapacidade(); i++) {

            System.out.println("\nAdicione o " + (i + 1) + "º número: ");

            int numeroAAdicionar = entrada.nextInt();

            adicionaItem(numeroAAdicionar);

            System.out.println(Arrays.toString(this.dados));

        }

    }

    public iniciaVetor () {

        this(10);

    }

    public int getCapacidade () {

        return this.capacidade;

    }

    public boolean ehCrescente () {

        return ordenadoDeFormaCrescente;

    }

    public boolean ehDecrescente () {

        return ordenadoDeFormaDecrescente;

    }

    private boolean limite () {

        return this.tamanho == this.capacidade;

    }

    public void calculoDeDiferenca () {

        int i = 0;
        int x = 0;
        int y = 0;
        int numeroBuscado = 0;

        System.out.println("\n1.Localizar por índice;\n2.Localizar por valor (Necessita passar por ordenação primeiro).");

        int opcao = entrada.nextInt();

        if ((opcao != 1) && (opcao != 2)) throw new RuntimeException("ERRO: Essa opção não existe. Tente novamente.");
        if ((!ehCrescente()) && (!ehDecrescente())) throw new RuntimeException("ERRO: O vetor em questão não passou por ordenação. Por favor, primeiro ordene-o e depois tente novamente.");

        switch (opcao) {

            case 1:

                System.out.println("\n" + Arrays.toString(this.dados));
                
                System.out.println("\nDigite o primeiro número:\n");

                i = entrada.nextInt();

                if ((i < 0) || (i > (this.capacidade))) throw new RuntimeException("ERRO: O número digitado é negativo ou está fora do limite do vetor que é: " + this.capacidade);

                x = this.dados[i - 1];

                System.out.println("Digite o segundo número:\n");

                i = entrada.nextInt();

                if ((i < 0) || (i > (this.capacidade))) throw new RuntimeException("ERRO: O número digitado é negativo ou está fora do limite do vetor que é: " + this.capacidade);

                y = this.dados[i - 1];

            break;

            case 2:

                if (ehCrescente()){
            
                    System.out.println("Digite o primeiro número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaCrescenete.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("ERRO: A busca do primeiro número não encontrou o número inserido: " + numeroBuscado);

                    x = this.dados[i];

                    System.out.println("Digite o segundo número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaCrescenete.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("ERRO: A busca do segundo número não encontrou o número inserido: " + numeroBuscado);

                    y = this.dados[i];

                } else if(ehDecrescente()){

                    System.out.println("Digite o primeiro número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaDecrescente.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("ERRO: A busca do primeiro número não encontrou o número inserido: " + numeroBuscado);

                    x = this.dados[i];

                    System.out.println("Digite o segundo número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaDecrescente.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("ERRO: A busca do segundo número não encontrou o número inserido: " + numeroBuscado);

                    y = this.dados[i];

                }

            break;

        }

        System.out.println("O resutado da diferença entre " + x + " e " + y + " é: " + (x - y));

    }

    public void crescenteOuDecrescente () {

        if ((!this.ehCrescente()) && (!this.ehDecrescente())) throw new RuntimeException("\nERROR: O vetor em questão ainda não passou pela ordenação");

        if (this.ehCrescente()) {

            System.out.println("\nO vetor em questão é crescente");

        } else if (this.ehDecrescente()) {

            System.out.println("\nO vetor em questão é decrescente");

        }

    }

    public void adicionaItem (int numero) {

        if (this.limite()) {

            throw new RuntimeException("ERRO: A unidade de dados está cheia.");

        }

        this.dados[tamanho++] = numero;

    }

    private int criarVetor () {

        System.out.println("\nDigite o tamanho do vetor:\n");

        int tamanho = entrada.nextInt();

        return tamanho;

    }

    public int[] ordenar () {

        System.out.println("\n1.Ordenar de forma crescente;\n2.Ordenar de forma decrescente;");

        Integer ordenar = entrada.nextInt();

        if (((ordenar != 1) && (ordenar != 2))) throw new RuntimeException("\nERRO: Nenhuma dessas opções existe. Tente novamente.");

        switch (ordenar) {

            case 1:

                quickSortCrescente.sort(this.dados, 0, this.dados.length - 1);

                ordenadoDeFormaCrescente = true;
                ordenadoDeFormaDecrescente = false;
            
            break;

            case 2:

                quickSortDecrescente.sort(this.dados, 0, this.dados.length - 1);

                ordenadoDeFormaDecrescente = true;
                ordenadoDeFormaCrescente = false;
            
            break;

        }

        return this.dados;

    }

    @Override
    public String toString () {

        return Arrays.toString(this.dados);

    }

}

class quickSortCrescente {
    
    public static void sort (int[] x, int inicio, int fim) {

        if (inicio < fim) {

            int pivot = divide(x, inicio, fim);

            sort(x, inicio, pivot - 1);
            sort(x, pivot + 1, fim);

        }

    }

    public static int divide (int[] x, int inicio, int fim) {

        int pivot = x[inicio];
        int postPivot = inicio;

        for (int i = inicio + 1; i <= fim; i++) {

            if (x[i] < pivot) {

                x[postPivot] = x[i];
                x[i] = x[postPivot + 1];

                postPivot++;

            }

        }

        x[postPivot] = pivot;

        return postPivot;

    }

}

class quickSortDecrescente {
    
    public static void sort (int[] x, int inicio, int fim) {

        if (inicio < fim) {

            int pivot = divide(x, inicio, fim);

            sort(x, inicio, pivot - 1);
            sort(x, pivot + 1, fim);

        }

    }

    public static int divide (int[] x, int inicio, int fim) {

        int pivot = x[inicio];
        int postPivot = inicio;

        for (int i = inicio + 1; i <= fim; i++) {

            if (x[i] > pivot) {

                x[postPivot] = x[i];
                x[i] = x[postPivot + 1];

                postPivot++;

            }

        }

        x[postPivot] = pivot;

        return postPivot;

    }

}

class buscaBinariaCrescenete {
    
    public static int busca (int[] vetor, int valorProcurado) {

        int inicio = 0;  
        int fim = vetor.length - 1;    

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;

            if (vetor[meio] > valorProcurado){

                fim = meio - 1;   

            } else if (vetor[meio] < valorProcurado) {

                inicio = meio + 1;

            } else {

                return meio;

            }

        }

        return - 1;

    }

}

class buscaBinariaDecrescente {
    
    public static int busca (int[] vetor, int valorProcurado) {

        int inicio = 0;  
        int fim = vetor.length - 1;    

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;

            if (vetor[meio] < valorProcurado){

                fim = meio - 1;   

            } else if (vetor[meio] > valorProcurado) {

                inicio = meio + 1;

            } else {

                return meio;

            }

        }

        return - 1;

    }

}
