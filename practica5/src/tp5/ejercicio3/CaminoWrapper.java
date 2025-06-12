package tp5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class CaminoWrapper {
	private int cantTanquesCargados;
	private List<String> camino;
	private int tanque; 
	
	public CaminoWrapper(int tanque) {
		this.camino = new LinkedList<>();
		this.cantTanquesCargados = 0;
		this.tanque = tanque;
	}
	public CaminoWrapper(int tanque, Integer cantTanques) {
		this.camino = new LinkedList<>();
		this.cantTanquesCargados = cantTanques; // MAX VALUE
		this.tanque = tanque;
	}
	public int getCantTanquesCargados() {
		return cantTanquesCargados;
	}
	public void setCantTanquesCargados(int cantTanquesCargados) {
		this.cantTanquesCargados = cantTanquesCargados;
	}
	public List<String> getCamino() {
		return camino;
	}

	public void agregarCiudad(String ciudad) {
		this.camino.add(ciudad);
	}

	public void copiarDesde(CaminoWrapper otro) {
	    this.cantTanquesCargados = otro.getCantTanquesCargados();
	    this.camino.clear();
	    this.camino.addAll(otro.getCamino());
	    
	}
	
	public void incrementarTanquesUsados() {
		this.cantTanquesCargados++;
	}
	
	public void recargarTanque(int x) {
		this.tanque = x;
	}
	
	public void decrementarTanque(int x) {
		this.tanque = this.tanque - x;
	}
	
	public int getTanque() {
		return this.tanque;
	}
	
}
