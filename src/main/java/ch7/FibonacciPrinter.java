package ch7;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 09/08/2017.
 */
public class FibonacciPrinter {

    private static Map<Integer, Integer> cache;

    static {
        cache = new HashMap<Integer, Integer>();
        cache.put(0, 0);
        cache.put(1,1);
    }

    public static String fibonacciCounter(int n){
        StringBuilder outBuilder = new StringBuilder();
        for(int i = 0; i<=n; i++){
            int fib = fibonacci(i);
            cache.put(i, fib);
            outBuilder.append(String.format("Fiboonacci(%d)=%d;\n", i, fib));
        }
        return outBuilder.toString();
    }

    private static int fibonacci(int n){
        if(cache.containsKey(n)){
            System.out.println("Cache hit!!");
            return cache.get(n);
        }
        System.out.println("Non Cache HIT...");
        if(n < 2){
            return 1;
        }
        return fibonacci(n-2)+fibonacci(n-1);
    }
}
