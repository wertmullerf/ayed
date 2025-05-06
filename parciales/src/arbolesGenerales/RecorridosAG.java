package arbolesGenerales;

import java.util.*;

public class RecorridosAG {
    /*-----------------------INCISO A -----------------------*/
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> impares = new ArrayList<>();
        preOrden(a, impares, n);
        return impares;
    }

    private List<Integer> preOrden(GeneralTree<Integer> arbol, List<Integer> lista, Integer n){
        if((arbol.getData() % 2 != 0) &&(arbol.getData() > n)){
            lista.add(arbol.getData());
        }
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child: children){
            preOrden(child, lista, n);
        }
        return lista;

    }
    /*-----------------------INCISO B -----------------------*/
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> impares = new ArrayList<>();
        inOrden(a, impares, n);
        return impares;
    }

    private List<Integer> inOrden(GeneralTree<Integer> arbol, List<Integer> lista, Integer n){
        List<GeneralTree<Integer>> children = arbol.getChildren();
        Iterator<GeneralTree<Integer>> it = children.iterator();
        if(it.hasNext()){
            GeneralTree<Integer> child = it.next();
            inOrden(child, lista,n);
        }

        if((arbol.getData() % 2 != 0) &&(arbol.getData() > n)){
            lista.add(arbol.getData());
        }

        while(it.hasNext()){
            GeneralTree<Integer> child = it.next();
            inOrden(child, lista,n);
        }
        return lista;

    }

    /*-----------------------INCISO C -----------------------*/
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> impares = new ArrayList<>();
        postOrden(a, impares, n);
        return impares;
    }

    private List<Integer> postOrden(GeneralTree<Integer> arbol, List<Integer> lista, Integer n){

        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child: children){
            postOrden(child, lista, n);
        }
        if((arbol.getData() % 2 != 0) &&(arbol.getData() > n)){
            lista.add(arbol.getData());
        }
        return lista;

    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,  Integer n){
        List<Integer> impares = new ArrayList<>();
        Queue<GeneralTree<Integer>> cola = new LinkedList<>(); // no tengo la clase Queue
        GeneralTree<Integer> arbolAux;
        cola.offer(a);
        while(!cola.isEmpty()){
            arbolAux = cola.poll();
            if((arbolAux.getData() % 2 != 0) &&(arbolAux.getData() > n)){
                impares.add(arbolAux.getData());
            }

            if(arbolAux.hasChildren()){
                for (GeneralTree<Integer> child: arbolAux.getChildren()){
                    cola.offer(child);
                }
            }

        }
        return impares;
    }
    /*-----------------------INCISO D -----------------------*/

    public static void main(String[] args) {
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        nodo5.addChild(nodo3);
        nodo5.addChild(nodo7);

        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);

        GeneralTree<Integer> nodo15 = new GeneralTree<>(15);
        GeneralTree<Integer> nodo13 = new GeneralTree<>(13);
        nodo13.addChild(nodo15);

        GeneralTree<Integer> raiz = new GeneralTree<>(10);
        raiz.addChild(nodo5);
        raiz.addChild(nodo8);
        raiz.addChild(nodo13);

        RecorridosAG test = new RecorridosAG();
        List<Integer> lista =test.numerosImparesMayoresQuePorNiveles(raiz, 10);

        System.out.println(lista);

        GeneralTree<Integer> raiz2 = new GeneralTree<>();int acc = 0;

        System.out.println("Ancho: " + raiz.ancho() );
    }
}
