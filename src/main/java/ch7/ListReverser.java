package ch7;

import java.util.LinkedList;

/**
 * Created by Alex on 10/08/2017.
 */
public class ListReverser {

    public static <E> LinkedList<E> reverse(LinkedList<E> inputList){
        if(inputList.size() == 1){
            return inputList;
        }
        LinkedList<E> reversed = reverse(new LinkedList<E>(inputList.subList(1, inputList.size())));
        reversed.addLast(inputList.get(0));
        return reversed;

    }
}
