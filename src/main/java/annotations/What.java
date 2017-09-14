package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Alex on 02/09/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface What {
    String description() default "Default description";
}
