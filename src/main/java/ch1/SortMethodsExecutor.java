package ch1;



import cmn.Commons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 22/07/2017.
 */
public class SortMethodsExecutor {

    public static final void main(String[] args) {
        List<ComparatorString> input = new ArrayList<>(5);
        input.add(new ComparatorString("ferrari"));
        input.add(new ComparatorString("zucca"));
        input.add(new ComparatorString("lee"));
        input.add(new ComparatorString("pino"));
        input.add(new ComparatorString("kill"));
        input.add(new ComparatorString("carota"));
        input.add(new ComparatorString("b"));
        input.add(new ComparatorString("bill"));
        input.add(new ComparatorString("ravanello"));
        List<ComparatorString> output = SortMethods.quickSort(input);
        System.out.print("Lista finale quick sort:");
        System.out.println(Commons.printList(output, ","));
        SortMethods.bubbleSort(input);
        System.out.print("Lista finale bubble sort:");
        System.out.println(Commons.printList(input, ","));
    }

}
