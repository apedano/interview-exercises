package annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Alex on 02/09/2017.
 */
@Retention(RetentionPolicy.RUNTIME) //aviable for reflection
@Repeatable(RepeatedMyAnnos.class)
public @interface MyAnno {
    String str();
    int val();

}
