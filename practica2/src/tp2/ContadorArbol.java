package tp2;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
    private BinaryTree<Integer> ab;
    public  ContadorArbol(BinaryTree<Integer> ab){
        this.ab = ab;
    }

    private void inOrden(BinaryTree<Integer> nodo, List<Integer> lista){
        if (nodo == null || nodo.getData() == null) return;
        if (nodo.hasLeftChild()) {
            this.inOrden(nodo.getLeftChild(),lista);
        }

        if(nodo.getData() % 2 == 0){
            lista.add(nodo.getData());
        }
        if (nodo.hasRightChild()) {
            this.inOrden(nodo.getRightChild(),lista);
        }
    }
    private void postOrden(BinaryTree<Integer> nodo, List<Integer> lista){
        if (nodo == null || nodo.getData() == null) return;
        if (nodo.hasLeftChild()) {
            this.postOrden(nodo.getLeftChild(),lista);
        }
        if (nodo.hasRightChild()) {
            this.postOrden(nodo.getRightChild(),lista);
        }

        if(nodo.getData() % 2 == 0){
            lista.add(nodo.getData());
        }
    }
    public List<Integer> numerosPares(){
        List<Integer> lista = new ArrayList<>();
        inOrden(this.ab, lista);
        //postOrden(this.ab,lista);
        return lista;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(8);
        arbol.addLeftChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(10));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(5));

        ContadorArbol contador = new ContadorArbol(arbol);
        System.out.println(contador.numerosPares()); // [8, 2, 10]
    }
}
