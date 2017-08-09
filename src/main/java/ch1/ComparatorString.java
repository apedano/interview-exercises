package ch1;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Alex on 23/07/2017.
 */
public class ComparatorString implements Comparator<ComparatorString>, Serializable {
    private String value;

    public ComparatorString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compare(ComparatorString o1, ComparatorString o2) {
        return o1.value.compareTo(o2.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
