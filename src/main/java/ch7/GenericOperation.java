package ch7;

/**
 * Created by Alex on 10/08/2017.
 */
public interface GenericOperation<I,O> {

    public O performOperation(I input);

}
