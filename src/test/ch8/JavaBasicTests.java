package ch8;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 11/08/2017.
 */
public class JavaBasicTests {

    @Test
    public void genericTest1() {
        LinkedList<String> input = new LinkedList<String>(Arrays.asList("Primo", "Secondo", "Terzo"));
        Queue<String> coda = new Queue<String>(input);
        coda.push("Quarto");
        coda.push("Quinto");
        String pop = coda.pop();
        assertEquals("Primo", pop);
    }

    @Test
    public void noCovarianceExceptionTest() {
        List<B> inputB = new ArrayList<B>();
        //Compile error
        //List<B> output = CovarianceList.dummyOperation(inputB);
        List<? extends A> output = CovarianceList.covarianceOperation(inputB);

    }

    @Test
    public void mutatePrivateFieldWithReflectionAPI() {
        A instance = new A();
        try {
            Field privField = instance.getClass().getDeclaredField("privateField");
            privField.setAccessible(true);
            String injectedValue = "valoreIniettatoConReflection";
            privField.set(instance, injectedValue);
            assertEquals(instance.getPrivateField(), injectedValue);
        } catch (NoSuchFieldException e) {
            //get field operation
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //set field operation
            e.printStackTrace();
        }
    }

    @Test
    public void tryWithResourceTest() {
        //la classe di resource deve essere Closeable
        //il metodo close si prende in carico la chiusura dello stream in caso di eccezione
        //senza doverla gestire in caso di eccezione con blocchi finally
        try (FileWriter fileWriter = new FileWriter("c:\\out.bin")) {
            fileWriter.write("prova");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void collectionFrameworkTest() {
        List<Integer> integerList = new ArrayList<Integer>();
        assertTrue(integerList instanceof Collection);
        Set<Integer> integerSet = new TreeSet<Integer>();
        assertTrue(integerList instanceof Collection);
        Map<String, String> map = new HashMap<String, String>();
        assertFalse(map instanceof Collection);
        assertTrue(map instanceof Map);
        assertTrue(map.keySet() instanceof Collection);
        assertTrue(map.entrySet() instanceof Collection);
        assertTrue(map.values() instanceof Collection);
    }

    @Test
    public void linkedHashMapTest() {
        //un'hashmap che preserva l'ordine di inserimento
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        linkedHashMap.put(Integer.valueOf(10), "ten");
        linkedHashMap.put(Integer.valueOf(20), "twenty");
        linkedHashMap.put(Integer.valueOf(30), "thirty");
        linkedHashMap.put(Integer.valueOf(40), "forty");
        linkedHashMap.put(Integer.valueOf(50), "fifty");
        hashMap.put(Integer.valueOf(10), "ten");
        hashMap.put(Integer.valueOf(20), "twenty");
        hashMap.put(Integer.valueOf(30), "thirty");
        hashMap.put(Integer.valueOf(40), "forty");
        hashMap.put(Integer.valueOf(50), "fifty");
        Iterator<Integer> linkedHashMapIterator = linkedHashMap.keySet().iterator();
        assertTrue("ten".equals(linkedHashMap.get(linkedHashMapIterator.next())));
        assertTrue("twenty".equals(linkedHashMap.get(linkedHashMapIterator.next())));
        assertTrue("thirty".equals(linkedHashMap.get(linkedHashMapIterator.next())));
        //l'hash map non mantine l'ordine di inserimento, per cui la prima chiave non è quella del
        //ptimo elemento inserito (il bucket è ordinato per hash delle chiavi crescenti)
        assertFalse("ten".equals(hashMap.get(hashMap.keySet().iterator().next())));
    }

    @Test
    public void java8DefaultMethodTest(){
        //default methods in interface
        Java8Interface j8 = new Java8InterfaceImpl();
        int j8Beta = j8.beta();
        assertTrue(j8Beta == 6);
    }

    @Test
    public void java8ForEachLambdaTest(){
        List<Integer> ints = new ArrayList<Integer>(4);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        List<Integer> newInts = new ArrayList<Integer>(ints.size());
        //lambda expression as Consumer class
        // void Consumer.accept(? tipo della lista)
        ints.forEach(i -> {newInts.add(i+10);});
        assertTrue(newInts.get(0).equals(Integer.valueOf(11)));
    }

}
