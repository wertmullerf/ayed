package tp1.ejercicio3;

public class Profesor extends Persona{
    public String catedra, facultad;

    public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
        super(nombre, apellido, email);
        this.catedra = catedra;
        this.facultad = facultad;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String tusDatos(){
        return super.tusDatos() + " FACULTAD:" + getFacultad() + " CATEDRA: " + getCatedra();
    }
}
