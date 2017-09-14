package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public class Coords<T extends TwoD> {

    public T[] coordinates;


    public Coords(T[] coordinates) {
        this.coordinates = coordinates;
    }
}
