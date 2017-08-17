package ch11;

/**
 * Created by Alex on 17/08/2017.
 */
public class Caller implements Runnable {

    private String msg;
    private CallMe callme;
    public Thread t;

    public Caller(CallMe callme, String msg) {
        this.msg = msg;
        this.callme = callme;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        callme.call(msg);
    }
}
