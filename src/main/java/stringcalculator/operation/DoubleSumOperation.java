package stringcalculator.operation;

import java.util.regex.Pattern;

/**
 * Created by Alex on 29/08/2017.
 */
public class DoubleSumOperation extends BinaryOperation {

    public static final String SYMBOL = "+";

    protected Pattern pattern = Pattern.compile("([0-9]+[\\.|,]*[0-9]*])\\+([0-9]+[\\.|,]*[0-9]*])");


    protected static Double apply(Double operand1, Double operand2) {
        return operand1 + operand2;
    }

    @Override
    public int getOrder() {
        return this.order;
    }


}
