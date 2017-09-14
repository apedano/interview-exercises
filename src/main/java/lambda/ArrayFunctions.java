package lambda;

/**
 * Created by Alex on 14/09/2017.
 */
public class ArrayFunctions {

    /**
     * Counts occurrences of value in array
     * @param array
     * @param value
     * @return
     */
    public static <T extends Comparable<T>> int countOccurrences(T[] array, T value){
        int count = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i].compareTo(value) == 0){
                count++;
            }
        }
        return count;
    }

}
