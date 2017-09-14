package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public class NumberedClass implements Comparable<NumberedClass> {

    public Integer order;

    public NumberedClass(Integer order) {
        this.order = Integer.valueOf(order);
    }

    @Override
    public int compareTo(NumberedClass comparableClass) {
        return this.order.compareTo(comparableClass.order);
    }
}
