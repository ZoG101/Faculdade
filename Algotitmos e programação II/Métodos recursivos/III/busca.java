public class busca {

    public static int sequencial (int[] vetor, int valorProcurado, int indice) {

        if (indice >= vetor.length) return -1;
        if (vetor[indice] == valorProcurado) return indice;

        return sequencial(vetor, valorProcurado, indice + 1);

    }

    public static int binario (int[] vetor, int valorProcurado, int inicio, int fim) {

        if (inicio > fim) return -1;

        int meio = (inicio + fim) / 2;

        if (vetor[meio] == valorProcurado) return meio;
        if (vetor[meio] < valorProcurado) return binario(vetor, valorProcurado, meio + 1, fim);
        if (vetor[meio] > valorProcurado) return binario(vetor, valorProcurado, inicio, meio - 1);

        return -1;

    }

    public static void main (String[] args) {

        int v [] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(sequencial(v, 5, 0));
        System.out.println(binario(v, 5, (v.length - v.length), v.length));

    }
    
}
