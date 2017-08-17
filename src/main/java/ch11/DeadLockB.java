package ch11;

/**
 * Created by Alex on 17/08/2017.
 */
public class DeadLockB {

    synchronized public void synchB(DeadLockA deadLockA){
        System.out.println(Thread.currentThread().toString() + ": Entering class B synchronized method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().toString() + ": Calling A synchronized method");
        deadLockA.synchA(this);
        System.out.println(Thread.currentThread().toString() + ": Class A synchronized method called. synchB finished ");

    }
}
