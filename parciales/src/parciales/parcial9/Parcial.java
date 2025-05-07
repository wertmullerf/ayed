package parciales.parcial9;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import arbolesGenerales.GeneralTree;
public class Parcial {
	
	public List<GeneralTree<Integer>> resolver(GeneralTree<Integer> arbol) {
		List<GeneralTree<Integer>> cumplen = new LinkedList<GeneralTree<Integer>>();
		if(arbol != null && !arbol.isEmpty()) {
			buscarHijos(arbol, cumplen);
		}
		return cumplen;
	}
	
	private void buscarHijos(GeneralTree<Integer> ag, List<GeneralTree<Integer>> cumplen) {
		Iterator<GeneralTree<Integer>> it = ag.getChildren().iterator();
		
		if(it.hasNext()) {
			GeneralTree<Integer> primerHijo = it.next();
			buscarHijos(primerHijo, cumplen);
		}
		
		if (!ag.isLeaf() && ag.getChildren().size() % 2 == 0) cumplen.add(ag);
		 		
		while(it.hasNext()) {
			GeneralTree<Integer> hijo = it.next();
			if(!hijo.isLeaf()) buscarHijos(hijo, cumplen);
		}
	}
	
    public static void main(String[] args) {
    	GeneralTree<Integer> root = new GeneralTree<>(10);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);

        // nodo6 -> 7, 4
        nodo6.addChild(nodo7);
        nodo6.addChild(nodo4);

        // nodo8 -> 6
        nodo8.addChild(nodo6);

        // root -> 5, 8, 3
        root.addChild(nodo5);
        root.addChild(nodo8);
        root.addChild(nodo3);

        Parcial parcial = new Parcial();
        List<GeneralTree<Integer>> resultado = parcial.resolver(root);
        for(GeneralTree<Integer> child: resultado) {
        	System.out.println(child.getData());
        }
    }
}
