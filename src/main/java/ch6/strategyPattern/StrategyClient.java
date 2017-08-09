package ch6.strategyPattern;

/**
 * Created by Alex on 06/08/2017.
 */
public class StrategyClient {

    private static final String MESSAGE_FORMAT = "Executing client with [%s] strategy implementation";

    private Strategy strategy;

    public StrategyClient(Strategy strategy){
        this.strategy = strategy;
    }

    public String clientRun(){
        String strategyImpl = strategy.doWork();
        System.out.println(String.format(MESSAGE_FORMAT, strategyImpl));
        return strategyImpl;
    }
}
