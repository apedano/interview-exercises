package stringcalculator.operation;


import java.util.regex.Matcher;

/**
 * Created by Alex on 29/08/2017.
 */
public abstract class BinaryOperation implements Operation {

    protected int order;

    private Double apply(Double operand1, Double operand2) {
        return null;
    }

    @Override
    public String getResult(String inputText) {
        // Now create matcher object.
        Matcher m = this.pattern.matcher(inputText);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            return apply(Double.valueOf(m.group(1)), Double.valueOf(m.group(1))).toString();
        }else {
            System.out.println("NO MATCH FOR " + this.getClass().getSimpleName());
            return "";
        }
    }


}
