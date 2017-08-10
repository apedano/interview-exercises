package ch7;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Alex on 10/08/2017.
 */

public class IteratorCollapser {

    public static <T> Iterator<T> collapse(final List<Iterator<T>> iteratorList) {
        Iterator outIterator = new Iterator<T>() {
            final Iterator<Iterator<T>> iteratorIterator = iteratorList.iterator();
            Iterator<T> currentIterator = iteratorIterator.next();
            @Override
            public boolean hasNext() {
                if(!currentIterator.hasNext()){
                    if(!iteratorIterator.hasNext()){
                        return false;
                    } else {
                        currentIterator = iteratorIterator.next();
                    }
                    hasNext();
                }
                return currentIterator.hasNext();
            }

            @Override
            public T next() {
                hasNext();
                return currentIterator.next();
            }

            @Override
            public void remove() {
                hasNext();
                currentIterator.remove();
            }
        };
        return outIterator;
    }
}
