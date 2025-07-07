package tp5.parcial1;

public class Ciudad {
	private String nombre;
	private int cantidadDeDias;
	
	public Ciudad(String nombre, int cant) {
		this.nombre = nombre;
		this.cantidadDeDias = cant;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCantidadDeDias() {
		return this.cantidadDeDias;
	}
	
}
