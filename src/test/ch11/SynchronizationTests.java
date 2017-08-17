package ch11;

import org.junit.Test;

/**
 * Created by Alex on 17/08/2017.
 */
public class SynchronizationTests {

    @Test
    public void synchErrorTest(){
        CallMeNoSynchronized callMeNoSynchronized = new CallMeNoSynchronized();
        //every thread will share the same callme instance
        Caller caller1 = new Caller(callMeNoSynchronized, "Ciao sono il primo thread");
        Caller caller2 = new Caller(callMeNoSynchronized, "Ciao sono il secondo thread");
        Caller caller3 = new Caller(callMeNoSynchronized, "Ciao sono il terzo thread");

        //waits for all thread end execution
        //these threads will create a rece condition with the output stream because callme access to stream is not synchronized
        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* OUTPUT:
        [Ciao sono il primo thread[Ciao sono il terzo thread[Ciao sono il secondo thread]
        ]
        ]
         */
    }

    @Test
    public void synchOKTest(){
        CallMeSynched callMeSynched = new CallMeSynched();
        //every thread will share the same callme instance
        Caller caller1 = new Caller(callMeSynched, "Ciao sono il primo thread");
        Caller caller2 = new Caller(callMeSynched, "Ciao sono il secondo thread");
        Caller caller3 = new Caller(callMeSynched, "Ciao sono il terzo thread");

        //waits for all thread end execution
        //these threads will create a rece condition with the output stream because callme access to stream is not synchronized
        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* OUTPUT:
        [Ciao sono il secondo thread]
        [Ciao sono il terzo thread]
        [Ciao sono il primo thread]
         */
    }

    /**
     * This test ensures that a multitasking application correctly handles access to shared resource,
     * using wait() and notify() methods
     *
     * OUTPUT:
     Got n: 0
     Set n: 1
     Got n: 1
     Set n: 2
     Got n: 2
     Set n: 3
     Got n: 3
     Set n: 4
     Got n: 4
     Set n: 5
     Got n: 5
     Set n: 6
     Got n: 6
     Set n: 7
     Got n: 7
     ...
     */
    @Test
    public void consumerProducerSyncTest(){
        Q q = new Q();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while(true){
                    q.set(i++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    q.get();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();
        try {
            //this program never ends so we must terminate it forcibly
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This test will create a deadlock for mutual access to synchronized method and every one needs access to other
     * synchronized method
     */
    @Test
    public void deadlockTest(){
        DeadLockA deadLockA = new DeadLockA();
        DeadLockB deadLockB = new DeadLockB();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockA.synchA(deadLockB);
            }
        }, "Thread A");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockB.synchB(deadLockA);
            }
        }, "Thread B");

        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
