package ch11;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

/**
 * Created by Alex on 17/08/2017.
 */
public class DividingActor extends UntypedActor {

    @Override
    public void onReceive(Object message) {
        if(message instanceof Integer){
            float result = 10 / (Integer) message;
            //write response to sender
            ImmutableMessage response = new ImmutableMessage(String.format("Result is %f", result));
            this.getSender().tell(response, this.getSelf());
        }
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        //la strategia ridefinisce il comportamento al mommento in cui l'actor solleva un'eccezione
        return new OneForOneStrategy(10, Duration.Inf(), new Function<Throwable, SupervisorStrategy.Directive>() {
            @Override
            public SupervisorStrategy.Directive apply(Throwable throwable) throws Exception {
                System.out.println("Exception occurred. Restarting dividingActor...");
                return SupervisorStrategy.restart();
            }
        });
    }
}
