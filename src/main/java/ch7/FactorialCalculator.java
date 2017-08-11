package ch7;



import java.math.BigInteger;

/**
 * Created by Alex on 10/08/2017.
 */
public class FactorialCalculator {

    public static BigInteger factorialNoRecursion(Integer n){
        if(n <= 1){
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for(int i = 2; i<=n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
