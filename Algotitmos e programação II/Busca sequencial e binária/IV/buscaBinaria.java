public class buscaBinaria {
    
    int busca (int[] vetor, int valorProcurado) {

        int inicio = 0;  
        int fim = vetor.length - 1;    

        while (inicio < fim) {

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
