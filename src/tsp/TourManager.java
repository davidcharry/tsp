package tsp;

import java.util.ArrayList;

public class TourManager {

    private static ArrayList destinoCiudades = new ArrayList<Ciudad>();

    public static void agregarCiudad(Ciudad ciudad) {
        destinoCiudades.add(ciudad);
    }

    public static Ciudad getCiudad(int i){
        return (Ciudad)destinoCiudades.get(i);
    }

    public static int numeroCiudades(){
        return destinoCiudades.size();
    }
    
}