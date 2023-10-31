package metodos;

public class ObjetoSingleton {

    private static ObjetoSingleton INSTANCE;

    private ObjetoSingleton() {

        System.out.println("Objeto criado com sucesso!");

    }

    public static synchronized ObjetoSingleton getInstance() {

        if (INSTANCE == null) INSTANCE = new ObjetoSingleton();

        return INSTANCE;

    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        throw new CloneNotSupportedException();

    }
    
}
