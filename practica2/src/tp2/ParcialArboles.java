package tp2;

public class ParcialArboles {
    private BinaryTree<Integer> ab;

    public ParcialArboles(BinaryTree<Integer> ab){
        this.ab= ab;
    }

    private BinaryTree<Integer> encontrarNodo(BinaryTree<Integer> ab, int num){
        if (ab == null || ab.getData() == null) return null;

        if (ab.getData() == num) {
            return ab;
        }
        BinaryTree<Integer> encontrado = encontrarNodo(ab.getLeftChild(), num);
        return (encontrado != null) ? encontrado : encontrarNodo(ab.getRightChild(), num);

    }

    private int calcularCantidadHijos(BinaryTree<Integer> nodo){
        if(nodo ==null) return 0;
        int acc =0;

        boolean tieneHijoIzq = nodo.hasLeftChild();
        boolean tieneHijoDer = nodo.hasRightChild();
        if((tieneHijoIzq && !tieneHijoDer) || (!tieneHijoIzq && tieneHijoDer)){
            acc = 1;
        }

        acc += calcularCantidadHijos(nodo.getLeftChild());
        acc += calcularCantidadHijos(nodo.getRightChild());
        return acc;
    }


    public boolean isLeftTree(int num) {
        /*Voy a buscar al nodo*/
        BinaryTree<Integer> encontrado = encontrarNodo(ab, num);
        if(encontrado == null){
            return false;
        }

        int cantHijosIzq = calcularCantidadHijos(encontrado.getLeftChild());
        int cantHijosDer = calcularCantidadHijos(encontrado.getRightChild());

        return (cantHijosIzq > cantHijosDer);



    }

    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n8 = new BinaryTree<>(8);
        BinaryTree<Integer> n3 = new BinaryTree<>(3);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        BinaryTree<Integer> n2 = new BinaryTree<>(2);
        BinaryTree<Integer> n12 = new BinaryTree<>(12);

        raiz.addLeftChild(n5);
        raiz.addRightChild(n8);

        n5.addLeftChild(n3);
        n5.addRightChild(n6);

        n3.addLeftChild(n2);

        n8.addRightChild(n12);

        ParcialArboles test =new ParcialArboles(raiz);
        System.out.println(test.isLeftTree(5));
    }
}
