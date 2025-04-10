package tp1.ejercicio2;

public class Generador {
    public static int[] generarArreglo(int pos){
        int[] arreglo = new int[pos];
        for (int i = 0; i < pos; i++) {
            arreglo[i] = (pos) * (i + 1);
        }
        return arreglo;
    }
}
