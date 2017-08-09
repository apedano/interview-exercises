package ch6.strategyPattern;

/**
 * Created by Alex on 06/08/2017.
 */
public class StrategyImpl1 implements Strategy {

    private static final String MESSAGE = "Strategy Impl1";

    @Override
    public String doWork() {
        System.out.println(MESSAGE);
        return MESSAGE;
    }

    @Override
    public String getMessage(){
        return MESSAGE;
    }
}
