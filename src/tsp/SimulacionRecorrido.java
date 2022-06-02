package tsp;

public class SimulacionRecorrido {

    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        if (newEnergy < energy) {
            return 1.0;
        }
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        Ciudad ciudad = new Ciudad(60, 200);
        TourManager.agregarCiudad(ciudad);
        Ciudad ciudad2 = new Ciudad(180, 200);
        TourManager.agregarCiudad(ciudad2);
        Ciudad ciudad3 = new Ciudad(80, 180);
        TourManager.agregarCiudad(ciudad3);
        Ciudad ciudad4 = new Ciudad(140, 180);
        TourManager.agregarCiudad(ciudad4);
        Ciudad ciudad5 = new Ciudad(20, 160);
        TourManager.agregarCiudad(ciudad5);
        Ciudad ciudad6 = new Ciudad(100, 160);
        TourManager.agregarCiudad(ciudad6);
        Ciudad ciudad7 = new Ciudad(200, 160);
        TourManager.agregarCiudad(ciudad7);
        Ciudad ciudad8 = new Ciudad(140, 140);
        TourManager.agregarCiudad(ciudad8);
        Ciudad ciudad9 = new Ciudad(40, 120);
        TourManager.agregarCiudad(ciudad9);
        Ciudad ciudad10 = new Ciudad(100, 120);
        TourManager.agregarCiudad(ciudad10);
        Ciudad ciudad11 = new Ciudad(180, 100);
        TourManager.agregarCiudad(ciudad11);
        Ciudad ciudad12 = new Ciudad(60, 80);
        TourManager.agregarCiudad(ciudad12);
        Ciudad ciudad13 = new Ciudad(120, 80);
        TourManager.agregarCiudad(ciudad13);
        Ciudad ciudad14 = new Ciudad(180, 60);
        TourManager.agregarCiudad(ciudad14);
        Ciudad ciudad15 = new Ciudad(20, 40);
        TourManager.agregarCiudad(ciudad15);
        Ciudad ciudad16 = new Ciudad(100, 40);
        TourManager.agregarCiudad(ciudad16);
        Ciudad ciudad17 = new Ciudad(200, 40);
        TourManager.agregarCiudad(ciudad17);
        Ciudad ciudad18 = new Ciudad(20, 20);
        TourManager.agregarCiudad(ciudad18);
        Ciudad ciudad19 = new Ciudad(60, 20);
        TourManager.agregarCiudad(ciudad19);
        Ciudad ciudad20 = new Ciudad(160, 20);
        TourManager.agregarCiudad(ciudad20);
        double temp = 10000;
        double coolingRate = 0.003;
        Recorrido currentSolution = new Recorrido();
        currentSolution.generateIndividual();
        System.out.println("Distancia incial: " + currentSolution.getDistancia());
        Recorrido best = new Recorrido(currentSolution.getTour());
        while (temp > 1) {
            Recorrido newSolution = new Recorrido(currentSolution.getTour());
            int tourPos1 = (int) (newSolution.Rec()* Math.random());
            int tourPos2 = (int) (newSolution.Rec() * Math.random());
            Ciudad citySwap1 = newSolution.getCiudad(tourPos1);
            Ciudad citySwap2 = newSolution.getCiudad(tourPos2);
            newSolution.setCiudad(tourPos2, citySwap1);
            newSolution.setCiudad(tourPos1, citySwap2);
            int currentEnergy = currentSolution.getDistancia();
            int neighbourEnergy = newSolution.getDistancia();
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentSolution = new Recorrido(newSolution.getTour());
            }
            if (currentSolution.getDistancia() < best.getDistancia()) {
                best = new Recorrido(currentSolution.getTour());
            }
            temp *= 1 - coolingRate;
        }

        System.out.println("Distancia Final " + best.getDistancia());
        System.out.println("Ciudad" + best );
    }
}
