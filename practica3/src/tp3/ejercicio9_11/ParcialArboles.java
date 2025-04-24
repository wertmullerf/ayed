package tp3.ejercicio9_11;

import tp3.ejercicio1_3.GeneralTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParcialArboles {

    public ParcialArboles(){}
    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        if(arbol != null && !arbol.isEmpty()) {
            Integer padre = arbol.getData();
            List<GeneralTree<Integer>> children = arbol.getChildren();
            Iterator<GeneralTree<Integer>> it = children.iterator();
            while (it.hasNext()) {
                GeneralTree<Integer> child = it.next();
                System.out.print(child.getData() + " ");
                if (child.getData() < padre) {
                    return false;
                }
                if(!esDeSeleccion(child)){
                    return false;
                }
            }
        }
        return true; //--> en las hojas o que no sea ni menor o cumpla la condicion de ser >
    }


    public static boolean resolverPunto11(GeneralTree<Integer> arbol){
        Queue<GeneralTree<Integer>> cola = new LinkedList<>();
        GeneralTree<Integer> arbolAux;
        cola.offer(arbol);
        cola.offer(null);
        boolean cumple =true;
        int anterior = 0;
        int actual = 0;
        while(!cola.isEmpty() && cumple){
            arbolAux = cola.poll();
            if(arbolAux !=null){
                if(arbol.hasChildren()){
                    for (GeneralTree<Integer> child: arbolAux.getChildren()){
                        actual++;
                        cola.offer(child);
                    }
                }
            }else{
                if (!cola.isEmpty()){
                    if(actual <= anterior){
                        cumple = false;
                    }else{
                        cola.offer(null);
                        anterior = actual;
                        actual = 0;
                    }
                }
            }
        }

        return cumple;
    }

    public static List<Integer> resolverPunto10(GeneralTree<Integer> arbol){
        List<Integer> lista = new LinkedList<>();
        List<Integer> camino = new LinkedList<>();
        int[] maxValor ={ -1};
        calcularCamino(arbol,0,0,lista,camino,maxValor);
        return camino;
    }

    private static List<Integer> calcularCamino(GeneralTree<Integer> arbol, int nivel, int sumaActual, List<Integer> lista, List<Integer> camino, int[] maxValor) {
        int valor = arbol.getData();
        sumaActual += valor * nivel;

        //boolean agregado = false;
        //if (valor == 1) {
            lista.add(valor);
           // agregado = true;
        //}

        if (arbol.isLeaf()) {
            if (sumaActual > maxValor[0]) {
                maxValor[0] = sumaActual;
                camino.clear();
                camino.addAll(lista);
            }
        } else {
            for (GeneralTree<Integer> child : arbol.getChildren()) {
                calcularCamino(child, nivel + 1, sumaActual, lista, camino, maxValor);
            }
        }

       // if (agregado) {
            lista.remove(lista.size() - 1); // backtracking solo si agregaste
        //}

        return camino;
    }
    public static void main(String[] args) {
        // Nivel 2 (hojas)
        GeneralTree<Integer> nodo80 = new GeneralTree<>(80);
        GeneralTree<Integer> nodo75 = new GeneralTree<>(75);
        GeneralTree<Integer> nodo90 = new GeneralTree<>(90);

        // Nivel 1 (intermedios)
        GeneralTree<Integer> nodo60 = new GeneralTree<>(60);
        nodo60.addChild(nodo80);
        nodo60.addChild(nodo75);

        //nodo75.addChild(new GeneralTree<Integer>(10));
        GeneralTree<Integer> nodo55 = new GeneralTree<>(55);
        nodo55.addChild(nodo90);

        GeneralTree<Integer> nodo70 = new GeneralTree<>(70);
        GeneralTree<Integer> nodo65 = new GeneralTree<>(65);

        // Raíz
        GeneralTree<Integer> nodo50 = new GeneralTree<>(50);
        nodo50.addChild(nodo60);
        nodo50.addChild(nodo55);
        //nodo50.addChild(nodo70);
        //nodo50.addChild(nodo65);

        // Prueba
        boolean seleccion = esDeSeleccion(nodo50);
        System.out.println("¿Es árbol de selección (punto 9)? " + seleccion);
        System.out.println("¿Es creciente (punto 11)? " + resolverPunto11(nodo50));
    }
}
