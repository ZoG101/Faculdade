import java.util.Arrays;
import java.util.Scanner;

/* 
 * A classe "App" é a classe principal onde existe a inicialização do vetor, inserção dos valores,
 * menu onde os métodos são chamados, o main, 
 * e um método chamado "novoVetor" para caso o usuário queira iniciar um novo vetor sem reiniciar o programa.
*/
public class App {

    //Inicialização do "Scanner" para input de dados pelo console.
    static Scanner entrada = new Scanner(System.in);

    //Método para reiniciar o vetor.
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

    /*
     * Método main onde o primeiro vetor é instanciado, preenchido e onde 
     * é criado um pequeno e simples menu para o usuário poder manipular o vetor.
     */
    public static void main(String[] args) {

        String menu;
        iniciaVetor dados = new iniciaVetor();

        do{

            //Print das opções disponíveis no menu.
            System.out.println("\n1.Criar novo vetor;\n2.Ordenar vetor;\n3.Calcular a diferença entre dois elementos no vetor;\n4.Verificar ordenação do vetor;\n5.Sair.\n");

            //Opção desejada é inserida.
            menu = entrada.nextLine();

            //Switch-Case para verificação da escolha do usuário e chamada dos repectivos métodos.
            switch (menu) {

                //Inicia um novo vetor caso o usuário deseje.
                case "1":

                    try{

                        dados = novoVetor(dados);

                    } catch (Exception e) {

                        System.err.println(e.getMessage());

                    }

                break;

                //Ordena o vetor de forma crescente ou decrescente.
                case "2":

                    try {

                        dados.ordenar();

                    } catch (Exception e) {

                        System.err.println(e.getMessage());

                    }

                    System.out.println(dados);

                break;

                /*
                * calcula a maior diferença dentro do vetor
                * ou a diferença de dois números selecionados pelo usuário por ídice ou por busca do próprio valor.
                */
                case "3":

                    try {

                        dados.calculoDeDiferenca();

                    } catch (Exception e) {

                        System.err.println(e.getMessage());

                    }

                break;

                /*
                 * Verifica se o vetor é ordenado de forma crescente e retor "true" se verdadeiro
                 * ou "false" caso não seja, também é possível verificar qual a ordenação 
                 * do vetor você escolheu (apenas caso você tenha ordenado).
                 */
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

//classe para inicializar, preecher e gerenciar o vetor.
class iniciaVetor {

    //Inicializa um "Scanner" para os menus interno que existem nas funções da classe.
    static Scanner entrada = new Scanner(System.in);

    //inicialização das variáveis de controle e do vetor em si.
    public boolean vetorIniciado = false;
    public boolean ordenadoDeFormaCrescente = false;
    public boolean ordenadoDeFormaDecrescente = false; 
    private int[] dados;
    private int capacidade;
    private int tamanho;

    //Construtor principal da classe o vetor é criado com o tamanho determinado palo usuário e preenchido pelo mesmo.
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

    /* 
     * Classe construtora de suporte para caso a primeira falhe 
     * o vetor ainda poderá ser inicializado com o tamanho padrão de 10 itens.
    */
    public iniciaVetor () {

        this(10);

    }

    //Verificar a capacidade do vetor para obter mais controle.
    private int getCapacidade () {

        return this.capacidade;

    }

    //Verifica se o vetor foi ordenado de forma crescente.
    private boolean ehCrescente () {

        return ordenadoDeFormaCrescente;

    }

    //Verifica se o vetor foi ordenado de forma decrescente.
    private boolean ehDecrescente () {

        return ordenadoDeFormaDecrescente;

    }

    //Verifica o limite do vetor e retorna se ele está no limite ou não.
    private boolean limite () {

        return this.tamanho == this.capacidade;

    }

    /*
     * Verifica se o vetor, independente de ter sido ordenado ou não, é crescente ou não.
     * E retorna "true" caso seja e "false" caso não seja.
     */
    private boolean verificaCrescente () {

        boolean verificado = false;
        int cont = 0;

        for (int i = 0; i < getCapacidade() - 1; i++) {

            if (this.dados[i] <= this.dados[i + 1]) cont++;

        }

        if (cont == getCapacidade() - 1) verificado = true;

        return verificado;

    }

    /*
     * Calcula a diferença entre dois números no vetor.
     * O usuário tem algumas formas de fazer isso, ele pode localizar os números no vetor
     * pelo índice ou por uma busca do próprio valor (o que exige que o vetor tenha passado por ordenação).
     * Ou o usuário pode calcular a maior diferença dentro do vetor (não necessita de estar ordenado).
     * Os erros são tratados e bem descritos.
     */
    public void calculoDeDiferenca () {

        int i = 0;
        int x = 0;
        int y = 0;
        int numeroBuscado = 0;

        System.out.println("\n1.Localizar por índice;\n2.Localizar por valor (Necessita passar por ordenação primeiro);\n3.Calcular a maior diferença.\n");

        int opcao = entrada.nextInt();

        if ((opcao != 1) && (opcao != 2) && (opcao != 3)) throw new RuntimeException("\nERRO: Essa opção não existe. Tente novamente.");
        if ((opcao == 2) && (!ehCrescente()) && (!ehDecrescente())) throw new RuntimeException("\nERRO: O vetor em questão não passou por ordenação. Por favor, primeiro ordene-o e depois tente novamente.");

        switch (opcao) {

            case 1:

                System.out.println("\n" + Arrays.toString(this.dados));
                
                System.out.println("\nDigite o primeiro número:\n");

                i = entrada.nextInt();

                if ((i < 0) || (i > (this.capacidade))) throw new RuntimeException("\nERRO: O número digitado é negativo ou está fora do limite do vetor que é: " + this.capacidade);

                x = this.dados[i - 1];

                System.out.println("\nDigite o segundo número:\n");

                i = entrada.nextInt();

                if ((i < 0) || (i > (this.capacidade))) throw new RuntimeException("ERRO: O número digitado é negativo ou está fora do limite do vetor que é: " + this.capacidade);

                y = this.dados[i - 1];

            break;

            case 2:

                if (ehCrescente()){
            
                    System.out.println("\nDigite o primeiro número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaCrescenete.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("ERRO: A busca do primeiro número não encontrou o número inserido: " + numeroBuscado);

                    x = this.dados[i];

                    System.out.println("\nDigite o segundo número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaCrescenete.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("\nERRO: A busca do segundo número não encontrou o número inserido: " + numeroBuscado);

                    y = this.dados[i];

                } else if(ehDecrescente()){

                    System.out.println("\nDigite o primeiro número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaDecrescente.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("\nERRO: A busca do primeiro número não encontrou o número inserido: " + numeroBuscado);

                    x = this.dados[i];

                    System.out.println("\nDigite o segundo número:\n");

                    numeroBuscado = entrada.nextInt();
                    i = buscaBinariaDecrescente.busca(this.dados, numeroBuscado);

                    if (i == -1) throw new RuntimeException("\nERRO: A busca do segundo número não encontrou o número inserido: " + numeroBuscado);

                    y = this.dados[i];

                }

            break;

            case 3:

                if (ehCrescente()) {

                    System.out.println("\nA maior diferença existente dentro do vetor é entre o número " + this.dados[this.capacidade - 1] + " e " + this.dados[0] + " e o cáuculo de sua diferença gera o resultado: " + (this.dados[this.capacidade - 1] - this.dados[0]));

                } else {

                    int[] aux = this.dados;

                    quickSortCrescente.sort(aux, 0, aux.length - 1);

                    System.out.println("\nA maior diferença existente dentro do vetor é entre o número " + aux[this.capacidade - 1] + " e " + aux[0] + " e o cáuculo de sua diferença gera o resultado: " + (aux[this.capacidade - 1] - aux[0]));

                }

            break;

        }

        if (opcao != 3) System.out.println("\nO resutado da diferença entre " + x + " e " + y + " é: " + (x - y));

    }

    /*
     * Verifica se o vetor é crescente ou decrescente.
     * Para isso o usuário tem algumas opções, o usuário pode apenas verificar
     * se o vetor é crescente e obter "true" ou "false" (não necessita de ordenar o vetor);
     * ou o usuário pode verificar como ele escolheu ordená-lo
     * e obter uma resposta mais precisa (necesseta de passar pela opção de ordenação).
     * Aqui as exceções também são tratadas.
     */
    public void crescenteOuDecrescente () {

        System.out.println("\n1.Verificar apenas se é crescente;\n2.Verificar como você o ordenou (necessita ter sido ordenado primeiro).\n");

        int opcaoOrdem = entrada.nextInt();

        if ((opcaoOrdem != 1) && (opcaoOrdem != 2)) throw new RuntimeException("\nERROR: Essa opção não existe. Tente novamente.");

        switch (opcaoOrdem) {

            case 1:

                boolean validado = verificaCrescente();

                if (validado) {

                    System.out.println("\nA verificação retornou 'true', ou seja, o vetor é crescente.");

                } else {

                    System.out.println("\nA verificação retornou 'false', ou seja, o vetor não é crescente.");

                }

            break;

            case 2:

                if ((!this.ehCrescente()) && (!this.ehDecrescente())) throw new RuntimeException("\nERROR: O vetor em questão ainda não passou pela ordenação");

                if (this.ehCrescente()) {

                    System.out.println("\nO vetor em questão é crescente");
        
                } else if (this.ehDecrescente()) {
        
                    System.out.println("\nO vetor em questão é decrescente");
        
                }

            break;

        }

        

    }

    /*
     * Função responsável por preencher o vetor 
     * e controlar o limite para que não possa ser
     * adicionado além do limite do vetor.
     * Aqui a exceção do limite é tratada também.
     */
    public void adicionaItem (int numero) {

        if (this.limite()) {

            throw new RuntimeException("\nERRO: A unidade de dados está cheia.");

        }

        this.dados[tamanho++] = numero;

    }

    /*
     * Função responsável por instanciar o tamanho máximo do vetor
     * para a sua inicialização.
     */
    private int criarVetor () {

        System.out.println("\nDigite o tamanho do vetor:\n");

        int tamanho = entrada.nextInt();

        return tamanho;

    }

    /*
     * Função responsável por ordenar o vetor da maneira que o usuário escolher.
     * Aqui é possível ordenar de forma crescente ou decrescente.
     * E o vetor é retornado de forma já ordenada.
     * Também modifica as variáveis de controle para saber como o usuário escolheu ordenar.
     */
    public int[] ordenar () {

        System.out.println("\n1.Ordenar de forma crescente;\n2.Ordenar de forma decrescente;\n");

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

/*
 * Classe de ordenação utilizando o método "quick sort" para ordenar de forma eficiênte.
 * Neste caso, ele ordena de forma crescente.
 */
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

/*
 * Classe de ordenação utilizando o método "quick sort" para ordenar de forma eficiênte.
 * Neste caso, ele ordena de forma decrescente.
 */
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

/*
 * Classe de busca para buscar os elementos que o usuário quiser dentro do vetor
 * utilizando o método de busca binária para vetores crescentes.
 */
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

/*
 * Classe de busca para buscar os elementos que o usuário quiser dentro do vetor
 * utilizando o método de busca binária para vetores decrescentes.
 */
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
