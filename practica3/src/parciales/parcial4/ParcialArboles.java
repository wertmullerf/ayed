package parciales.parcial4;

import parciales.binaryTree.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
    public List<Integer> resolver(BinaryTree<Integer> arbol){
        List<Integer> lista = new LinkedList<>();
        if(arbol != null && !arbol.isEmpty()){
            buscar(arbol, lista);
        }
        return lista;
    }

    private boolean cumple(BinaryTree<Integer> ab) {
        if (ab == null || ab.isEmpty()) return false;

        int cantIzq = contarNodos(ab.hasLeftChild() ? ab.getLeftChild() : null);
        int cantDer = contarNodos(ab.hasRightChild() ? ab.getRightChild() : null);

        System.out.println(ab.getData() + " " +cantIzq + " Der: " + cantDer);
        return cantIzq == cantDer;
    }

    // Auxiliar para contar nodos
    private int contarNodos(BinaryTree<Integer> ab) {
        if (ab == null || ab.isEmpty()) {
            return 0;
        }

        int izq = ab.hasLeftChild() ? contarNodos(ab.getLeftChild()) : 0;
        int der = ab.hasRightChild() ? contarNodos(ab.getRightChild()) : 0;

        return  1 +izq + der;
    }

    private void buscar(BinaryTree<Integer> ab, List<Integer> lista){
        if(cumple(ab)){
            lista.add(ab.getData()) ;
        }

        if(ab.hasLeftChild()){
            buscar(ab.getLeftChild(),lista);
        }

        if(ab.hasRightChild()){
            buscar(ab.getRightChild(),lista);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(2);

        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        nodo1.addLeftChild(new BinaryTree<>(16));
        nodo1.addRightChild(new BinaryTree<>(6));

        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
        nodo8.addLeftChild(new BinaryTree<>(22));
        nodo5.addRightChild(nodo8);

        arbol.addLeftChild(nodo1);
        arbol.addRightChild(nodo5);

        ParcialArboles p = new ParcialArboles();
        List<Integer> res = p.resolver(arbol);
        System.out.println(res);

    }
}
