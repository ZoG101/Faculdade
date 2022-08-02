public class produtorio {
 
    public static int recursivo (int[] vetor, int tamanho) {

        if (tamanho > 0) return vetor[tamanho - 1] * recursivo(vetor, tamanho - 1);

        return 1;

    }

    public static int recursivoBinario (int[] vetor, int inicio, int fim) {

        if (inicio > fim) return 1;
        if (inicio == fim) return vetor[inicio];

        int meio = (inicio + fim) / 2;

        return recursivoBinario(vetor, inicio, meio) * recursivoBinario(vetor, meio + 1, fim);

    }

    public static void main (String[] args) {

        int v[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 

        System.out.println(recursivo(v, v.length));
        System.out.println(recursivoBinario(v, 0, 8));

    }

}
