package ch11;

import akka.actor.UntypedActor;

import java.util.Date;

/**
 * Created by Alex on 15/08/2017.
 */
public class MessageActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof ImmutableMessage){
            ImmutableMessage immutableMessage = (ImmutableMessage) o;
            System.out.println(String.format("Message [%s] received at: %s%n", immutableMessage.getText(), (new Date()).toString()));
        }
    }

}
