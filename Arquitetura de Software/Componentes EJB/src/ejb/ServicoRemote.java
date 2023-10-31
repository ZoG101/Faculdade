package ejb;

import javax.ejb.Remote;

@Remote
public interface ServicoRemote {

    void emprestaLivro(Livro livro);
    
}
