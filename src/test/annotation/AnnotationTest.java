package annotation;

import annotations.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Alex on 02/09/2017.
 */
public class AnnotationTest {

    private Class<? extends AnnotatedClass> objectClass;

    @Before
    public void setUp() {
        AnnotatedClass object = new AnnotatedClass();
        //Get Class instance from object (Reflection API)
        objectClass = object.getClass();
    }

    @Test
    public void reflectionUseTest() {
        //isAnnotationPresent()
        assertTrue(objectClass.isAnnotationPresent(MyAnno.class) && objectClass.isAnnotationPresent(What.class));
        System.out.println("objectClass.isAnnotationPresent(MyAnno.class) && objectClass.isAnnotationPresent(What.class) is true");
        //no runtime annotation is not retained
        assertFalse(objectClass.isAnnotationPresent(NoRuntimeRetentionAnnotation.class));
        System.out.println("objectClass.isAnnotationPresent(NoRuntimeRetentionAnnotation.class) == false because of @Retention(RetentionPolicy.CLASS)");

        MyAnno classAnnotation = objectClass.getAnnotation(MyAnno.class);
        System.out.println("Class annotation: " + classAnnotation.toString());
        assertTrue(classAnnotation.str().equals("Annotation example for class") && classAnnotation.val() == 1);
        What classAnnotation2 = objectClass.getAnnotation(What.class);
        System.out.println("Class annotation: " + classAnnotation.toString());
        assertTrue(classAnnotation2.description().equals("@What description"));

        Method method = null;
        try {
            //use Reflection API to get method instance by name from class instance
            method = objectClass.getMethod("print");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("Method print not found. Test failed");
        }
        //get annotation for method by class type
        MyAnno methodAnnotation = method.getAnnotation(MyAnno.class);
        System.out.println("Method print() annotation: " + methodAnnotation.toString());
        assertTrue(methodAnnotation.str().equals("Annotation example for method print()") && methodAnnotation.val() == 2);
        //get targeted annotation
        OnlyMethodAnnotation onlyMethodAnnotation = method.getAnnotation(OnlyMethodAnnotation.class);
        System.out.println("Method print() annotation: " + onlyMethodAnnotation.toString());
        assertTrue(onlyMethodAnnotation.value() == 60);


        //use Reflection API for retriveing method with  parameters
        try {
            method = objectClass.getMethod("print", String.class, Integer.class);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("Method print(String, Integer) not found. Test failed");
        }

        methodAnnotation = method.getAnnotation(MyAnno.class);
        System.out.println("Method print(String, Integer) annotation: " + methodAnnotation.toString());
        assertTrue(methodAnnotation.str().equals("Annotation example for method print(String, Integer)") && methodAnnotation.val() == 3);

        //Method annotation with default value
        What methodAnnotation2 = method.getAnnotation(What.class);
        System.out.println("Method print(String, Integer) annotation: " + methodAnnotation2.toString());
        assertTrue(methodAnnotation2.description().equals("Default description"));

        //Default member value() annotation
        DefaultValueAnnotation methodAnnotation3 = method.getAnnotation(DefaultValueAnnotation.class);
        System.out.println("Method print(String, Integer) annotation: " + methodAnnotation3.toString());
        assertTrue(methodAnnotation3.value() == 999 && methodAnnotation3.xyz() == 0);

        //Get all annotations for class object
        Annotation[] annotations = objectClass.getAnnotations();
        assertEquals(annotations.length, 2);
    }

    @Test
    public void repeatedAnnotationTest() {
        System.out.println("Getting annotated method from object class isntance...");
        Method annotatedMethod = null;
        try {
            annotatedMethod = objectClass.getMethod("repeatedAnnotationMethod");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("Method print(String, Integer) not found. Test failed");
        }
        System.out.println("Getting all annotations from method...");
        Annotation[] annotations = annotatedMethod.getAnnotations();
        assertEquals(annotations.length, 1);
        System.out.println("annotatedMethod.getAnnotations().length == 1 because it contains only Container annotation");

        System.out.println("Getting container for @Repeatable annotations...");
        assertTrue(annotatedMethod.isAnnotationPresent(RepeatedMyAnnos.class));
        System.out.println("RepeatedMyAnnos annotation is present in method...");
        RepeatedMyAnnos repeatedMyAnnos = annotatedMethod.getAnnotation(RepeatedMyAnnos.class);
        System.out.println("Founded RepeatedMyAnnos instance: " + repeatedMyAnnos.toString());
        System.out.println("Extracting values member from repeated annotations container...");
        assertEquals(repeatedMyAnnos.value().length, 3);
        for (int i = 0; i < repeatedMyAnnos.value().length; i++) {
            MyAnno myAnno = repeatedMyAnnos.value()[i];
            System.out.println("@RepeatedMyAnnos.value[" + i + "]: " + myAnno.toString());
            assertTrue(myAnno.str().equals("Repeated annotation #" + (i + 1)) && myAnno.val() == i+4);
        }
    }


}
