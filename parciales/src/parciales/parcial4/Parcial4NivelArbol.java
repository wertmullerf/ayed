package parciales.parcial4;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.BinaryTree;

public class Parcial4NivelArbol {
	private BinaryTree<Integer> ab;
	public Parcial4NivelArbol(BinaryTree<Integer> ab) {
		this.ab= ab;
	}
	
	public BinaryTree<Integer> minEnNivelAB(int n){
		int nivel = 1;
		Queue<BinaryTree<Integer>> cola = new LinkedList<>();
		cola.offer(ab);
		cola.offer(null);
		BinaryTree<Integer> resultado = new BinaryTree<Integer>();
		BinaryTree<Integer> aux;
		boolean sigo = true;
		Integer min = Integer.MAX_VALUE;
		while(!cola.isEmpty() && sigo) {
			aux = cola.poll();
			if(aux != null) {
				if(nivel == n) {
					if(aux.getData() < min && aux.isLeaf()) {
						min = aux.getData();
						resultado = aux;
					}
				}else {
					if(aux.hasLeftChild()) cola.offer(aux.getLeftChild());
					if(aux.hasRightChild()) cola.offer(aux.getRightChild());
				
				}
				
			}else if(!cola.isEmpty()) {
				nivel++;
				if(nivel > n) {
					sigo = false;
				}
				cola.offer(null);
			}
		
		}
		return resultado ;
		
	}
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<>(2);

		// Nivel 1
		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		raiz.addLeftChild(nodo7);
		raiz.addRightChild(nodo5);

		// Nivel 2 izquierdo
		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		nodo7.addLeftChild(nodo2);
		nodo7.addRightChild(nodo6);

		// Nivel 2 derecho
		BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
		nodo5.addRightChild(nodo9);

		// Nivel 3 (hojas)
		nodo6.addLeftChild(new BinaryTree<>(5));
		nodo6.addRightChild(new BinaryTree<>(11));
		nodo9.addLeftChild(new BinaryTree<>(4));

		
		Parcial4NivelArbol test = new Parcial4NivelArbol(raiz);
		BinaryTree<Integer> resultado = test.minEnNivelAB(4);
		System.out.println(resultado.getData());
	}
	
}
