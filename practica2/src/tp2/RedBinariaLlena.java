package tp2;

public class RedBinariaLlena {
    private BinaryTree<Integer> ab;
    public  RedBinariaLlena(BinaryTree<Integer> ab){
        this.ab = ab;
    }

    public int retardoReenvio(){
        return calcularRetardo(this.ab, 0);
    }

    private int calcularRetardo(BinaryTree<Integer> ab, int acumulador){
        if(ab == null || ab.getData() == null) return 0;

        int aux = ab.getData() + acumulador;
        if(ab.isLeaf()) return aux;

        int retardoIzq = calcularRetardo(ab.getLeftChild(), aux);
        int retardoDer = calcularRetardo(ab.getRightChild(), aux);

        return Math.max(retardoIzq, retardoDer);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(10);

        BinaryTree<Integer> n3 = new BinaryTree<>(3);
        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        raiz.addLeftChild(n3);
        raiz.addRightChild(n7);

        n3.addLeftChild(new BinaryTree<>(9));
        n3.addRightChild(new BinaryTree<>(5));

        n7.addLeftChild(new BinaryTree<>(6));
        n7.addRightChild(new BinaryTree<>(12));

        RedBinariaLlena red= new RedBinariaLlena(raiz);
        System.out.println("Nivel mayor de retardo es: " + red.retardoReenvio());
    }
}
