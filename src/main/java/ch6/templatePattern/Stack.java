package ch6.templatePattern;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Lo stack è una struttura dati del tipo coda LIFO backed con una Linked List
 */
public class Stack<E> implements Serializable {


    private LinkedList<E> state;

    public Stack(LinkedList<E> initialState){
        if(initialState != null){
            state = initialState;
        } else {
            state = new LinkedList<E>();
        }
    }

    public void push(E element){
        state.add(0, element);
    }

    public E pop() {
        return state.remove(0);
    }

    /*
    Il metodo permette di delegare la scelta dell'elemento alla classe predicate per isolare
     */
    public Stack filter(StackPredicate predicate){
        Stack out = new Stack(null);
        for(E element : state){
            if(!predicate.isValid(element)){
                out.push(element);
            }
        }
        return out;
    }

    public List<E> getEls(){
        return state;
    }

    @Override
    public String toString(){
        StringBuilder outBuilder = new StringBuilder("Stack instance");
        for(Object o : this.getEls()){
            outBuilder.append(o.toString());
            outBuilder.append(",");
        }
        return outBuilder.toString().substring(0, outBuilder.toString().length()-1);
    }
}
