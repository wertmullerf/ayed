package tp1.ejercicio7;

import tp1.ejercicio3.Estudiante;

import java.util.*;

public class TestArrayList {
     static List<Integer> list = new ArrayList<>();

    public List<Estudiante> generarListaEstudiantes(){
        List<Estudiante> arrayList = new ArrayList<>();
        arrayList.add(new Estudiante("Facundo", "Wertmuller", "fwertmuller@gmail.com", "10B", "7N333"));
        arrayList.add(new Estudiante("Joaquin", "Wertmuller", "fwertmuller@gmail.com", "10B", "7N333"));
        arrayList.add(new Estudiante("Ramiro", "Wertmuller", "fwertmuller@gmail.com", "10B", "7N333"));

        return arrayList;
    }

    //■ genere una nueva lista que sea una copia de la lista del inciso i
    public List<Integer> generarCopia(){
        return new ArrayList<Integer>(list); //clona la list
    }


    public void agregarEstudiante(Estudiante e, ArrayList<Estudiante> estudiantes){
        boolean existe = false;
        for (Estudiante estudiante: estudiantes){
            if (estudiante.equals(e))existe = true;
        }

        if(!existe){
            estudiantes.add(e);
        }
    }


    public boolean esCapicua(List<Integer> lista){
        List<Integer> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0 ; i--) {
            listaInvertida.add(lista.get(i));
        }

        boolean sonIguales= true;
        for (int i = 0; i <listaInvertida.size() ; i++) {
            if(!listaInvertida.get(i).equals(lista.get(i))) sonIguales = false;
        }
        return sonIguales;
    }

    //Implemente un método recursivo que invierta el orden de los elementos en un
    //ArrayList.

    public  void invertirArrayList(ArrayList<Integer> lista){
        List<Integer> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0 ; i--) {
            listaInvertida.add(lista.get(i));
        }

        for(Integer num: listaInvertida){
            System.out.println(num);
        }
    }

    //Implemente un método recursivo que calcule la suma de los elementos en un LinkedList.
    public int sumarLinkedList(LinkedList<Integer> lista) {
        return (lista == null || lista.isEmpty()) ? 0 : sumaDesdeIndice(lista, 0);
    }

    private int sumaDesdeIndice(LinkedList<Integer> lista, int i) {
        return (i == lista.size()) ? 0 : lista.get(i) + sumaDesdeIndice(lista, i + 1);
    }

    public void imprimirLista(LinkedList<Integer> lista){
        if (!lista.isEmpty()){
            for (Integer num: lista){
                System.out.println("NUMERO: "+ num);
            }
        }
    }
    /*
    Implemente el método “combinarOrdenado” que reciba 2 listas de números ordenados
    y devuelva una nueva lista también ordenada conteniendo los elementos de las 2 listas.

    * */

    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        ArrayList<Integer> listaCombinada = new ArrayList<>();
        int indiceL1 = 0;
        int indiceL2 = 0;

        //agregamos de manera ordenada. Sale del while cuando se cumpla alguna de las dos condiciones
        while((indiceL1 <lista1.size()) && (indiceL2 < lista2.size())){
            if (lista1.get(indiceL1) < lista2.get(indiceL2)){
                listaCombinada.add(lista1.get(indiceL1));
                indiceL1++;
            }else{
                listaCombinada.add(lista2.get(indiceL2));
                indiceL2++;
            }
        }

        //aca hacemos dos while. Porque quizas falta recorrer l1 o l2
        //de esta manera nos aseguramos que se recorran ambas listas.
        while (indiceL1 < lista1.size()) {
            listaCombinada.add(lista1.get(indiceL1));
            indiceL1++;
        }

        while (indiceL2 < lista2.size()) {
            listaCombinada.add(lista2.get(indiceL2));
            indiceL2++;
        }
        return listaCombinada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestArrayList test = new TestArrayList();
        int num = scanner.nextInt();
        while(num != 0){
            list.add(num);
            num = scanner.nextInt();
        }
        Iterator<Integer> iterador = list.iterator();

        while(iterador.hasNext()){
            Integer numIT = iterador.next();
          //  System.out.println(numIT);
        }

        //System.out.println("Contenido del ArrayList \n");
        for(int listNumber: list){
            System.out.println(listNumber);
        }
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);


        test.invertirArrayList(numeros);
     //   System.out.println("ES CAPICUA: " + esCapicua(numeros));


        LinkedList<Integer> numerosLinkedList = new LinkedList<>();
        numeros.add(5);
        numeros.add(10);
        numeros.add(3);

        int resultado = test.sumarLinkedList(numerosLinkedList);
        System.out.println("Suma: " + resultado); // Suma: 18

        System.out.println("===============================");
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1,2, 3, 5));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(2, 4, 6));

        ArrayList<Integer> resultadoCombinado = test.combinarOrdenado(l1, l2);
        System.out.println(resultadoCombinado); // [1, 2, 3, 4, 5, 6]
    }
}
