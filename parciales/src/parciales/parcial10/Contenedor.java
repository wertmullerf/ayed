package parciales.parcial10;

import java.util.LinkedList;

public class Contenedor {
	private int cantImpares;
	private LinkedList<Integer> listaCumplen;
	
	public Contenedor() {
		this.cantImpares = 0;
		this.listaCumplen = new LinkedList<Integer>();
	}
	
	public int getCantImpares() {
		return cantImpares;
	}
	
	public void setCantImpares(int n) {
		this.cantImpares = n;
	}
	
	public void agregarListaCumplen(int dato) {
		this.listaCumplen.add(dato);
	}
	
	public String toString() {
		String aux = "";
		for(Integer num: listaCumplen) {
			aux+= "NUMERO CUMPLE: " + num  + "\n";
		}
		return aux;
	}
	
}
