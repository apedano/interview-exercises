package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Alex on 02/09/2017.
 * This is the container for the @Repeatable annotation MyAnno
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatedMyAnnos {

    MyAnno[] value(); //contains repeated annotations

}
