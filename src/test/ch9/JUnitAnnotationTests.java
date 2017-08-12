package ch9;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Alex on 12/08/2017.
 */
public class JUnitAnnotationTests {

    @Test(expected = java.lang.ArithmeticException.class)
    public void expectedExceptionTest(){
        System.out.println("We know there is a line wich execution will throw an exception, but the annotation is scoped to the entire method");
        int a = 3/0;
        System.out.println("This text will not be prompted");
    }

    @Test
    public void innerExceptionHandlingTest(){
        System.out.println("Here we want a more fined-grained exception handling because we know in witch operation the exception is expected");
        String nullString = null;
        try{
            if(nullString == null){
                int a = 3/0;
                fail("The test is failed because the npe was not throwed");
            }
        } catch (ArithmeticException ignored){}
    }

    @Test(timeout = 5000l)
    public void timeoutExecutionTest() throws InterruptedException {
        System.out.println("Execution will end after 5 sec. timeout");
        int counter = 0;
        while(true){
            System.out.println(String.format("Counting %d...", ++counter));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
