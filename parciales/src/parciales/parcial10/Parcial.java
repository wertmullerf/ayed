package parciales.parcial10;

import binaryTree.BinaryTree;

public class Parcial {
	private BinaryTree<Integer> ab;
	public Parcial(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public Contenedor procesar() {
		Contenedor contenedor = new Contenedor();
		if(ab != null && !ab.isEmpty() ) {
			postOrden(ab,contenedor);
		}
		return contenedor;
	}
	
	
	private void evaluarNodo(BinaryTree<Integer> ab, Contenedor contenedor) {
		int cantHijos = 0;
		if(ab.hasLeftChild()) cantHijos++;
		if(ab.hasRightChild()) cantHijos++;
		
		
		if(ab.getData() % 2 != 0 ) { // -->  si el dato es impar
			contenedor.setCantImpares(contenedor.getCantImpares() + 1);
			if(cantHijos == 1) {
				contenedor.agregarListaCumplen(ab.getData());
			}
		}
	}
	private void postOrden(BinaryTree<Integer> ab, Contenedor contenedor) {
		if(ab.hasLeftChild()) {
			postOrden(ab.getLeftChild(),contenedor);
		}
		
		if(ab.hasRightChild()) {
			postOrden(ab.getRightChild(),contenedor);
		}
		
		evaluarNodo(ab,contenedor);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		//----> raiz y subarbol izq
		BinaryTree<Integer> nodo10 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> nodo6 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> nodo1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> nodo9 = new BinaryTree<Integer>(9);
		BinaryTree<Integer> nodo11 = new BinaryTree<Integer>(11);
		BinaryTree<Integer> nodo20 = new BinaryTree<Integer>(20);
	
		//---->  subarbol der
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> nodo3 = new BinaryTree<Integer>(3);
		BinaryTree<Integer> nodo4 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> nodo8= new BinaryTree<Integer>(8);
		BinaryTree<Integer> nodo2b = new BinaryTree<Integer>(2);
		BinaryTree<Integer> nodo4b = new BinaryTree<Integer>(4);
		
		
		nodo10.addLeftChild(nodo6);
		nodo10.addRightChild(nodo2);

		nodo6.addLeftChild(nodo1);
		nodo6.addRightChild(nodo9);
		
		nodo9.addLeftChild(nodo11);
		nodo1.addRightChild(nodo20);
		
		nodo2.addRightChild(nodo3);
		nodo3.addRightChild(nodo4);
		
		nodo2.addLeftChild(nodo8);
		nodo8.addLeftChild(nodo2b);
		nodo8.addRightChild(nodo4b);
	
		Parcial parcial = new Parcial(nodo10);
		Contenedor resultado = parcial.procesar();
		
		System.out.println(resultado.getCantImpares());
		System.out.println(resultado.toString());
	}
}
