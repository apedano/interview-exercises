package ch11;

/**
 * Created by Alex on 17/08/2017.
 */
public class CallMeSynched implements CallMe {


    @Override
    public void call(String msg) {
        synchronized (System.out){
            System.out.print("[");
            System.out.print(msg);
            //this istruction makes synch process Evident
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("]");
        }
    }
}
