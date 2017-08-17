package ch11;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Alex on 14/08/2017.
 */
public class MultithreadTest {

    @Test
    public void test(){
        //l'esecuzione termina quando si arriva alla fine del thread main, anche se eventuali thread paralleli non
        //sono ancora conclusi
        Thread separateThread = new Thread(new PrinterRunnable());
        //This line executer the run method in the runnable class
        separateThread.start();
        for(int i = 1; i<=5; i++){
            System.out.println("Text from " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void executorTest(){
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(new PrinterRunnable());
        executor.execute(new PrinterRunnable());
        executor.execute(new PrinterRunnable());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finito");
    }

    @Test
    public void executorServiceTest() throws InterruptedException, ExecutionException, TimeoutException {
        //L'executor service permette di eseguire operazioni che restituiscono un valore Callable<?>
        //Inoltre permettono di essere terminati con shutdown
        ExecutorService executorService = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        Future<Double> future = executorService.submit(new PiCalculator());
        //wait output till timeout of 10 sec
        final double pi = future.get(10, TimeUnit.SECONDS);
        long finalTime = System.currentTimeMillis();
        System.out.println("Calculated pi value =" + pi + "in " + (finalTime - startTime) + " ms.");
        //terminates execution
        executorService.shutdown();
    }



}
