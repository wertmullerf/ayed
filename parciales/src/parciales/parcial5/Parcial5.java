package parciales.parcial5;

import java.util.LinkedList;
import java.util.List;

import arbolesGenerales.GeneralTree;

public class Parcial5 {
	private GeneralTree<Integer> ag;
	public Parcial5(GeneralTree<Integer> ag) {
		this.ag= ag;
	}
	

	public List<Integer> caminoMasLejano(){
		List<Integer> camino = new LinkedList<Integer>();
		if(ag != null && !ag.isEmpty()) {
			List<Integer> lista = new LinkedList<Integer>();
			lista.add(ag.getData()); //--> capturo la raiz
			buscarCamino(ag, camino, lista);
		}
		return camino;
	}
	
	private void buscarCamino(GeneralTree<Integer> ag, List<Integer> camino, List<Integer> lista) {		
		if(ag.isLeaf()) {
			if(lista.size()>camino.size()) {
				camino.clear();
				camino.addAll(lista);
			}
		}else {
			for(GeneralTree<Integer> child: ag.getChildren()) {
				lista.add(child.getData());
				buscarCamino(child, camino, lista);
			}
		}
		lista.remove(lista.size()-1); // ---> backtracking
		
		
	}
	
	
	public static void main(String[] args) {
		GeneralTree<Integer> raiz = new GeneralTree<>(8);

		// Subárbol izquierdo (nodo 3 con hijos 4, 7, 6)
		GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
		GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
		GeneralTree<Integer> nodo6 = new GeneralTree<>(6);

		// Hijo de 7
		GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
		nodo7.addChild(nodo2);

		// Agregar hijos a 3
		nodo3.addChild(nodo4);
		nodo3.addChild(nodo7);
		nodo3.addChild(nodo6);

		// Subárbol derecho (nodo 5 con hijos 1, 9, 10)
		GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
		nodo5.addChild(new GeneralTree<>(1));
		nodo5.addChild(new GeneralTree<>(9));
		nodo5.addChild(new GeneralTree<>(10));

		// Agregar hijos al nodo raíz 8
		raiz.addChild(nodo3);
		raiz.addChild(nodo5);

		Parcial5 parcial = new Parcial5(raiz);
		List<Integer> resultado = parcial.caminoMasLejano();
		System.out.println(resultado);
	}
}
