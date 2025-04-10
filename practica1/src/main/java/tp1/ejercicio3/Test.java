package tp1.ejercicio3;

public class Test {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[2];
        estudiantes[0] = new Estudiante("Facundo", "Wertmuller", "fwertmuller@gmail.com", "10A", "7 N3773");
        estudiantes[1] = new Estudiante("Joaquin", "Wertmuller", "fwertmuller@gmail.com", "10A", "7 N3773");
        //DEBERIA USARSE SETTERS  POR LA CONSIGNA PERO ES MUY LARGO E INNECESARIO
        Profesor[] profesores = new Profesor[3];
        profesores[0] = new Profesor("Veronica", "Gomez", "vgomez@gmail.com", "TALLER", "Informatica");
        profesores[1] = new Profesor("Justina", "Smith", "jsmith@gmail.com", "Algoritmos", "Ingenieria");
        profesores[2] = new Profesor("Luciana", "Alvarado", "lalvarado@gmail.com", "CUALQ", "Informatica");

        for (Estudiante estudiante: estudiantes){
            System.out.println(estudiante.tusDatos() );
        }
        for (Profesor profesor: profesores){
            System.out.println(profesor.tusDatos() );
        }
    }
}
