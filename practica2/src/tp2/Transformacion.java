package tp2;

public class Transformacion {
    private BinaryTree<Integer> ab;
    public Transformacion(BinaryTree<Integer> ab){
        this.ab = ab;
    }

    public BinaryTree<Integer> suma(){
        return suma(this.ab);
    }

    private BinaryTree<Integer> suma(BinaryTree<Integer> nodo){
        if(nodo == null || nodo.getData() == null) return null;

        // si es una hija, directamente retornamos el nodo con 0
        if(nodo.isLeaf()){
            return new BinaryTree<>(0);
        }

        //creamos hizo izquierdo con llamada recursiva
        BinaryTree<Integer> hijoizq = suma(nodo.getLeftChild());
        BinaryTree<Integer> hijoder = suma(nodo.getRightChild());

        int sumaIzq = sumarSubarbol(nodo.getLeftChild());
        int sumaDer = sumarSubarbol(nodo.getRightChild());
        BinaryTree<Integer> nuevoNodo = new BinaryTree<>(sumaIzq + sumaDer);

        nuevoNodo.addLeftChild(hijoizq);
        nuevoNodo.addRightChild(hijoder);

        return nuevoNodo;
    }

    private int sumarSubarbol(BinaryTree<Integer> nodo){
        if(nodo == null || nodo.getData() == null) return 0;

        int suma = nodo.getData();
        suma+= sumarSubarbol(nodo.getLeftChild());
        suma+= sumarSubarbol(nodo.getRightChild());

        return suma;
    }


    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> n4 = new BinaryTree<>(4);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        BinaryTree<Integer> n2 = new BinaryTree<>(2);
        BinaryTree<Integer> n3 = new BinaryTree<>(3);
        BinaryTree<Integer> n1 = new BinaryTree<>(1);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);

        raiz.addLeftChild(n4);
        raiz.addRightChild(n6);

        n4.addLeftChild(n2);
        n4.addRightChild(n3);

        n6.addLeftChild(n1);
        n6.addRightChild(n5);

        Transformacion trans = new Transformacion(raiz);
        BinaryTree<Integer> nuevoArbol= trans.suma();
        nuevoArbol.PorNiveles();
    }

}
