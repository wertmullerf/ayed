package parciales.parcial7;

import parciales.binaryTree.BinaryTree;

public class Parcial {
    private BinaryTree<Integer> ab;
    public Parcial(BinaryTree<Integer>ab){
        this.ab=ab;
    }

    private BinaryTree<Integer> buscarRaiz(BinaryTree<Integer> nodo, int num){
        if(nodo.getData()==num){
            return nodo;
        }

        BinaryTree<Integer> aux = null;
        if(nodo.hasLeftChild() && aux ==null){
            aux = buscarRaiz(nodo.getLeftChild(),num);
        }

        if(nodo.hasRightChild() && aux ==null){
            aux = buscarRaiz(nodo.getRightChild(),num);
        }
        return aux;
    }
    public boolean isLeftTree(int num){
        if(this.ab == null || this.ab.isEmpty()) return false;
        BinaryTree<Integer> raiz = buscarRaiz(this.ab, num);
        if(raiz == null) return false;
        int izq,der;
        if(raiz.hasLeftChild()){
            izq= contarUnicoHijo(raiz.getLeftChild());
        }else{
            izq = -1;
        }

        if(raiz.hasRightChild()){
            der = contarUnicoHijo(raiz.getRightChild());
        }else{
            der =-1;
        }

        return izq > der;
    }
    private int contarUnicoHijo(BinaryTree<Integer> nodo){

        int cuenta = 0;

        boolean tieneIzq = nodo.hasLeftChild();
        boolean tieneDer = nodo.hasRightChild();

        if ((tieneIzq && !tieneDer) || (!tieneIzq && tieneDer)) {
            cuenta = 1;
        }

        if (tieneIzq) cuenta += contarUnicoHijo(nodo.getLeftChild());
        if (tieneDer) cuenta += contarUnicoHijo(nodo.getRightChild());

        return cuenta;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> a = new BinaryTree<>(2);

        BinaryTree<Integer> b = new BinaryTree<>(7);
        BinaryTree<Integer> c = new BinaryTree<>(-5);
        BinaryTree<Integer> d = new BinaryTree<>(23);
        BinaryTree<Integer> e = new BinaryTree<>(6);
        BinaryTree<Integer> f = new BinaryTree<>(19);
        BinaryTree<Integer> g = new BinaryTree<>(-3);
        BinaryTree<Integer> h = new BinaryTree<>(55);
        BinaryTree<Integer> i = new BinaryTree<>(11);
        BinaryTree<Integer> j = new BinaryTree<>(4);
        BinaryTree<Integer> k = new BinaryTree<>(18);

// Armar subárbol izquierdo
        a.addLeftChild(b);
        b.addLeftChild(d);
        b.addRightChild(e);
        d.addLeftChild(g);
        e.addLeftChild(h);
        e.addRightChild(i);

// Armar subárbol derecho
        a.addRightChild(c);
        c.addLeftChild(f);
        f.addRightChild(j);
        j.addLeftChild(k);


        Parcial p = new Parcial(a);
        System.out.println(p.isLeftTree(-5));
    }

}
