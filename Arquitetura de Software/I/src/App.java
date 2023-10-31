import metodos.ObjetoSingleton;

public class App {

    public static void main(String[] args) throws Exception {

        ObjetoSingleton obj1 = ObjetoSingleton.getInstance();
        ObjetoSingleton obj2 = ObjetoSingleton.getInstance();

        if (obj1 == obj2) System.out.println("Possuem a mesma instância.");

    }
    
}
