package ch9;

import org.junit.*;

/**
 * Created by Alex on 12/08/2017.
 * Output
 * Connected to the target VM, address: '127.0.0.1:52203', transport: 'socket'
 BeforeClass annotated method invocation (static because instance is not created yet) [couter=1]
 Before annotated method invocation [couter=2]
 Test 1 annotated method invocation [couter=3]
 After annotated method invocation [couter=4]
 Before annotated method invocation [couter=5]
 Test 2 annotated method invocation [couter=6]
 After annotated method invocation [couter=7]
 AfterClass annotated method invocation [couter=8]
 */
public class JUnitTestLifeCycle {

    public static int counter = 0;

    @BeforeClass
    public static void beforeClassMethod(){
        counter++;
        System.out.println(String.format("BeforeClass annotated method invocation (static because instance is not created yet) [couter=%d]", counter));
    }

    @Before
    public void beforeMethod(){
        counter++;
        System.out.println(String.format("Before annotated method invocation [couter=%d]", counter));
    }

    @Test
    public void test1(){
        counter++;
        System.out.println(String.format("Test 1 annotated method invocation [couter=%d]", counter));
    }

    @Test
    public void test2(){
        counter++;
        System.out.println(String.format("Test 2 annotated method invocation [couter=%d]", counter));
    }

    @After
    public void afterMethod(){
        counter++;
        System.out.println(String.format("After annotated method invocation [couter=%d]", counter));
    }

    @AfterClass
    public static void afterClassMethod(){
        counter++;
        System.out.println(String.format("AfterClass annotated method invocation [couter=%d]", counter));
    }




}
