package ch6.singletonPattern;

/**
 * Created by Alex on 09/08/2017.
 */
public class SingletonClass {

    //necessitiamo della classe statica per invocare il parametro statico.
    //La classe SingletonClass non deve essere necessariamente statica

    private static class SingletonClassHolder {
        private static final SingletonClass INSTANCE = new SingletonClass();
    }

    //il costruttore privato inibisce la possibilità di creare l'istanza singleton dall'esterno
    private SingletonClass(){
    }

    //questa tecnica usa il memory model di Java: la classe inner Holder non viene mai istanziata finchè
    //non viene invocato per la prima volta l'instance e non necessita di sincronizzazione
    public SingletonClass getInstance(){
        return SingletonClassHolder.INSTANCE;
    }

}
