package parciales.parcial10;

import parciales.binaryTree.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> ab;
    public ParcialArboles(BinaryTree<Integer> ab){
        this.ab =ab;
    }

    public BinaryTree<Integer> nuevoTree(){
        if(this.ab == null || this.ab.isEmpty()){
            return null;
        }

        BinaryTree<Integer> nuevo = new BinaryTree<Integer>();
        resolver(this.ab, nuevo,0);
        return nuevo;
    }

    private void resolver(BinaryTree<Integer> ab, BinaryTree<Integer> nuevo, int dato){
        int total = ab.getData() + dato;
        nuevo.setData(total);

        if(ab.hasLeftChild()){
            nuevo.addLeftChild(new BinaryTree<>());
            resolver(ab.getLeftChild(), nuevo.getLeftChild(), ab.getData());
        }

        if(ab.hasRightChild()) {
            nuevo.addRightChild(new BinaryTree<>());
            resolver(ab.getRightChild(), nuevo.getRightChild(), 0);
        }
    }


    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(1);

// Subárbol izquierdo
        BinaryTree<Integer> left = new BinaryTree<>(2);
        left.addLeftChild(new BinaryTree<>(4));
        root.addLeftChild(left);

// Subárbol derecho
        BinaryTree<Integer> right = new BinaryTree<>(3);
        BinaryTree<Integer> rightLeft = new BinaryTree<>(5);
        rightLeft.addLeftChild(new BinaryTree<>(7));
        right.addLeftChild(rightLeft);
        right.addRightChild(new BinaryTree<>(6));
        root.addRightChild(right);

        ParcialArboles p = new ParcialArboles(root);
        BinaryTree<Integer> nue = p.nuevoTree();
        nue.PorNiveles();
    }
}
