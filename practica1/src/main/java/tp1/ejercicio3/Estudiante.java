package tp1.ejercicio3;

public class Estudiante extends Persona {
    private String comision, direccion;

    public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
        super(nombre, apellido, email);
        this.comision = comision;
        this.direccion = direccion;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o){
        boolean result = false;
        if ((o != null) && (o instanceof Estudiante)){
            Estudiante e = (Estudiante) o;
            if (this.getNombre().equals(e.getNombre()) &&
                    this.getApellido().equals(e.getApellido()) &&
                    this.getEmail().equals(e.getEmail()) &&
                    this.getComision().equals(e.getComision()) &&
                    this.getDireccion().equals(e.getDireccion())) {
                result = true;
            }
        }
        return result;
    }

    public String tusDatos(){
        return super.tusDatos() + " DIREC: " + getDireccion() + " COMISION: " + getComision();
    }
}
