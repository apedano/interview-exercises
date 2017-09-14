package lambda;

/**
 * Created by Alex on 14/09/2017.
 */
public interface ExceprionFunctionalInterface {
    Integer noZero(Integer input) throws ZeroValueException;

    class ZeroValueException extends Exception {
    }
}
