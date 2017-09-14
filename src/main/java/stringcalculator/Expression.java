package stringcalculator;

/**
 * Created by Alex on 29/08/2017.
 */
public class Expression {
    String textExpression;
    Expression parent;
    Double result;

    public Expression(String textExpression, Expression parent) {
        this.textExpression = textExpression;
        this.parent = parent;
    }

    public String getTextExpression() {
        return textExpression;
    }

    public void setTextExpression(String textExpression) {
        this.textExpression = textExpression;
    }

    public Expression getParent() {
        return parent;
    }

    public void setParent(Expression parent) {
        this.parent = parent;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
