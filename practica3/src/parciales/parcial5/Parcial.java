package parciales.parcial5;

import parciales.binaryTree.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<Integer> resolver(BinaryTree<Integer> arbol, int num){
        List<Integer> camino = new LinkedList<>();
        if(arbol != null && !arbol.isEmpty()){
            buscarCamino(arbol, new LinkedList<>(), camino,num);
        }

        return camino;

    }

    private boolean buscarCamino(BinaryTree<Integer> ab, List<Integer> caminoAux, List<Integer> camino,
                                 int min){
        boolean cumple = false;
        caminoAux.add(ab.getData());
        if(ab.isLeaf()){
            if(cantPares(caminoAux) >= min){
                camino.clear();
                camino.addAll(caminoAux);
                return true;
            }
        }else{
            if (ab.hasLeftChild() && !cumple){
                cumple = buscarCamino(ab.getLeftChild(),caminoAux,camino,min);
            }
            if(ab.hasRightChild() && !cumple){
                cumple = buscarCamino(ab.getRightChild(), caminoAux,camino,min);
            }
        }
        if(!cumple){
            caminoAux.remove(caminoAux.size() -1);
        }
        return cumple;
    }

    private int cantPares(List<Integer> lis){
        int cant =0;
        for(Integer num: lis){
            if(num % 2 ==0) cant++;
        }
        return cant;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(7);

// Subárbol izquierdo
        BinaryTree<Integer> n56 = new BinaryTree<>(56);
        BinaryTree<Integer> n38 = new BinaryTree<>(38);
        BinaryTree<Integer> n31 = new BinaryTree<>(31);
        BinaryTree<Integer> n87 = new BinaryTree<>(87);
        BinaryTree<Integer> n77 = new BinaryTree<>(77);
        BinaryTree<Integer> n16 = new BinaryTree<>(16);
        BinaryTree<Integer> n94 = new BinaryTree<>(94);
        BinaryTree<Integer> n43 = new BinaryTree<>(43);
        BinaryTree<Integer> n9 = new BinaryTree<>(9);
        BinaryTree<Integer> n10 = new BinaryTree<>(10);

        arbol.addLeftChild(n56);
        n56.addLeftChild(n38);
        n56.addRightChild(n31);
        n38.addLeftChild(n87);
        n38.addRightChild(n77);
        n77.addLeftChild(n16);
        n16.addRightChild(n43);
        n43.addLeftChild(n9);
        n43.addRightChild(n10);
        n31.addRightChild(n94);

// Subárbol derecho
        BinaryTree<Integer> n25 = new BinaryTree<>(25);
        BinaryTree<Integer> n5 = new BinaryTree<>(5);
        BinaryTree<Integer> n6 = new BinaryTree<>(6);
        BinaryTree<Integer> n2 = new BinaryTree<>(2);
        BinaryTree<Integer> n1 = new BinaryTree<>(1);

        arbol.addRightChild(n25);
        n25.addLeftChild(n5);
        n25.addRightChild(n6);
        n94.addLeftChild(n2);
        n2.addRightChild(n1);

        Parcial p = new Parcial();
        List<Integer> camino = p.resolver(arbol,3);
        System.out.println(camino);
    }

}
