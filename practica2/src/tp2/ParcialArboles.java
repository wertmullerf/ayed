package tp2;


import java.util.LinkedList;
import java.util.Queue;

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
/*
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if(arbol1 == null) return true;
        if(arbol2 == null) return false;
        if(arbol1.getData() != arbol2.getData()) return false;
        return esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild()) && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
    }


*/

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        return esPrefijo(arbol1, arbol2, true);
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


    public BinaryTree<Resultado> sumAndDif(BinaryTree<Integer> arbol){
        return sumAndDif(arbol,0);
    }

    private  BinaryTree<Resultado> sumAndDif(BinaryTree<Integer> arbol, int suma){
        /* lo que debeeria hacer es lo siguiente:
        1. Recorro con algun recorrido en espacial inOrder - PreOrden - PostOrden
        2. En el momento de la operacion: creo un nuevo nodo con los datos solicitados
        3. A ese tipo de dato resultado, la suma se va a construir con la suma (dato)
            del nodo padre + la actual. La diferencia nodo actual - suma
         */

        BinaryTree<Resultado> copia = new BinaryTree<>(new Resultado((suma + arbol.getData()),  arbol.getData() -(suma +arbol.getData())));
        suma+= arbol.getData();

        if(arbol.hasLeftChild()){
            copia.addLeftChild(sumAndDif(arbol.getLeftChild(), suma));
        }
        if(arbol.hasRightChild()){
            copia.addRightChild(sumAndDif(arbol.getRightChild(), suma));
        }
        return copia;
    }



    public void PorNiveles(BinaryTree<Resultado> arbol) {

        Queue<BinaryTree<Resultado>>cola = new LinkedList<>();
        cola.offer(arbol);
        cola.offer(null);
        while (!cola.isEmpty()) {
            BinaryTree<Resultado> ab = cola.poll();
            if (ab != null) {
                System.out.print(ab.getData().getSuma() + "/" + ab.getData().getDiferencia() + " ");
                if (ab.hasLeftChild()) {
                    cola.offer(ab.getLeftChild());
                }
                if (ab.hasRightChild()) {
                    cola.offer(ab.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                System.out.println();
                cola.offer(null);
            }
        }
    }
    public static void main(String[] args) {
        /*
        BinaryTree<Integer> raiz = new BinaryTree<>(65);
        BinaryTree<Integer> n5 = new BinaryTree<>(37);
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
        */

        BinaryTree<Integer> arbol1 = new BinaryTree<>(65);
        BinaryTree<Integer> nodo37 = new BinaryTree<>(37);
        BinaryTree<Integer> nodo81 = new BinaryTree<>(81);
        BinaryTree<Integer> nodo47 = new BinaryTree<>(47);
        BinaryTree<Integer> nodo93 = new BinaryTree<>(93);

        arbol1.addLeftChild(nodo37);
        arbol1.addRightChild(nodo81);
        nodo37.addRightChild(nodo47);
        nodo81.addRightChild(nodo93);


        BinaryTree<Integer> arbol2 = new BinaryTree<>(65);
        BinaryTree<Integer> a37 = new BinaryTree<>(37);
        BinaryTree<Integer> a81 = new BinaryTree<>(81);
        BinaryTree<Integer> a22 = new BinaryTree<>(22);
        BinaryTree<Integer> a47 = new BinaryTree<>(47);
        BinaryTree<Integer> a76 = new BinaryTree<>(76);
        BinaryTree<Integer> a93 = new BinaryTree<>(93);
        BinaryTree<Integer> a11 = new BinaryTree<>(11);
        BinaryTree<Integer> a29 = new BinaryTree<>(29);
        BinaryTree<Integer> a85 = new BinaryTree<>(85);
        BinaryTree<Integer> a94 = new BinaryTree<>(94);

        arbol2.addLeftChild(a37);
        arbol2.addRightChild(a81);

        a37.addLeftChild(a22);
        a37.addRightChild(a47);
        a22.addLeftChild(a11);
        a22.addRightChild(a29);

        a81.addLeftChild(a76);
        a81.addRightChild(a93);
        a93.addLeftChild(a85);
        a93.addRightChild(a94);
        BinaryTree<Integer>a = new BinaryTree<>();
        ParcialArboles test =new ParcialArboles(arbol1);
      //  System.out.println(test.esPrefijo(a, arbol2));

        arbol1.PorNiveles();

        BinaryTree<Resultado> clon = test.sumAndDif(arbol1);

        System.out.println("---------------------------");
        System.out.println("---------------------------");
        test.PorNiveles(clon);

    }

}
