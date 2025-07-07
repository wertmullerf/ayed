package tp5.parcial3;

import java.util.LinkedList;
import java.util.List;

public class CaminoConDistancia {
    private List<String> camino;
    private int distancia;

    public CaminoConDistancia(List<String> camino, int distancia) {
        this.camino = new LinkedList<>(camino);
        this.distancia = distancia;
    }

    public List<String> getCamino() {
        return camino;
    }

    public int getDistancia() {
        return distancia;
    }
}
