package ch6.templatePattern;

/**
 * Created by Alex on 06/08/2017.
 */
public class StackIntegerEvenPredicate<E> implements StackPredicate<Integer> {
    @Override
    public boolean isValid(Integer element) {
        return element % 2 != 0;
    }
}
