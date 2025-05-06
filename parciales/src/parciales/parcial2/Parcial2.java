package parciales.parcial2;
import binaryTree.BinaryTree;

public class Parcial2 {

	private BinaryTree<Integer> ab;
	
	public Parcial2(BinaryTree<Integer> data) {
		this.ab = data;
	}
	
	
	public BinaryTree<Integer> nuevoTree(){

		if(ab != null && !ab.isEmpty()) {
			return nuevoTree(this.ab,ab.getData());			
		}
		return new BinaryTree<Integer>();

	}
	
	private BinaryTree<Integer> nuevoTree(BinaryTree<Integer> ab, int valor ){
		BinaryTree<Integer> nuevoNodo = new BinaryTree<Integer>(valor);
		
		//System.out.println(valor);
		if(ab.hasLeftChild()) {
			BinaryTree<Integer> nodoIzq = ab.getLeftChild();
			nuevoNodo.addLeftChild(nuevoTree(nodoIzq, nodoIzq.getData() + ab.getData()));
		}
		if(ab.hasRightChild()) {
			BinaryTree<Integer> nodoDer = ab.getRightChild();
			nuevoNodo.addRightChild(nuevoTree(nodoDer, nodoDer.getData()));
		}
		
		return nuevoNodo;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
		BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
		BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
		BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
		BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
		BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
		BinaryTree<Integer> nodo7 = new BinaryTree<>(7);

		// Armado
		nodo1.addLeftChild(nodo2);
		nodo1.addRightChild(nodo3);

		nodo2.addLeftChild(nodo4);

		nodo3.addLeftChild(nodo5);
		nodo3.addRightChild(nodo6);

		nodo5.addLeftChild(nodo7);

		// Mostrar por niveles
//		nodo1.PorNiveles();
		Parcial2 test = new Parcial2(nodo1);
		BinaryTree<Integer> arbol2 = test.nuevoTree();
		arbol2.PorNiveles();
		
	}
}
