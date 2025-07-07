package parciales.parcial3;

import parciales.binaryTree.BinaryTree;

public class ParcialArboles {
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        return esPrefijo(arbol1, arbol2,true);
    }

    private boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2, boolean sigue){
        if(arbol1==null && arbol2 == null) sigue= true;
        if(arbol1.getData() != arbol2.getData()) sigue= false;
        if(sigue){
            if(arbol1.hasLeftChild() && arbol2.hasLeftChild()){
                return esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
            }
            if(arbol1.hasRightChild() && arbol2.hasRightChild()){
                return esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
            }
        }
        return sigue;
    }
}
