package tp3.ejercicio7;

import tp3.ejercicio1_3.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> ag;
    public Caminos(GeneralTree<Integer> ag){
        this.ag = ag;
    }

    public List<Integer> caminoAHojaMasLejana (){
        List<Integer> lista = new LinkedList<>();
        lista.add(this.ag.getData()); //-> agrego la raiz
        List<Integer> camino = new LinkedList<>();
        encontrarCamino(this.ag, lista, camino);
        return camino;
    }

    private List<Integer> encontrarCamino(GeneralTree<Integer> ag, List<Integer> lista,List<Integer> camino){
        if(ag.isLeaf()){
            if(lista.size() >= camino.size()){
                camino.clear();
                camino.addAll(lista);
            }
        }else{
            List<GeneralTree<Integer>> children = ag.getChildren();
            for (GeneralTree<Integer> child: children){
                lista.add(child.getData());
                encontrarCamino(child,lista,camino);
                lista.remove(lista.size() -1);
            }
        }

        return camino;
    }

    public static void main(String[] args) {
        // Hojas
        GeneralTree<Integer> uno = new GeneralTree<>(1);
        GeneralTree<Integer> siete = new GeneralTree<>(7);
        GeneralTree<Integer> ocho = new GeneralTree<>(8);
        GeneralTree<Integer> diez = new GeneralTree<>(10);
        GeneralTree<Integer> dieciseis = new GeneralTree<>(16);
        GeneralTree<Integer> dieciocho = new GeneralTree<>(18);

        // Intermedios
        GeneralTree<Integer> seis = new GeneralTree<>(6);
        seis.addChild(uno);

        GeneralTree<Integer> catorce = new GeneralTree<>(14);
        catorce.addChild(dieciseis);
        catorce.addChild(siete);

        GeneralTree<Integer> diecisiete = new GeneralTree<>(17);
        diecisiete.addChild(diez);
        diecisiete.addChild(seis);

        GeneralTree<Integer> nueve = new GeneralTree<>(9);
        nueve.addChild(ocho);

        GeneralTree<Integer> quince = new GeneralTree<>(15);
        quince.addChild(catorce);
        quince.addChild(dieciocho);

        // Raíz
        GeneralTree<Integer> doce = new GeneralTree<>(12);
        doce.addChild(diecisiete);
        doce.addChild(nueve);
        doce.addChild(quince);

        Caminos camino = new Caminos(doce);
        List<Integer> resultado = camino.caminoAHojaMasLejana();
        System.out.println(resultado);
    }
}
