package ch11;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Alex on 14/08/2017.
 */
public class WaitTest {

    @Test
    public void waitToComplete() throws InterruptedException {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        executorService.execute(new FiniteThreadNamePrinterLatch(countDownLatch));
        /**
         * Causes the current thread to wait until the latch has counted down to
         * zero, unless the thread is {@linkplain Thread#interrupt interrupted},
         * or the specified waiting time elapses.
         *
         * <p>If the current count is zero then this method returns immediately
         * with the value {@code true}.
         *
         * <p>If the current count is greater than zero then the current
         * thread becomes disabled for thread scheduling purposes and lies
         * dormant until one of three things happen:
         * <ul>
         * <li>The count reaches zero due to invocations of the
         * {@link #countDown} method; or
         * <li>Some other thread {@linkplain Thread#interrupt interrupts}
         * the current thread; or
         * <li>The specified waiting time elapses.
         * </ul>
         *
         * <p>If the count reaches zero then the method returns with the
         * value {@code true}.
         *
         * <p>If the current thread:
         * <ul>
         * <li>has its interrupted status set on entry to this method; or
         * <li>is {@linkplain Thread#interrupt interrupted} while waiting,
         * </ul>
         * then {@link InterruptedException} is thrown and the current thread's
         * interrupted status is cleared.
        */
         countDownLatch.await(5, TimeUnit.SECONDS);
    }

    private class FiniteThreadNamePrinterLatch implements Runnable{

        final CountDownLatch countDownLatch;

        public FiniteThreadNamePrinterLatch(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            for(int i=0; i<25; i++){
                System.out.println("Text from " + Thread.currentThread().getName());
            }
            countDownLatch.countDown();
        }
    }

    @Test
    public void runInSameThread(){
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                //Simply execute the runnable in the same main thread
                command.run();
            }
        };

        executor.execute(new PrinterRunnable());
    }
}
