package tp1.ejercicio1;

public class Impresora {
    public static void entreDosNumerosFor(int a, int b){
        for (int i = a; i <= b; i++) {
            System.out.println("ENTRE DOS NUMEROS FOR: " + i);
        }
    }

    public static void entreDosNumerosWhile(int a, int b){

       while(a <= b){
           System.out.println("ENTRE DOS NUMEROS WHILE: " + a);
           a++;
       }
    }

    public static void entreDosNumerosRecursivo(int a, int b){
        if(a<= b){
            System.out.println("ENTRE DOS NUMEROS RECURSIVO: " + a);
            entreDosNumerosRecursivo(a + 1, b);
        }
    }
}
