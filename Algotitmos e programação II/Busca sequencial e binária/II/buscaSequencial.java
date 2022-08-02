import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class buscaSequencial {

    ArrayList<Integer> dados = new ArrayList<>();
    Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
    Map<Integer, Integer> mapa2 = new HashMap<Integer, Integer>();

    public buscaSequencial(){

        Random random = new Random();

        for (int i = 0; i <= 1000; i++) {

            dados.add(random.nextInt(1000));

        }

        Collections.sort(dados);

        for (int i = 100; i < 1000; i+=100) {

            mapa.put(i, dados.get(i));

        }

        for (int i = 2; i <= 5; i+=2) {

            mapa2.put(i * 100, mapa.get(i * 100));

        }

    }

    public int buscaTabela(int elemento) {

        for (Integer chave : mapa.keySet()) {

            if (mapa.get(chave) > elemento) {

                return chave;
                
            }

        }

        return -1;

    }

    public int buscaTabela2 (int elemento) {

        for (Integer chave : mapa2.keySet()) {

            if (mapa2.get(chave) > elemento) {

                return chave;

            }

        }

        return -1;

    }

    public int busca (int elemento) {

        int posicaoMaxima = buscaTabela(elemento);

        if (posicaoMaxima < 0) return -1;

        for (int i = (posicaoMaxima - 100); i < posicaoMaxima; i++) {

            if(dados.get(i) == elemento) {

                return i;

            }

        }

        return -1;

    }

    public int busca2 (int elemento) {

        int posicaoMaxima = buscaTabela2(elemento);

        if (posicaoMaxima < 0) return -1;

        for (int i = (posicaoMaxima - 200); i <= posicaoMaxima; i+=100) {

            if (mapa.get(i) > elemento) {

                return i;

            }

        }

        return -1;

    }

}