package parciales.parcial8;

import parciales.binaryTree.BinaryTree;

public class Parcial {
    BinaryTree<Integer> ab;
    public Parcial(BinaryTree<Integer> ab){
        this.ab = ab;
    }

    public boolean resolver(int k){
        if(this.ab != null && !this.ab.isEmpty()){
            return esMonodistante(this.ab, k, 0);
        }
        return false;
    }


    private boolean esMonodistante(BinaryTree<Integer> ab, int k, int acc){
        acc += ab.getData();
        boolean esMonodistante = true;

        if(ab.isLeaf() && acc != k){
            return false;
        }

        if(ab.hasLeftChild() && esMonodistante){
            esMonodistante = esMonodistante(ab.getLeftChild(), k, acc);
        }


        if(ab.hasRightChild() && esMonodistante){
            esMonodistante = esMonodistante(ab.getRightChild(), k, acc);
        }

        return esMonodistante;
    }


    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(2);

// Subárbol izquierdo
        BinaryTree<Integer> left = new BinaryTree<>(1);
        left.addLeftChild(new BinaryTree<>(5));
        BinaryTree<Integer> leftRight = new BinaryTree<>(5);
        left.addRightChild(leftRight);
        root.addLeftChild(left);

// Subárbol derecho
        BinaryTree<Integer> right = new BinaryTree<>(2);
        BinaryTree<Integer> rightLeft = new BinaryTree<>(4);
        BinaryTree<Integer> rightRight = new BinaryTree<>(4);
        right.addLeftChild(rightLeft);
        right.addRightChild(rightRight);
        root.addRightChild(right);


        Parcial p = new Parcial(root);
        System.out.println(p.resolver(8));


    }
}
