package ch7;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 09/08/2017.
 */
public class FizzBuffPrinter {

    private static List<Integer> DIVISORS = Arrays.asList(3, 5);
    private static List<String> PRINT_DIVISOR = Arrays.asList("Fizz", "Buzz");

    public static void print(int n) {
        //Conosciamo la dimensione che non cabierà mai per cui usiamo l'array list
        List<String> out = new ArrayList<String>(n+1);
        for (int i = 1; i <= n; i++) {
            System.out.println(toOutString(i));
        }
    }

    private static String toOutString(int i) {
        StringBuilder outBuilder = new StringBuilder();
        for (int index = 0; index < DIVISORS.size(); index++) {
            if(i % DIVISORS.get(index) == 0)
                outBuilder.append(PRINT_DIVISOR.get(index));
        }
        String out = outBuilder.toString();
        return out.isEmpty() ? String.valueOf(i) : out;
    }
}
