package parciales.parcial6;

import java.util.LinkedList;
import java.util.List;

public class Wrapper {
    private int cantImpares;
    private List<Integer> lista;

    public Wrapper() {
        this.cantImpares =0;
        this.lista = new LinkedList<>();
    }

    public void agregarLista(int dato){
        this.lista.add(dato);
    }

    public void incrementarImpares(){
        this.cantImpares++;
    }

    public String toString(){
        String aux = "Cant Impares: " +this.cantImpares + "\n" + " Lista: [";
        for (Integer num:lista){
            aux+= num + ", ";
        }
        aux += "]";
        return aux;
    }
}
