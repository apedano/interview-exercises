package ch7;

import cmn.Commons;
import com.google.common.collect.Iterators;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 09/08/2017.
 */
public class AlgoritmTests {

    @Test
    public void fizzBuzzTest() {
        //Write an algorithm that prints all numbers between 1 and n, replacing multiples
        //of 3 with the String Fizz, multiples of 5 with Buzz, and multiples of 15 with FizzBuzz
        FizzBuffPrinter.print(100);
    }

    @Test
    public void fibonacciTest() {
        System.out.println(FibonacciPrinter.fibonacciCounter(30));
    }

    @Test
    public void factorialTests() {
        BigInteger fac = FactorialCalculator.factorialNoRecursion(100);
        System.out.println(String.format("Factorial of 100 = %d", fac));
    }

    @Test
    public void anagramFinderTest() {
        List<String> words = Arrays.asList("esedra", "casa", "sedera", "saca", "monitor", "sedare", "armonico", "famiglia", "alfa", "reseda", "fala", "falena", "aderse", "alfena", "nefala", "romantico");
        AnagramsFinder anagramsFinder = new AnagramsFinder(words);
        List<String> list1 = anagramsFinder.getAnagrams("casa");
        System.out.print("Anagrams of word: casa:");
        System.out.println(Commons.printList(list1, ","));
        List<String> list2 = anagramsFinder.getAnagrams("sedera");
        System.out.print("Anagrams of word: sedera:");
        System.out.println(Commons.printList(list2, ","));
        List<String> list3 = anagramsFinder.getAnagrams("monitor");
        System.out.print("Anagrams of word: monitor:");
        System.out.println(Commons.printList(list3, ","));
        List<String> list4 = anagramsFinder.getAnagrams("bicchiere");
        System.out.print("Anagrams of word: bicchiere:");
        System.out.println(Commons.printList(list4, ","));
    }

    @Test
    public void reverseStringTest(){
        String input = "casablanca";
        String reversed = StringReverser.reverse(input);
        System.out.println(reversed);
    }

    @Test
    public void reverseLinkedListRecursively(){
        LinkedList<Integer> input = new LinkedList<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        LinkedList<Integer> reversed = ListReverser.reverse(input);
        System.out.println(Commons.printList(reversed, ","));

    }

    @Test
    public void multipleIterators() {
        final Iterator<Integer> a = Arrays.asList(1, 2, 3, 4, 5).iterator();
        final Iterator<Integer> b = Arrays.asList(6).iterator();
        final Iterator<Integer> c = new ArrayList<Integer>().iterator();
        final Iterator<Integer> d = new ArrayList<Integer>().iterator();
        final Iterator<Integer> e = Arrays.asList(7, 8, 9).iterator();
        final Iterator<Integer> singleIterator =
                IteratorCollapser.collapse(Arrays.asList(a, b, c, d, e));
        assertTrue(singleIterator.hasNext());
        for (Integer i = 1; i <= 9; i++) {
            assertEquals(i, singleIterator.next());
        }
        assertFalse(singleIterator.hasNext());
    }

    @Test
    public void addListOps(){
        List<Integer> inputList = Arrays.asList(1, 2, 4, 5, 6);
        PlusOneIntegerOperation plusOneIntegerOperation = new PlusOneIntegerOperation();
        List<Integer> outList = ListTransformer.transform(inputList, plusOneIntegerOperation);
        System.out.println(Commons.printList(outList, ","));
        //proviamo adesso una funzione che restituisce le lunghezze delle stringhe di input
        List<String> inputListString = Arrays.asList("Uno", "Due", "Tre", "Quattro");
        outList = ListTransformer.transform(inputListString, new GenericOperation<String, Integer>() {
            @Override
            public Integer performOperation(String input) {
                return input.length();
            }
        });
        System.out.println(Commons.printList(outList, ","));

    }
}
