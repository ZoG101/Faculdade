import java.math.BigInteger;

public class funcaoFatorial {

    public static BigInteger fatorial (BigInteger n) {

        if (n.compareTo(BigInteger.ONE) <= 0) return BigInteger.ONE;

        return n.multiply(fatorial(n.subtract(BigInteger.ONE)));

    }

    public static void main (String[] args) {

        for (int n = 0; n <= 5; n++) {

            System.out.printf("%d! => %d\n", n, fatorial(BigInteger.valueOf(n)));

        }

    }
    
}
