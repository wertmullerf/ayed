package parciales.parcial11;

import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

import arbolesGenerales.GeneralTree;

public class ComparadorDeArbolesGenerales {

	private int calcularLista(List<GeneralTree<Integer>> lista) {
		int acc = 0;
		for(GeneralTree<Integer> num:lista) acc+= num.getData();
		return acc;
	}
	
	public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
		boolean cumple = true;
		if(arbol1.getData() > arbol2.getData()) return false; //condicion 1

		if(arbol1.isLeaf() && !arbol2.isLeaf()) {
			if(arbol1.getData() > arbol2.getData()) return false;  //condicion c1
		}
		
		if(!arbol1.isLeaf() && arbol2.isLeaf() ) return false; //condicion c2
		if(arbol1.isLeaf() && arbol2.isLeaf()) {
			if(arbol1.getData() > arbol2.getData()) return false; //condicion 2.b
		}
		
		
		//falta evaluar la condicion 2.a
		
		if(arbol1.hasChildren() && arbol2.hasChildren()) {
			List<GeneralTree<Integer>> hijoA1 = arbol1.getChildren();
			List<GeneralTree<Integer>> hijoA2 = arbol2.getChildren();
			
			int accA1 = calcularLista(hijoA1);
			int accA2 =  calcularLista(hijoA2);
			//System.out.print("ACC 1: "+ accA1 + " ACC 2: " + accA2);
			if(accA1 > accA2) {
				return false;
			}else {
				Iterator<GeneralTree<Integer>> itA1 = hijoA1.iterator();
				Iterator<GeneralTree<Integer>> itA2 = hijoA2.iterator();
				while(cumple && itA1.hasNext() && itA2.hasNext()) {
					cumple = esInferiorProfundo(itA1.next(), itA2.next());
				}
			}
		}
		return cumple;
		
		
	}
public static void main(String[] args) {
	GeneralTree<Integer> arbol1 = new GeneralTree<>(10);
	GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
	GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
	GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
	GeneralTree<Integer> nodo1 = new GeneralTree<>(1);

	nodo4.addChild(nodo1);
	arbol1.addChild(nodo4);
	arbol1.addChild(nodo3);
	arbol1.addChild(nodo2);
	
	
	GeneralTree<Integer> arbol2 = new GeneralTree<>(15);
	GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
	GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
	GeneralTree<Integer> nodo2_1 = new GeneralTree<>(2);
	GeneralTree<Integer> nodoNeg2 = new GeneralTree<>(-2);
	GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
	GeneralTree<Integer> nodo7 = new GeneralTree<>(7);

	nodo8.addChild(nodo2_1);
	nodo8.addChild(nodoNeg2);
	nodo8.addChild(nodo6);
	nodo5.addChild(nodo7);
	arbol2.addChild(nodo8);
	arbol2.addChild(nodo5);

	
	ComparadorDeArbolesGenerales comparador = new ComparadorDeArbolesGenerales();
	System.out.println(comparador.esInferiorProfundo(arbol1, arbol2));
}


}
