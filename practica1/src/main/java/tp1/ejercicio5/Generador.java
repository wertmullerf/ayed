package tp1.ejercicio5;

public class Generador {
    // Arreglo y resultado estáticos para el método sin parámetros ni return
    static int[] arregloGlobal = {2,50,9,1,0,200, 10000};
    static Auxiliar resultadoGlobal = new Auxiliar();

    public static Auxiliar calcularValores(int[] arreglo){
        int maxValue = -1;
        int minValue = 999;
        double promedioNums;
        int acc = 0;
        for (int num:arreglo){
            if(num >maxValue){
                maxValue = num;
            }
            if(num < minValue){
                minValue = num;
            }
            acc+= num;
        }
        promedioNums = ((double) acc / arreglo.length);

        return new Auxiliar(minValue,maxValue,promedioNums);
    }

    public static void calcularValoresSinReturn(int[] arreglo, Auxiliar aux){
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        double promedioNums;
        int acc = 0;
        for (int num:arreglo){
            if(num >maxValue) maxValue = num;
            if(num < minValue) minValue = num;

            acc+= num;
        }
        promedioNums = ((double) acc / arreglo.length);
        aux.setPromedio(promedioNums);
        aux.setValorMax(maxValue);
        aux.setValorMin(minValue);
    }


    public static void calcularValoresSinParametrosNiReturn() {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int acc = 0;
        double promedioNums;

        for (int num : arregloGlobal) {
            if (num > maxValue) maxValue = num;
            if (num < minValue) minValue = num;
            acc += num;
        }

        promedioNums = (double) acc / arregloGlobal.length;

        // Guardamos el resultado directamente en la variable estática
        resultadoGlobal.setValorMin(minValue);
        resultadoGlobal.setValorMax(maxValue);
        resultadoGlobal.setPromedio(promedioNums);
    }
    public static void main(String[] args) {

        //CON RETORNO
        int[] arreglo = {2,50,9,1,0,200, 10000};
        Auxiliar valores = calcularValores(arreglo);
        System.out.println("VALOR MIN: " + valores.getValorMin());
        System.out.println("VALOR MAX: " + valores.getValorMax());
        System.out.println("PROMEDIO: " + valores.getPromedio());

        System.out.println("--------------------------");
        //A TRAVES DE UN PARAMETRO
        Auxiliar aux2 = new Auxiliar();
        calcularValoresSinReturn(arreglo,aux2);
        System.out.println("VALOR MIN: " + valores.getValorMin());
        System.out.println("VALOR MAX: " + valores.getValorMax());
        System.out.println("PROMEDIO: " + valores.getPromedio());


        System.out.println("--------------------------");

        //SIN RETURN NI PARAMETROS --> Static como global de la claseq
        // Inciso C
        calcularValoresSinParametrosNiReturn();
        System.out.println("VALOR MIN (C): " + resultadoGlobal.getValorMin());
        System.out.println("VALOR MAX (C): " + resultadoGlobal.getValorMax());
        System.out.println("PROMEDIO (C): " + resultadoGlobal.getPromedio());
    }
}
