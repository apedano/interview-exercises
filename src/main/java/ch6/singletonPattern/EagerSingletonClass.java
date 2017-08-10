package ch6.singletonPattern;

/**
 * Created by Alex on 09/08/2017.
 */
public class EagerSingletonClass {

    private static EagerSingletonClass INSTANCE = new EagerSingletonClass();

    //il costruttore privato inibisce la possibilità di creare l'istanza singleton dall'esterno
    private EagerSingletonClass(){

    }

    public EagerSingletonClass getInstance(){
        return this.INSTANCE;
    }
}
