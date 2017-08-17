package ch11;

/**
 * Created by Alex on 14/08/2017.
 */
public class PrinterRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Text from " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
