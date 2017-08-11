package ch8;

/**
 * Created by Alex on 11/08/2017.
 * Works like abstract classes
 */
public interface Java8Interface {

    void alpha();
    default int beta() {return 6;}
}
