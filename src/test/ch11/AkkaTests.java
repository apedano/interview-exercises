package ch11;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;
import akka.routing.RoundRobinRouter;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Alex on 15/08/2017.
 */
public class AkkaTests {

    private final ActorSystem actorSystem = ActorSystem.create("actorSystem");

    @Test
    public void simlpleActor() throws InterruptedException {
        ActorRef actorRef = actorSystem.actorOf(Props.create(MessageActor.class), "messageProcessor");
        //no sender message
        actorRef.tell(new ImmutableMessage("Ciao Mondo!"), null);
        System.out.println("Message sent. Waiting for stopping application...");
        Thread.sleep(3000);
    }

    @Test
    public void dividingActorTest() throws InterruptedException {
        ActorRef messageActorRef = actorSystem.actorOf(Props.create(MessageActor.class), "messageActor");
        ActorRef dividingActorRef = actorSystem.actorOf(Props.create(DividingActor.class), "dividingActor");
        dividingActorRef.tell(Integer.valueOf(5), messageActorRef);
        dividingActorRef.tell(Integer.valueOf(0), messageActorRef);
        dividingActorRef.tell(Integer.valueOf(1), messageActorRef);
        System.out.println("Messages sent. Waiting for stopping application...");
        Thread.sleep(3000);
    }

    @Test
    public void multiActorRoutedTest() throws InterruptedException {
        //ActorRef router = actorSystem.getContext().actorOf(new RoundRobinPool(3).props(Props.create(LongResponseActor.class)),"router2");
        System.out.println("Messages sent. Waiting for stopping application...");
        Thread.sleep(3000);
    }

}
