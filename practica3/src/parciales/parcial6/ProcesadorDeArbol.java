package parciales.parcial6;


import parciales.binaryTree.BinaryTree;

public class ProcesadorDeArbol {

    public Wrapper resolver(BinaryTree<Integer> arbol){
        Wrapper wrapper = new Wrapper();
        if(arbol != null && !arbol.isEmpty()){
            preOrden(arbol,wrapper);
        }
        return wrapper;
    }
    private boolean cumple(BinaryTree<Integer>ab){
        if((ab.hasLeftChild() && !ab.hasRightChild())||(!ab.hasLeftChild() && ab.hasRightChild())){
            return true;
        }else{
            return false;
        }
    }

    private void preOrden(BinaryTree<Integer> ab, Wrapper wrapper){


        if(ab.hasLeftChild()){
            preOrden(ab.getLeftChild(), wrapper);
        }
        if(ab.hasRightChild()){
            preOrden(ab.getRightChild(), wrapper);
        }

        if(ab.getData() % 2 != 0) {
            wrapper.incrementarImpares();
            if(cumple(ab)){
                wrapper.agregarLista(ab.getData());
            }
        }

    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(10);

// Subárbol izquierdo
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
        nodo6.addLeftChild(nodo1);
        nodo6.addRightChild(nodo9);
        nodo1.addRightChild(new BinaryTree<>(20));
        nodo9.addLeftChild(new BinaryTree<>(11));

// Subárbol derecho
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        nodo2.addLeftChild(nodo8);
        nodo2.addRightChild(nodo3);
        nodo8.addLeftChild(new BinaryTree<>(2));
        nodo8.addRightChild(new BinaryTree<>(4));
        nodo3.addRightChild(new BinaryTree<>(4));

// Enlazar hijos al root
        root.addLeftChild(nodo6);
        root.addRightChild(nodo2);

        ProcesadorDeArbol p = new ProcesadorDeArbol();
        Wrapper wrapper = p.resolver(root);
        System.out.println(wrapper.toString());
    }
}
