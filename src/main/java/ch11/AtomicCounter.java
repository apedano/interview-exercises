package ch11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alex on 15/08/2017.
 */
public class AtomicCounter {

    private AtomicInteger counter = new AtomicInteger(0);

    public int getCounter() {
        return counter.get();
    }

    public int add(int increment) {
        return this.counter.addAndGet(increment);
    }

    public void setCounter(int value){
        counter.set(value);
    }
}
