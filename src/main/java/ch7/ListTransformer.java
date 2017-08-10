package ch7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 10/08/2017.
 */
public class ListTransformer<I, O> {

    public static <I,O> List<O> transform(List<I> inputList, GenericOperation<I, O> operation){
        List<O> outList = new ArrayList<>(inputList.size());
        for(I input : inputList){
            outList.add(operation.<O>performOperation(input));
        }
        return outList;
    }
}
