package ch8;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Alex on 11/08/2017.
 */
public class CovarianceList {

    public static List<? extends A> covarianceOperation(List<? extends A> input){
        return input;
    }

    public static List<A> dummyOperation(List<A> input){
        return input;
    }

}
