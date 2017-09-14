package generic;

import generics.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 14/09/2017.
 */
public class GenericsTest {

    @Test
    public void boundedWildcardTest() {
        TwoD coords[] = {
                new TwoD(1, 2),
                new TwoD(3, 4),
                new TwoD(5, 6),
                new TwoD(7, 8)
        };

        Coords<TwoD> twoCoords = new Coords<TwoD>(coords);
        BoundedWildcard.showXY(twoCoords);
        /* Compile time error twoCoords cannot be used with showXYZ
        BoundedWildcard.showXYZ(twoCoords);
        */
        ThreeD tcoords[] = {
                new ThreeD(1, 2, 9),
                new ThreeD(3, 4, 10),
                new ThreeD(5, 6, 11),
                new ThreeD(7, 8, 12)
        };
        Coords<ThreeD> threeCoords = new Coords<ThreeD>(tcoords);
        BoundedWildcard.showXYZ(threeCoords);

    }

    @Test
    public void genericMethodTest() {
        NumberedClass numberedClasses[] = {
                new NumberedClass(4),
                new NumberedClass(5),
                new NumberedClass(6),
                new NumberedClass(3),
                new NumberedClass(451)
        };
        assertTrue(GenericMethods.isIn(numberedClasses, new NamedNumberedClass("nome istanza", 3)));
        assertFalse(GenericMethods.isIn(numberedClasses, new NamedNumberedClass("nome istanza", 30000)));
    }

    @Test
    public void genericConstructorTest() throws Exception {
        GenericConstructor genericConstructor = new GenericConstructor(Integer.valueOf(300));
        assertTrue(genericConstructor.doubleValue == 300);
    }

    @Test
    public void genericInterfaceTest(){
        NumberedClass numberedClassInstances[] = {
                new NumberedClass(4),
                new NumberedClass(5),
                new NumberedClass(6),
                new NumberedClass(3),
                new NumberedClass(451)
        };
        GenericInterfaceImpl<NumberedClass> genericInterfaceObj = new GenericInterfaceImpl<NumberedClass>(numberedClassInstances);
        assertTrue(genericInterfaceObj.min().order == 3);
        assertTrue(genericInterfaceObj.max().order == 451);

    }

}
