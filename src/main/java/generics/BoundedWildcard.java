package generics;

/**
 * Created by Alex on 14/09/2017.
 */
public class BoundedWildcard {


    //Il ? indica un qualunque tipo generico che comunque sia valido ossia che estenda Twod
    //In questo caso non potremmo scrivere T per non obbligare il tipo generico allo stesso tipo della classe T
    //in questo caso il limite inferiore è il tipo di coord
    public static void showXY(Coords<?> coords){
        System.out.println("Show XY coordinates:");
        for(int i=0; i<coords.coordinates.length; i++){
            System.out.println(String.format("x: %d, y:%d", coords.coordinates[i].x, coords.coordinates[i].y));
        }
    }

    //Qui necessitiamo di ridefinire un limite inferiore al tipo generico cui è applicabile il metodo
    public static void showXYZ(Coords<? extends ThreeD> coords){
        System.out.println("Show XYZ coordinates:");
        for(int i=0; i<coords.coordinates.length; i++){
            System.out.println(String.format("x: %d, y:%d, z:%d", coords.coordinates[i].x, coords.coordinates[i].y, coords.coordinates[i].z));
        }
    }

    //Qui necessitiamo di ridefinire un limite inferiore al tipo generico cui è applicabile il metodo
    public static void showAll(Coords<? extends FourD> coords){
        System.out.println("Show XYZT coordinates:");
        for(int i=0; i<coords.coordinates.length; i++){
            System.out.println(String.format("x: %d, y:%d, z:%d, t:%d", coords.coordinates[i].x, coords.coordinates[i].y, coords.coordinates[i].z, coords.coordinates[i].t));
        }
    }
}
