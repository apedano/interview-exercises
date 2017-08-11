package ch8;

import java.util.LinkedList;
import java.util.List;

/**
 * Example of LIFO list
 */
public class Queue<O> {

    private List<O> internalState = new LinkedList<O>();

    public Queue(LinkedList<O> initialState){
        if(initialState != null){
            internalState = initialState;
        }
    }

    public void push(O object){
        internalState.add(object);
    }

    public O pop(){
        if(internalState.size() < 1){
            throw new IllegalStateException("Cannot pop from empty queue");
        }
        return internalState.remove(0);
    }
}
