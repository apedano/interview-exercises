package ch6;

import ch6.builderPattern.Car;
import ch6.flyweightPattern.SharedCacheProvider;
import ch6.strategyPattern.Strategy;
import ch6.strategyPattern.StrategyClient;
import ch6.strategyPattern.StrategyImpl1;
import ch6.strategyPattern.StrategyImpl2;
import ch6.templatePattern.Stack;
import ch6.templatePattern.StackIntegerEvenPredicate;
import ch6.templatePattern.StackIntegerOddPredicate;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

import static cmn.Commons.joinedList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Alex on 03/08/2017.
 */
public class DesignPatternTests {

    /**
     * Builder Pattern
     */

    @Test
    public void validBuilder() {
        Car car =
                new Car.Builder()
                        .alimentation("diesel")
                        .model("punto")
                        .manufacturer("fiat")
                        .cc(1300)
                        .build();
        assertTrue("Alimentation is not diesel", car.getAlimentation().equals("diesel"));
        assertTrue("Model is not punto", car.getModel().equals("punto"));
        assertTrue("Manufacturer is not fiat", car.getManufacturer().equals("fiat"));
        assertTrue("Manufacturer is not 1300", car.getCc() == 1300);

    }

    @Test(expected = IllegalStateException.class)
    public void IllegalBuilder() {
        Car carBuilder =
                new Car.Builder()
                        .alimentation("diesel")
                        .model("fiat")
                        .build();
    }

    /*
    Lo strategy pattern definisce una struttura in cui un client può settare in run-time
    l'implementazione di una strategy desiderata, sapendo che ognuna di esse rispetterà
    i metodi definiti dall'interfaccia oomune. L'esempio è quello del logging in Java
    8rolling-file, console appender etc...)
     */
    @Test
    public void strategyPatternTest() {
        Strategy currentStrategy = new StrategyImpl1();
        StrategyClient client = new StrategyClient(currentStrategy);
        assertEquals(currentStrategy.getMessage(), client.clientRun());
        currentStrategy = new StrategyImpl2();
        client = new StrategyClient(currentStrategy);
        assertEquals(currentStrategy.getMessage(), client.clientRun());
        currentStrategy = mock(Strategy.class);
        String mockString = "Mock strategy";
        when(currentStrategy.getMessage()).thenReturn(mockString);
        when(currentStrategy.doWork()).thenReturn(mockString);
        client = new StrategyClient(currentStrategy);
        assertEquals(currentStrategy.getMessage(), client.clientRun());

    }

    @Test
    public void templatePatternTest() {
        LinkedList<Integer> initialState = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4));
        Stack<Integer> stack = new Stack<Integer>(initialState);
        stack.push(5);
        stack.push(6);
        System.out.println("Stack iniziale: " + joinedList(stack.getEls(), ","));
        Stack evenFiltered = stack.filter(new StackIntegerEvenPredicate<Integer>());
        System.out.println("Stack filtrato con elementi pari: " + joinedList(evenFiltered.getEls(), ","));
        Stack oddFiltered = stack.filter(new StackIntegerOddPredicate<Integer>());
        System.out.println("Stack filtrato con elementi pari: " + joinedList(oddFiltered.getEls(), ","));
    }

    @Test
    public void decoratorPatternTest() {
        File f = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            f = new File("target", "out.bin");
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            //l'object stream implementa il decorator pattern perchè sivrascrive il comportamento di scrittura della pagina e
            // delega il comportamento di livello più basso alle implementazioni che decora, il buffered e il singolo file
            // output stream che effettivamente si occupa di scrivere i byte sulla destinazione, che in questo caso è il file
            Stack<Integer> stack = new Stack<Integer>(null);
            stack.push(123);
            stack.push(456);
            oos.writeObject(stack);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                //non viene effettuato il flush sugli altri stream per via della medesima decorazione del comportamento
                oos.flush();

                oos.close();
                bos.close();
                fos.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Test
    public void flyweightPatternTest(){
        //il pattern consiste nel mantenere copie delle istanze che servono per molteplici richieste come elementi comuni.
        //Il pattern permette di non dover creare più volte lo stesso valore di istanza ma conservarlo in una cache che
        //correttamente inizializzata serve le richieste
        SharedCacheProvider carProvider = new SharedCacheProvider();
        Car car1 = carProvider.carOfValue(2);
        Car car2 = carProvider.carOfValue(2);
        //si deve trattare delle medesime istanze e non di oggetti che rispettano solamente l'equals
        // (possibile anche se sono istanze differenti)
        assertSame(car1, car2);
    }



}
