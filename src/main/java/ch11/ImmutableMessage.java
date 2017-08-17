package ch11;

import java.io.Serializable;

/**
 * Created by Alex on 15/08/2017.
 */
public class ImmutableMessage implements Serializable {

    //immutable
    private final String text;

    public ImmutableMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
