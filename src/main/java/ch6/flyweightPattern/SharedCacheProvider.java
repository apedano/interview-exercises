package ch6.flyweightPattern;

import ch6.builderPattern.Car;

import java.util.HashMap;;

import java.util.Map;

/**
 * Created by Alex on 08/08/2017.
 */
public class SharedCacheProvider {

    private static final HashMap<Integer, Car> cache;

    //questo codice sarà comune per tutte le istanze della classe e sarà eseguito quando la JVM istanzierà
    // un'istanza per la prima volta
    static {
        cache = new HashMap<Integer, Car>();
        cache.put(1, (new Car.Builder().manufacturer("fiat").model("punto").cc(1300)).alimentation("diesel").build());
        cache.put(2, (new Car.Builder().manufacturer("mercedes").model("classe a").cc(1600)).alimentation("benzina").build());
        cache.put(3, (new Car.Builder().manufacturer("opel").model("corsa").cc(1100)).alimentation("benzina").build());
        //default value
        cache.put(0, (new Car.Builder().manufacturer("ferrari").model("488").cc(3902)).alimentation("benzina").build());
    }

    public Car carOfValue(Integer i){
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        return cache.get(0);
    }

}
