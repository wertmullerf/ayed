package parciales.parcial2;

import parciales.binaryTree.BinaryTree;

public class ParcialArboles {

    public BinaryTree<SumAndDif> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<SumAndDif> arbol2 = new BinaryTree<>();
        if(arbol == null || arbol.isEmpty()) return arbol2;
        armarArbol(arbol, arbol2, 0,0);
        return arbol2;
    }

    private void armarArbol(BinaryTree<Integer>arbol, BinaryTree<SumAndDif> nue, int sumaAcumulada, int valorPadre){
        int suma = (arbol.getData() + sumaAcumulada);
        nue.setData(new SumAndDif(suma,(arbol.getData() - valorPadre)));
        if(arbol.hasLeftChild()){
            nue.addLeftChild(new BinaryTree<>());
            armarArbol(arbol.getLeftChild(), nue.getLeftChild(), suma, arbol.getData());
        }

        if(arbol.hasRightChild()){
            nue.addRightChild(new BinaryTree<>());
            armarArbol(arbol.getRightChild(), nue.getRightChild(), suma, arbol.getData());
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(20);

// Subárbol izquierdo
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        nodo5.addLeftChild(new BinaryTree<>(-5));
        nodo5.addRightChild(new BinaryTree<>(10));

// Subárbol derecho
        BinaryTree<Integer> nodo30 = new BinaryTree<>(30);
        nodo30.addLeftChild(new BinaryTree<>(50));
        nodo30.addRightChild(new BinaryTree<>(-9));

// Conecto al root
        raiz.addLeftChild(nodo5);
        raiz.addRightChild(nodo30);



        ParcialArboles p = new ParcialArboles();
        BinaryTree<SumAndDif> res = p.sumAndDif(raiz);
        res.PorNiveles();

    }
}
