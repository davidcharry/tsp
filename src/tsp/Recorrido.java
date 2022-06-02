package tsp;

import java.util.ArrayList;
import java.util.Collections;

public class Recorrido {

    private ArrayList recorrido = new ArrayList<Ciudad>();
    private int distancia = 0;

    public Recorrido() {
        for (int i = 0; i < TourManager.numeroCiudades(); i++) {
            recorrido.add(null);
        }
    }

    public Recorrido(ArrayList recorrido) {
        this.recorrido = (ArrayList) recorrido.clone();
    }

    public ArrayList getTour() {
        return recorrido;
    }

    public void generateIndividual() {
        for (int i = 0; i < TourManager.numeroCiudades(); i++) {
            setCiudad(i, TourManager.getCiudad(i));
        }
        Collections.shuffle(recorrido);
    }

    public Ciudad getCiudad(int Posicion) {
        return (Ciudad) recorrido.get(Posicion);
    }

    public void setCiudad(int Posicion, Ciudad ciudad) {
        recorrido.set(Posicion, ciudad);
        distancia = 0;
    }

    public int getDistancia() {
        if (distancia == 0) {
            int rDistancia = 0;
            for (int i = 0; i < Rec(); i++) {
                Ciudad fromCity = getCiudad(i);
                Ciudad destinoCiudades;
                if (i + 1 < Rec()) {
                    destinoCiudades = getCiudad(i + 1);
                } else {
                    destinoCiudades = getCiudad(0);
                }
                rDistancia += fromCity.distanciaT(destinoCiudades);
            }
            distancia = rDistancia;
        }
        return distancia;
    }

    public int Rec() {
        return recorrido.size();
    }

    @Override
    public String toString() {
        String m = " |";
        for (int i = 0; i < Rec(); i++) {
            m += getCiudad(i) + "|";
        }
        return m;
    }
}
