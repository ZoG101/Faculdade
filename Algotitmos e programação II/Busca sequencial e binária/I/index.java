class MeuPrimeiroPrograma {

    public static int[] ordenarVetor(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[i] > vetor[j]) {
                    int aux = vetor[i];

                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }

            }

        }

        return vetor;

    }

    public static void main(String[] args) {

        int v [] = {2, 5, 7, 9, 10, 8, 92};

        int[] vetorOrdenado = ordenarVetor(v);

        for (int i = 0; i < v.length; i++) {

            System.out.print(vetorOrdenado[i] + ", ");

        }

    }

}