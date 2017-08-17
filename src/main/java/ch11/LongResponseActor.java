package ch11;

import akka.actor.UntypedActor;

import java.util.Date;

/**
 * Created by Alex on 17/08/2017.
 */
public class LongResponseActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof ImmutableMessage){
            ImmutableMessage immutableMessage = (ImmutableMessage) o;
            System.out.println(String.format("Message [%s] received at: %s%n. Now waiting for 5 secs.", immutableMessage.getText(), (new Date()).toString()));
            Thread.sleep(5000);
        }
    }
}
