import cg.Coordenada;

public class App {

    public static void main(String[] args) {

        Coordenada a = new Coordenada(5, 10);
        Coordenada b = new Coordenada(6, 20);
        Coordenada igual1 = new Coordenada(5, 5);
        Coordenada igual2 = new Coordenada(5, 5);

        System.out.println(a.distancia(b));
        System.out.println(igual1.distancia(igual2));

        System.out.println(b.verificaIgualdade(a));
        System.out.println(igual1.verificaIgualdade(igual2));

        System.out.println(a.equals(b));
        System.out.println(igual1.equals(igual2));

    }

}
