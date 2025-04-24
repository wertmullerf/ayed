package tp3.ejercicio4;

import tp3.ejercicio1_3.GeneralTree;

import java.util.LinkedList;
import java.util.Queue;

public class AnalizadorArbol {
    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol){
        Queue<GeneralTree<AreaEmpresa>> cola = new LinkedList<>(); // no tengo la clase Queue
        GeneralTree<AreaEmpresa> arbolAux;
        cola.offer(arbol);
        cola.offer(null);
        double acc = 0;
        double max = -1;
        int cantNodos = 0;
        while(!cola.isEmpty()){

            arbolAux = cola.poll();
            if(arbolAux != null){
                acc+= arbolAux.getData().getTardanza(); // --> acumulo la tardanza por nivel
                cantNodos++;  
                if(arbolAux.hasChildren()){
                    for (GeneralTree<AreaEmpresa> child: arbolAux.getChildren()){
                        cola.offer(child);
                    }
                }
            }else {
                System.out.println(acc  +" " +  cantNodos);
                acc = acc / cantNodos;
                if(acc > max) max = acc;
                if(!cola.isEmpty()){
                    cola.offer(null);
                }
                acc =0;
                cantNodos = 0;
            }
        }

        return max;

    }

   
   
   
    public static void main(String[] args) {
        AnalizadorArbol analizador = new AnalizadorArbol();

        GeneralTree<AreaEmpresa> a = new GeneralTree<>(new AreaEmpresa("A", 4));
        GeneralTree<AreaEmpresa> b = new GeneralTree<>(new AreaEmpresa("B", 7));
        GeneralTree<AreaEmpresa> c = new GeneralTree<>(new AreaEmpresa("C", 5));
        GeneralTree<AreaEmpresa> d = new GeneralTree<>(new AreaEmpresa("D", 6));
        GeneralTree<AreaEmpresa> e = new GeneralTree<>(new AreaEmpresa("E", 10));
        GeneralTree<AreaEmpresa> f = new GeneralTree<>(new AreaEmpresa("F", 18));
        GeneralTree<AreaEmpresa> g = new GeneralTree<>(new AreaEmpresa("G", 9));
        GeneralTree<AreaEmpresa> h = new GeneralTree<>(new AreaEmpresa("H", 12));
        GeneralTree<AreaEmpresa> i = new GeneralTree<>(new AreaEmpresa("I", 19));

        // Nivel 1
        GeneralTree<AreaEmpresa> j = new GeneralTree<>(new AreaEmpresa("J", 13));
        j.addChild(a);
        j.addChild(b);
        j.addChild(c);

        GeneralTree<AreaEmpresa> k = new GeneralTree<>(new AreaEmpresa("K", 25));
        k.addChild(d);
        k.addChild(e);
        k.addChild(f);

        GeneralTree<AreaEmpresa> l = new GeneralTree<>(new AreaEmpresa("L", 10));
        l.addChild(g);
        l.addChild(h);
        l.addChild(i);

        // Nivel 0 (raíz)
        GeneralTree<AreaEmpresa> m = new GeneralTree<>(new AreaEmpresa("M", 14));
        m.addChild(j);
        m.addChild(k);
        m.addChild(l);

        // Ahora m representa la raíz del árbol completo.
        System.out.println("Árbol cargado correctamente.");
        System.out.println("Nivel con mayor tardanza: " + analizador.devolverMaximoPromedio(m));
    }
}
