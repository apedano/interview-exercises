package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public class NamedNumberedClass extends NumberedClass {
    String name;


    public NamedNumberedClass(String name, Integer order) {
        super(order);
        this.name = name;
    }
}
