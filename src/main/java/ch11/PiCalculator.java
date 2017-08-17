package ch11;

import java.util.concurrent.Callable;

/**
 * Created by Alex on 14/08/2017.
 */
public class PiCalculator implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        double currVal = 1.0;
        double nextVal = 0.0;
        double denominator = 1.0;
        for(int i = 0;
            Math.abs(nextVal - currVal) > 0.000000001d;
                denominator += 2, i++){
            currVal = nextVal;
            if(i % 2 == 1){
                nextVal = currVal - (1/ denominator);
            } else {
                nextVal = currVal + (1/ denominator);
            }
        }

        return currVal * 4;
    }
}
