package parciales.parcial1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import arbolesGenerales.GeneralTree;
import binaryTree.BinaryTree;

public class Parcial {
	
	private GeneralTree<Integer> ag;
	public Parcial(GeneralTree<Integer> ag) {
		this.ag=ag;
	}
	
	
	
	//=====================================PARCIAL I==============================================
	public List<Integer> nivel(int num){
		if(ag == null || ag.isEmpty()) return new LinkedList<Integer>();
		List<Integer> resultado = new LinkedList<Integer>();
		Queue<GeneralTree<Integer>> cola = new LinkedList<>();
		cola.offer(ag);
		//cola.offer(null);
		while(!cola.isEmpty()) {
			GeneralTree<Integer> aux = cola.poll();
			if(aux != null) {
				if(aux.hasChildren()) {
					List<GeneralTree<Integer>> children = aux.getChildren();
					System.out.println("Cantidad de hijos " +  children.size());
					if(children.size() >= num) {
						resultado.add(aux.getData());
					}
					for(GeneralTree<Integer> child: children) {
						cola.offer(child);
					}
				}
			}
		}
		
		return resultado;
	}


	//=====================================MAIN====================================================
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(10);

		GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
		GeneralTree<Integer> nodo42 = new GeneralTree<>(42);
		GeneralTree<Integer> nodoMenos5 = new GeneralTree<>(-5);

		// Subárbol de nodo 8
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		nodo5.addChild(new GeneralTree<>(-6));

		GeneralTree<Integer> nodo22 = new GeneralTree<>(22);
		nodo22.addChild(new GeneralTree<>(28));
		nodo22.addChild(new GeneralTree<>(55));
		nodo22.addChild(new GeneralTree<>(18));

		nodo8.addChild(nodo5);
		nodo8.addChild(nodo22);

		// Subárbol de nodo -5
		GeneralTree<Integer> nodo19 = new GeneralTree<>(19);
		nodo19.addChild(new GeneralTree<>(4));

		GeneralTree<Integer> nodoMenos9 = new GeneralTree<>(-9);

		nodoMenos5.addChild(nodo19);
		nodoMenos5.addChild(nodoMenos9);

		// Armar el árbol completo
		raiz.addChild(nodo8);
		raiz.addChild(nodo42);
		raiz.addChild(nodoMenos5);

        
        Parcial parcial = new Parcial(raiz);
        List<Integer> cumplen = parcial.nivel(3);
        System.out.println(cumplen);
        
	}
}
