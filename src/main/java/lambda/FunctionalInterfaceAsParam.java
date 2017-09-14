package lambda;

/**
 * Created by Alex on 14/09/2017.
 */
public class FunctionalInterfaceAsParam {

    public static <T>  T apply(GenericFunctionalInterface<T> gfi, T input){
        return gfi.func(input);
    }
}
