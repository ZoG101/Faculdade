package ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ServicoLocal {

    List<Livro> buscaLivros(Categoria categoria) throws Exception;
    
}
