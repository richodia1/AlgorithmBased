package codility;

import java.math.BigInteger;

public class BigIntegerFactorialCalculation {
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
           // return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
    public static void main(String[] args) {

        System.out.println(factorial(new BigInteger("25")));
    }
}
