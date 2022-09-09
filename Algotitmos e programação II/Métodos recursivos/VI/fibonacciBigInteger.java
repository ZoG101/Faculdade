import java.math.BigInteger;

public class fibonacciBigInteger {
    
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger fibonacci (BigInteger n) {

        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return n;

        return fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(TWO)));

    }

    public static void main (String[] args) {

        for (int i = 0; i <= 10; i++) {

            System.out.printf("Fibonacci(%d) => %d\n", i, fibonacci(BigInteger.valueOf(i)));

        }

    }

}
