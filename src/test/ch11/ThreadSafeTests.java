package ch11;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Alex on 15/08/2017.
 */
public class ThreadSafeTests {

    private ExecutorService executorService;


    @Before
    public void setUp(){
        executorService = Executors.newCachedThreadPool();
    }


    @Test
    public void noThreadSafeCounter() throws InterruptedException {
        SimpleCounter simpleCounter = new SimpleCounter();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(true){
                    //this thread always try to set counter to 100
                    simpleCounter.setCounter(100);
                }
            }
        });
        //if between the two sequent lines (main thread) the other thread set executes, the test will fail.
        //This depends on JVM thread scheduling
        simpleCounter.setCounter(200);
        Thread.sleep(100);
        assertNotEquals(simpleCounter.getCounter(), 200);
    }

    @Test
    public void threadSafeWithLockTest() throws InterruptedException {
        SimpleCounter simpleCounter = new SimpleCounter();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (simpleCounter){
                        //this thread always try to set counter to 100
                        simpleCounter.setCounter(100);
                    }
                }
            }
        });
        //the class put a lock on SimpleCounter and only a thread a time can execute it
        //the other thread setting counter to 100 will wait until lock will be released
        //because it has lock on the same resource simpleCounter
        //trade-off with performance, better release lock as soon as possible
        synchronized (simpleCounter){
            simpleCounter.setCounter(200);
            Thread.sleep(100);
            assertEquals(simpleCounter.getCounter(), 200);
        }
    }

    @Test
    public void threadSafeWithAtomicOperator(){
        AtomicCounter atomicCounter = new AtomicCounter();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    atomicCounter.setCounter(0);
                }
            }
        });
        int delta = 4;
        //no need of synchronized block, atomic is thread safe and value will not be zero
        int refreshedValue = atomicCounter.add(delta);
        assertEquals(delta, refreshedValue);
    }


}
