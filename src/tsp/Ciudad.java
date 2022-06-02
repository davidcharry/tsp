package tsp;

public class Ciudad {
    int x;
    int y;

    public Ciudad(){
        this.x = (int)(Math.random()*100);
        this.y = (int)(Math.random()*100);
    }

    public Ciudad(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public double distanciaT(Ciudad ciudad){
        int xDistancia = Math.abs(getX() - ciudad.getX());
        int yDistancia = Math.abs(getY() - ciudad.getY());
        double distancia = Math.sqrt( (xDistancia*xDistancia) + (yDistancia*yDistancia) );
        return distancia;
    }
    
    @Override
    public String toString(){
        return getX()+","+getY();
    }
}