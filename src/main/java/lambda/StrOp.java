package lambda;

/**
 * Created by Alex on 14/09/2017.
 */
public class StrOp {

    public static String applyMethod(GenericFunctionalInterface<String> function, String input){
        return function.func(input);
    }

}
