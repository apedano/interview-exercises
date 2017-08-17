package ch11;

/**
 * Created by Alex on 17/08/2017.
 */
public class DeadLockA {

    synchronized public void synchA(DeadLockB deadLockB){
        System.out.println(Thread.currentThread().toString() + ": Entering class A synchronized method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().toString() + ": Calling B synchronized method");
        deadLockB.synchB(this);
        System.out.println(Thread.currentThread().toString() + ": Class B synchronized method called. synchA finished ");
    }
}
