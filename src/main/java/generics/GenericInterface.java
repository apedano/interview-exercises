package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public interface GenericInterface<T extends Comparable<T>> {

    public T min();
    public T max();
}
