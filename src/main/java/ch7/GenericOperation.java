package ch7;

/**
 * Created by Alex on 10/08/2017.
 */
public interface GenericOperation<I,O> {

    public <O> O performOperation(I input);

}
