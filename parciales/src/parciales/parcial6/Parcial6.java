package parciales.parcial6;

import binaryTree.BinaryTree;

public class Parcial6 {
	private BinaryTree<Integer> ab;
	
	public Parcial6(BinaryTree<Integer> ab) {		
		this.ab= ab;
	}
	
	public boolean resolver(int k) {
		if(ab != null && !ab.isEmpty()) {
			return esMandato(ab,0, k);
		}else {
			return false;
		}
	}
	
	private boolean esMandato(BinaryTree<Integer> ab, int sumaActual, int k) {
		sumaActual = sumaActual + ab.getData();
		if(ab.isLeaf()) return sumaActual == k;
		
		boolean cumple = true;
		if(ab.hasLeftChild()) cumple = esMandato(ab.getLeftChild(), sumaActual, k);
		
		if(ab.hasRightChild()) cumple = esMandato(ab.getRightChild(), sumaActual, k);
		
		return cumple;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> raiz = new BinaryTree<>(5);
		BinaryTree<Integer> n1 = new BinaryTree<>(3);
		BinaryTree<Integer> n2 = new BinaryTree<>(2);
		BinaryTree<Integer> n3 = new BinaryTree<>(0);
		BinaryTree<Integer> n4 = new BinaryTree<>(1);

		raiz.addLeftChild(n1);
		raiz.addRightChild(n2);

		n1.addLeftChild(n3);
		n2.addRightChild(n4);
		
		Parcial6 p = new Parcial6(raiz);
		System.out.println(p.resolver(8));
		

	}
	
	
}
