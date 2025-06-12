package tp5.ejercicio5;

public class Jubilado extends Persona {
	private boolean cobroEsteMes;
	
	public Jubilado(String nombre, String domicilio, boolean cobroEsteMes) {
		super(nombre, domicilio);
		this.cobroEsteMes = cobroEsteMes;
	}
	
    public boolean cobroEsteMes() { return cobroEsteMes; }


}
