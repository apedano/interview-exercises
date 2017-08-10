package ch7;

/**
 * Created by Alex on 10/08/2017.
 */
public class PlusOneIntegerOperation implements GenericOperation<Integer, Integer> {
    @Override
    public Integer performOperation(Integer input) {
        return input + 1;
    }
}
