package tp1.ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner pos = new Scanner(System.in);
        System.out.println("INGRESE LA CANTIDAD DE POSICIONES DEL ARREGLO");
        int[] arreglo = Generador.generarArreglo(pos.nextInt());
//        for (int i = 0; i <arreglo.length ; i++) {
//            System.out.println(arreglo[i]);
//        }
        for(int num: arreglo){
            System.out.println(num);
        }
    }
}
