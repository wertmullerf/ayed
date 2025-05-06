package tp3.ejercicio9_11;

import tp3.ejercicio1_3.GeneralTree;

import java.util.List;

public class PruebaEjer10 {
    public static void main(String[] args) {
        GeneralTree<Integer> hoja1 = new GeneralTree<>(1);
        GeneralTree<Integer> hoja2 = new GeneralTree<>(0);
        GeneralTree<Integer> hoja3 = new GeneralTree<>(0);
        hoja2.addChild(hoja3); // último 1
        hoja3.addChild(new GeneralTree<>(1));
        GeneralTree<Integer> hijoIzq = new GeneralTree<>(1);
        hijoIzq.addChild(hoja1);

        GeneralTree<Integer> hijoDer = new GeneralTree<>(0);
        hijoDer.addChild(hoja2);

        GeneralTree<Integer> raiz = new GeneralTree<>(1);
        raiz.addChild(hijoIzq);
        raiz.addChild(hijoDer);

        List<Integer> resultadoPunto10 = ParcialArboles.resolverPunto10(raiz);
        System.out.println(resultadoPunto10);
    }
}
