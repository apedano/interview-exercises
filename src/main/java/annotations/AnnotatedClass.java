package annotations;

/**
 * Created by Alex on 02/09/2017.
 */
@MyAnno(str = "Annotation example for class", val = 1)
@What(description = "@What description")
@NoRuntimeRetentionAnnotation
public class AnnotatedClass {

    @MyAnno(str = "Annotation example for method print()", val = 2)
    @OnlyMethodAnnotation(60)
    public void print(){
        System.out.print(this.getClass().getSimpleName() + "print() method invocated!");
    }

    @MyAnno(str = "Annotation example for method print(String, Integer)", val = 3)
    @What //with Default value for description
    @DefaultValueAnnotation(999)
    public void print(String text, Integer num){
        System.out.print(this.getClass().getSimpleName() + "print(String:" + text + ", Integer: " + num + ") method invocated!");
    }


    @MyAnno(str = "Repeated annotation #1", val = 4)
    @MyAnno(str = "Repeated annotation #2", val = 5)
    @MyAnno(str = "Repeated annotation #3", val = 6)
    public void repeatedAnnotationMethod(){
    }
}
