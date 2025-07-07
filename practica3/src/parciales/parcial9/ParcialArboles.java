package parciales.parcial9;

import tp3.ejercicio1_3.GeneralTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
    public List<Integer> primerCaminoAlternanteCeroNoCero(GeneralTree<Integer> arbol) {
        List<Integer> camino = new LinkedList<>();
        if (arbol != null && !arbol.isEmpty()) {
            calcularCamino(arbol, camino, !(arbol.getData() % 10 == 0));
        }
        return camino;
    }


    public static boolean calcularCamino(GeneralTree<Integer> arbol, List<Integer> camino, boolean padreTieneCero) {
        boolean sigo = true;

        if (cumple(arbol.getData(), padreTieneCero)) {
            camino.add(arbol.getData());

            if (arbol.isLeaf()) {
                return false; // camino válido → corto
            }else{
                Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
                while (it.hasNext() && sigo) {
                    sigo = calcularCamino(it.next(), camino, arbol.getData() % 10 == 0);
                }

            }

            if (sigo) {
                camino.remove(camino.size() - 1); // solo hago backtrack si agregué
            }
        }

        return sigo;
    }

    public static boolean cumple(int num, boolean tieneCero) {
        boolean cumple = false;
        if ((num % 10 != 0 && tieneCero) || (num % 10 == 0 && !tieneCero)) cumple = true;
        return cumple;
    }

    public static void main(String[] args) {
        GeneralTree<Integer> raiz = new GeneralTree<>(20);

        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        nodo3.addChild(new GeneralTree<>(42));
        nodo3.addChild(new GeneralTree<>(10));

        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo80 = new GeneralTree<>(80);
        //nodo80.addChild(new GeneralTree<>(8));
        nodo6.addChild(nodo80);
        nodo3.addChild(nodo6); // tercer hijo de 3

        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        nodo7.addChild(new GeneralTree<>(50));

        raiz.addChild(nodo3);
        raiz.addChild(nodo7);

        ParcialArboles p = new ParcialArboles();
        List<Integer> res= p.primerCaminoAlternanteCeroNoCero(raiz);
        System.out.println(res);

    }
}