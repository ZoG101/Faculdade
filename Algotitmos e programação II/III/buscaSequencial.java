import java.util.ArrayList;

public class buscaSequencial {
    
    ArrayList<Integer> dados = new ArrayList<Integer>();

    public int busca (int elemento) {

        for (int i = 0; i < dados.size(); i++) {

            if ( dados.get(i) == elemento) {

                if (i != 0) troca(i);

                return i;

            }

        }

        return -1;

    }

    public void troca (int posicao) {

        int aux = dados.get(posicao - 1);
        
        dados.set(posicao - 1, dados.get(posicao));
        dados.set(posicao, aux); 

    }

}
