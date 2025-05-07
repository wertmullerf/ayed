package parciales.parcial1;

import parciales.binaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Parcial {
    public List<Integer> resolver(BinaryTree<Integer> ab, int min){
        if(ab != null && !ab.isEmpty()){
            List<Integer> lista = new ArrayList<>();
            List<Integer> camino = new ArrayList<>();
            resolver(ab, ((ab.getData() % 2 == 0) ? 1 : 0), min, lista, camino);
            return camino;
        }else{
            return new ArrayList<>();
        }
    }

    private void resolver(BinaryTree<Integer> ab,int cantPares, int min, List<Integer> lista, List<Integer> camino){
        lista.add(ab.getData());
        if(ab.isLeaf() ){
            if(cantPares >= min){
                camino.clear();
                camino.addAll(lista);
            }
        }

        if(camino.isEmpty()){
            if(ab.hasLeftChild()){
                int cantParesIzq = cantPares;
                BinaryTree<Integer> hijoIzq = ab.getLeftChild();
                if(hijoIzq.getData() % 2 ==0 ) cantParesIzq++;
                resolver(hijoIzq, cantParesIzq, min,lista,camino);
            }
            if(ab.hasRightChild()){
                int cantParesDer = cantPares;
                BinaryTree<Integer> hijoDer = ab.getRightChild();
                if(hijoDer.getData() % 2 ==0 ) cantParesDer++;
                resolver(hijoDer, cantParesDer, min,lista,camino);
            }
            lista.remove(lista.size() -1);

        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(7);

        BinaryTree<Integer> izq = new BinaryTree<>(56);
        BinaryTree<Integer> der = new BinaryTree<>(38);
        BinaryTree<Integer> derIzq = new BinaryTree<>(77);
        BinaryTree<Integer> derDer = new BinaryTree<>(16);

        arbol.addLeftChild(izq);
        arbol.addRightChild(der);
        der.addLeftChild(derIzq);
        der.addRightChild(derDer);

        Parcial parcial = new Parcial();

        List<Integer> lista = parcial.resolver(arbol, 2);
        System.out.println(lista);


    }
}
