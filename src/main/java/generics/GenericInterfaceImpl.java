package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public class GenericInterfaceImpl<T extends Comparable<T>> implements GenericInterface<T> {

    T[] vals;

    public GenericInterfaceImpl(T[] vals) {
        this.vals = vals;
    }

    @Override
    public T min() {
        T min = vals[0];
        for(int i=0; i<vals.length; i++){
            if(vals[i].compareTo(min) < 0 ){
                min = vals[i];
            }
        }
        return min;
    }

    @Override
    public T max() {
        T max = vals[0];
        for(int i=0; i<vals.length; i++){
            if(vals[i].compareTo(max) > 0 ){
                max = vals[i];
            }
        }
        return max;
    }
}
