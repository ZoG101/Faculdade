package cg;

/**
 * Classe {@code coordenada} para armazenar, manipular,
 * comparar e recuperar os valores {@value x} e {@value y}
 * que representam a coordenada.
 *
 * @author  Davi Campolina Leite Morato
 * @see     cg
 * @version   1.0
 */
public class Coordenada {

    private int x;
    private int y;

    /**
     * Construtor que recebe dois valores inteiros
     * como os valores dos atributos x e y respectivamente.
     * @param x
     * @param y
     */
    public Coordenada (int x, int y) {

        this.x = x;
        this.y = y;

    }

    /**
     * Construtor que inicializa os atributos da classe (x e y) 
     * com o valor zero por padrão. 
     * */
    public Coordenada () {

        this(0, 0);

    }

    /**
     * Retorna o valor de x para a coordenada.
     * @return Valor de {@code x}.
     */
    public int getX () {

        return x;

    }

    /**
     * Insere um novo valor para x.
     * @param x
     */
    public void setX (int x) {

        this.x = x;

    }

    /**
     * Retorna o valor de y para a coordenada.
     * @return Valor de {@code y}.
     */
    public int getY () {

        return y;

    }

    /**
     * Insere um novo valor para y.
     * @param x
     */
    public void setY (int y) {

        this.y = y;

    }

    /**
     * Verifica a igualdade de dois pontos comparando suas coordenadas.
     * 
     * @param outra
     * @return {@code true} Se este objeto for o mesmo que foi passado por
     *          parâmetro; {@code false} Se for o oposto.
     */
    public boolean verificaIgualdade (Coordenada outra) {

        return ((this.x == outra.getX()) && (this.y == outra.getY()));

    }

    /**
     * Calcula a distância entre dois pontos recebendo como parâmetro
     * uma outra coordenada.
     * 
     * @param outroPonto
     * @return {@code Double} distancia
     */
    public double distancia (Coordenada outroPonto) {

        double distanciaX = Math.pow((outroPonto.x - this.x), 2);
        double distanciaY = Math.pow((outroPonto.y - this.y), 2);
        double distancia = Math.sqrt(distanciaX + distanciaY);
        return distancia;

    }

    /**
     * Sobreescrita do método equals da classe determinando que
     * duas instâncias de objetos do tipo coordenadas são iguais
     * caso seus pontos x e y seja iguais.
     * 
     * @param obj a referencia de objeto com a qual se deve comparar.
     * @return {@code true} Se este objeto for o mesmo que foi passado por
     *          parâmetro; {@code false} Se for o oposto.
     */
    @Override
    public boolean equals(Object obj) {
        
        if (!(obj instanceof Coordenada)) throw new IllegalArgumentException("Erro: O argumento passado não é uma instância de uma 'Coordenada'.");

        Coordenada outra = (Coordenada) obj;
        
        return ((this.x == outra.getX()) && (this.y == outra.getY()));

    }
    
}
