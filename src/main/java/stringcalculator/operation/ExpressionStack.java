package stringcalculator.operation;

import stringcalculator.Expression;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 29/08/2017.
 */
public class ExpressionStack {

    private List<Expression> mem = new LinkedList<Expression>();

    public void push(Expression expression){
        mem.add(expression);
    }

    public Expression pop(){
        return mem.isEmpty() ? null : mem.remove(0);
    }

}
