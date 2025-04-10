package tp2;

import java.util.LinkedList;
import java.util.Queue;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> ab;
    public ProfundidadDeArbolBinario(BinaryTree<Integer>ab) {
        this.ab = ab;
    }

    public int sumaElementosProfundidad(int p){
        return sumarElementosProfundidad(this.ab, p);
    }

    /** Menos efectica
    private int sumarElementosProfundidad(BinaryTree<Integer> ab, int nivelActual, int profundidad){
        if(ab ==null || ab.getData() == null) return 0;

        int suma = 0;
        if(nivelActual == profundidad){
            suma+= ab.getData();
        }
        suma += sumarElementosProfundidad(ab.getLeftChild(), nivelActual + 1, profundidad);
        suma += sumarElementosProfundidad(ab.getRightChild(), nivelActual + 1, profundidad);

        return suma;

    }
     */


    private int sumarElementosProfundidad(BinaryTree<Integer> ab,  int profundidad){
        if (ab == null || ab == null) return 0;
        int nivelActual =0;
        boolean sigo = true;
        Queue<BinaryTree<Integer>> cola = new LinkedList<>();
        cola.offer(ab);
        cola.offer(null);
        int suma = 0;
        while (!cola.isEmpty() && sigo) {
            BinaryTree<Integer> nodo = cola.poll();
            if (nodo != null) {
                if(nivelActual == profundidad){
                   suma+= nodo.getData();
                }
                if (nodo.hasLeftChild()) {
                    cola.offer(nodo.getLeftChild());
                }
                if (nodo.hasRightChild()) {
                    cola.offer(nodo.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                nivelActual++;
                if(nivelActual > profundidad){
                    sigo = false;
                    cola.clear();
                }
                cola.offer(null);
            }
        }
        return suma;
    }
    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n15 = new BinaryTree<>(15);
        BinaryTree<Integer> n3 = new BinaryTree<>(3);
        BinaryTree<Integer> n7 = new BinaryTree<>(7);
        BinaryTree<Integer> n12 = new BinaryTree<>(12);
        BinaryTree<Integer> n18 = new BinaryTree<>(18);

        raiz.addLeftChild(n5);
        raiz.addRightChild(n15);

        n5.addLeftChild(n3);
        n5.addRightChild(n7);

        n15.addLeftChild(n12);
        n15.addRightChild(n18);

        ProfundidadDeArbolBinario ab = new ProfundidadDeArbolBinario(raiz);
        System.out.println(ab.sumaElementosProfundidad(0));
    }
}
