package ch6.singletonPattern;

/**
 * Created by Alex on 09/08/2017.
 */
public class StaticBlockSingletonClass {

    private static StaticBlockSingletonClass INSTANCE;

    static {
        INSTANCE = new StaticBlockSingletonClass();
    }

    //il costruttore privato inibisce la possibilità di creare l'istanza singleton dall'esterno
    private StaticBlockSingletonClass() {

    }

    public StaticBlockSingletonClass getInstance() {
        return this.INSTANCE;
    }
}


