package lambda;

import generics.NumberedClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Alex on 14/09/2017.
 */
public class LambdaExpressionsTest {

    @Test
    public void basicTest() {
        FunctionalInterface1 functionalInterface1Obj;
        //Questa espressione sarà sostituita in compilazione da una istanza della classe FunctionalInterface1
        //il cui metodo getDoubleVal() avrà il corpo definito dalla arrow function che deve essere compatibile
        //per parametri di ingresso e valore di uscita alla funzione della functional interface
        functionalInterface1Obj = () -> 3.1;
        /*
        functionalInterface1Obj = () -> "3.1"; // COMPILATION ERROR
        */
        assertTrue(functionalInterface1Obj.getDoubleVal() == 3.1);
    }

    @Test
    public void twoParamFunctionalInterfaceTest() {
        TwoParamFunctionalInterface twoParamFunctionalInterface = (n, m) -> n < m;
        assertTrue(twoParamFunctionalInterface.lessThen(3, 4));

    }

    @Test
    public void genericFunctionalInterfaceTest() {
        //factorial function
        GenericFunctionalInterface<Integer> integerGenericInterface = (input) -> {
            int out = 1;
            for (int i = 1; i <= input; i++) {
                out *= i;
            }
            return out;
        };
        assertEquals(integerGenericInterface.func(10), Integer.valueOf(3628800));
        assertEquals(FunctionalInterfaceAsParam.apply(integerGenericInterface, 10), Integer.valueOf(3628800));
    }

    @Test(expected = ExceprionFunctionalInterface.ZeroValueException.class)
    public void exceptionFunctionalInterfaceTest() throws ExceprionFunctionalInterface.ZeroValueException {
        ExceprionFunctionalInterface exceprionFunctionalInterface = (i) -> {
            if (i.equals(Integer.valueOf(0))) {
                throw new ExceprionFunctionalInterface.ZeroValueException();
            }
            return i;
        };
        try {
            assertEquals(exceprionFunctionalInterface.noZero(3), Integer.valueOf(3));
        } catch (ExceprionFunctionalInterface.ZeroValueException e) {
            e.printStackTrace();
        }
        assertEquals(exceprionFunctionalInterface.noZero(0), Integer.valueOf(0));
        fail("ExceprionFunctionalInterface.ZeroValueException not throwed");
    }

    @Test
    public void variableCaptureTest() {
        final int i = 10;
        //factorial function
        GenericFunctionalInterface<Integer> integerGenericInterface = (input) -> {
            //qui la capture avviene per la variabile i che è effective final e in
            // quanto tale non deve essere modificata
            return input * i;
        };

        GenericFunctionalInterface<Integer> integerGenericInterface2 = (input) -> {
            //variable in lambda expression should be effective final
            //i = 11; -> compilation error
            return input * i;
        };
    }

    @Test
    public void methodReferenceTest(){
        String input = "stringa";
        //Static method reference ::
        //il metodo deve essere compatibile per parametri di input e tipo di uscita con la functional interface
        //di partenza anche se non la deve necessariamente implemtnare
        String output = StrOp.applyMethod(StaticGenericFunctionalInterfaceUppercase::func, input);
        assertEquals(output, "STRINGA");

        //no static method reference
        GenericFunctionalInterfaceUppercase gfiu = new GenericFunctionalInterfaceUppercase();
        output = StrOp.applyMethod(gfiu::func, input);
        assertEquals(output, "STRINGA");

        //method reference with GENERICS
        NumberedClass[] numberedClasses = {
                new NumberedClass(Integer.valueOf(2)),
                new NumberedClass(Integer.valueOf(5)),
                new NumberedClass(Integer.valueOf(2)),
                new NumberedClass(Integer.valueOf(7)),
                new NumberedClass(Integer.valueOf(2)),
                new NumberedClass(Integer.valueOf(2))
        };
        NumberedClass test = new NumberedClass(Integer.valueOf(2));
        int count = ArrayOp.apply(ArrayFunctions::<NumberedClass>countOccurrences, numberedClasses, test);
        assertEquals(count, 4);

    }

    @Test
    public void constructorReferemceTest(){
        NumberedClassFunctionalInterface ncfi = NumberedClass::new;
        NumberedClass numberedClass = ncfi.funct(Integer.valueOf(100));
        assertTrue(numberedClass.order == 100);
    }




}
