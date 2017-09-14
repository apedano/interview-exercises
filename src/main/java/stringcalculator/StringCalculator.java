package stringcalculator;


import stringcalculator.operation.ExpressionStack;

/**
 * Created by Alex on 25/08/2017.
 */
public class StringCalculator {

    private ExpressionStack operationStack = new ExpressionStack();


    public StringCalculator(String textualExpression) {
        operationStack.push(new Expression(textualExpression, null));
    }




}
