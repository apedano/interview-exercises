package ch11;

/**
 * Created by Alex on 17/08/2017.
 */
public class Q {

    private int n = 0;
    private boolean valueSet = true;

    synchronized public int get(){
        while(!valueSet){
            try {
                //wait until someone else (the producer) sets a new value not yet readed
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got n: " + n);
        valueSet = false;
        notify(); //resume wainting thread
        return n;
    }

    synchronized public void set(int newValue){
        while(valueSet){
            try {
                //waits someane alse (the consumer) reads the value so, set valueSet to false
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify(); //resume wainting thread
        this.n = newValue;
        valueSet = true; //value to be read
        System.out.println("Set n: " + n);
    }

}
