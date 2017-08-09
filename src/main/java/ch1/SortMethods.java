package ch1;

import cmn.Commons;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 22/07/2017.
 */
public class SortMethods {

    /*
    L'algoritmo scambia gli elementi ad ogni ricorsione
    Si arresta quando un'iterazione fra gli elementi non produce scambi O(n^2) caso peggiore
     */
    public static <E extends Comparator<E>> void bubbleSort(List<E> inputList) {
        boolean changed = true;
        while(changed){
            System.out.print("Lista corrente:");
            System.out.println(Commons.printList(inputList, ","));
            changed=false;
            for (int index = 0; index < inputList.size() - 1; index++) {
                if (inputList.get(index).compare(inputList.get(index), inputList.get(index + 1)) > 0)  {
                    E element = inputList.get(index);
                    inputList.set(index, inputList.get(index + 1));
                    inputList.set(index + 1, element);
                    changed = true;
                }
            }
        }
    }

    /*
        L'algoritmo scompone l'input in tre elemeni la lower list, l'elemento pivot e la higher
        nella lower andranno tutti gli elementi minori del pivot, nella higher viceversa
        Infine si ricompone la lista con l'output delle chiamate ricorsive all'algoritmo e le due sottoliste
        O(n logn) wordst case
     */
    public static <E extends Comparator<E>> List<E> quickSort(List<E> inputList){
        //caso base ricorsione
        if(inputList.size() <= 1){
            return inputList;
        }
        List<E> lower = new LinkedList<E>();
        List<E> higher = new LinkedList<E>();
        E pivot = inputList.get(0);
        for(E element : inputList){
            if(element.compare(element, pivot) < 0){
                lower.add(element);
            }
            if(element.compare(element, pivot) > 0) {
                higher.add(element);
            }
        }
        List<E> out = new LinkedList<E>();
        System.out.print("Lower-list:");
        System.out.println(Commons.printList(lower, ","));
        System.out.print("Pivot:");
        System.out.println(pivot.toString());
        System.out.print("Higher-list:");
        System.out.println(Commons.printList(higher, ","));
        out.addAll(quickSort(lower));
        out.add(pivot);
        out.addAll(quickSort(higher));
        return out;

    }


}
