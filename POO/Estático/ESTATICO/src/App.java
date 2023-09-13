import ui.Banco;

public class App {

    public static void main(String[] args) {

        Banco banco = new Banco(1L, "Brasil", "Maria José");
        System.out.println(banco.getNUMERO());

    }

}
