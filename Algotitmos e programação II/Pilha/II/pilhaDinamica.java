import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class pilhaDinamica {

    private List dados = new ArrayList();

    public boolean ehVazia () {

        return this.dados.isEmpty();

    }

    public int topo () {

        return (int) this.dados.get(this.dados.size() - 1);

    }
    
    public int tamanho () {

        return this.dados.size();

    }

    public void empilha (int numero) {

        this.dados.add(numero);

    }

    public int desempilha () {

        if (this.ehVazia()) {

            throw new RuntimeException("A pilha está vazia");

        }

        return (int) this.dados.remove(this.dados.size() - 1);

    }

    @Override
    public String toString() {

        return this.dados.toString();

    }

}
