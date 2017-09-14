package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public class GenericMethods {

    public static <T extends Comparable, V extends T> boolean isIn(T[] els, V el){
        for(T current : els){
            if(current.compareTo(el) == 0){
                return true;
            }
        }
        return false;
    }
}
