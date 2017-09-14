package lambda;

/**
 * Created by Alex on 14/09/2017.
 */
public class ArrayOp {

    static <T extends Comparable<T>> int apply(GenericFunctionalInterface2<T> gfi2, T[] array, T inputValue){
        return gfi2.func(array, inputValue);
    }
}
