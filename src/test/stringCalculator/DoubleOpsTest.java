package stringCalculator;

import org.junit.Test;
import stringcalculator.operation.DoubleSumOperation;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 30/08/2017.
 */
public class DoubleOpsTest {

    @Test
    public void sumTest(){
        String operation = "3+5,2";
        DoubleSumOperation doubleSumOperation = new DoubleSumOperation();
        String result = doubleSumOperation.getResult(operation);
        assertTrue(operation.equals("8,2"));
    }
}
