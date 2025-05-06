package tp3.ejercicio8;

import tp3.ejercicio1_3.GeneralTree;

import java.util.List;

public class Navidad {
    private GeneralTree<Integer> ag;
    public Navidad(GeneralTree<Integer> ab) {
        this.ag = ab;
    }

    public String esAbetoNavidenio(){
        boolean esAbeto = esAbeto(this.ag);
        return esAbeto ? "Yes" : "No";
    }
/*
    private boolean esAbeto(GeneralTree<Integer> ag){
        if(ag == null){
            return true;
        }

        if(ag.isLeaf()) return true;

        int contador = 0;
        for (GeneralTree<Integer> child: ag.getChildren()){
            if(child.isLeaf()) contador++;
        }

        if(contador < 3) return false; //corto y salgo

        for (GeneralTree<Integer> child: ag.getChildren()){
            if(!esAbeto(child)){
                return false;
            }
        }
        return true;
    }*/


    private boolean esAbeto(GeneralTree<Integer> ag){
        if(ag== null){
            return true;
        }

        int nodosHoja = 0;

        for(GeneralTree<Integer> child: ag.getChildren()){
            if(child.isLeaf()) nodosHoja++;
            else if(!esAbeto(child)) return false;
        }
        return nodosHoja >= 3;

        }
    public static void main(String[] args) {
        // Crear raíz
        GeneralTree<Integer> raiz = new GeneralTree<>(1);

        // Crear hijos
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);

        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
        // Armar el árbol directamente
        raiz.addChild(nodo2);
        raiz.addChild(nodo3);
        raiz.addChild(nodo4);
        raiz.addChild(nodo5);

        nodo4.addChild(nodo6);
        nodo4.addChild(nodo7);
        nodo4.addChild(nodo8);
        // Crear el objeto Navidad
        Navidad navidad = new Navidad(raiz);

        // Probar si es un abeto
        System.out.println(navidad.esAbetoNavidenio()); // debería imprimir "Yes"
    }
}
