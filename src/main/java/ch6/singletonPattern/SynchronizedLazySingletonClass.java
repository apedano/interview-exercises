package ch6.singletonPattern;

/**
 * Created by Alex on 09/08/2017.
 */
public class SynchronizedLazySingletonClass {
    private static SynchronizedLazySingletonClass INSTANCE = null;

    private SynchronizedLazySingletonClass(){}

    //metodo thread-safe
    public SynchronizedLazySingletonClass getInstance(){
        if(INSTANCE == null){
            //molti thread si possono trovare in questo punto, il che, senza il blocco
            //sync si avrebbero divere istanze di INSTANCE (differenti invocazioni del costruttore)
            //per cui usiamo il DOUBLE CHECK SYNCHRONIZATION
            synchronized (SynchronizedLazySingletonClass.class) {
                if(INSTANCE == null){
                    INSTANCE = new SynchronizedLazySingletonClass();
                }
            }
        }
        return INSTANCE;
    }
}
