package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public class GenericConstructor {

    public double doubleValue;

    public <N extends Number> GenericConstructor(N number){
        this.doubleValue = number.doubleValue();
    }
}
