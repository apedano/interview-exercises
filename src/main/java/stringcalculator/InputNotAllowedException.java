package stringcalculator;

/**
 * Created by Alex on 25/08/2017.
 */
public class InputNotAllowedException extends RuntimeException {

    public InputNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputNotAllowedException() {
    }
}
