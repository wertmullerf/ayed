package tp2;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
		if (this == null || this.data == null) return 0; // por si es un árbol vacío
		if (this.isLeaf()) return 1; //si tiene un solo nodo el arbol

		int leftCount = this.hasLeftChild() ? this.leftChild.contarHojas() : 0;
		int rightCount = this.hasRightChild() ? this.rightChild.contarHojas() : 0;

		return leftCount + rightCount;
	}

    	 
    public BinaryTree<T> espejo(){
		if(this == null || this.data  ==null) return null;
		// Creo el nuevo árbol con la misma raíz, PORQUE LA RAIZ NO CAMBIA
		BinaryTree<T> espejo = new BinaryTree<T>(this.data);


		if(this.hasLeftChild()){
			espejo.addRightChild(this.getLeftChild().espejo());
		}
		if(this.hasRightChild()){
			espejo.addLeftChild(this.getRightChild().espejo());
		}

		return espejo;
	}
	public void PorNiveles() {

		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.offer(this);
		cola.offer(null);
		while (!cola.isEmpty()) {
			BinaryTree<T> ab = cola.poll();
			if (ab != null) {
				System.out.print(ab.getData() + " ");
				if (ab.hasLeftChild()) {
					cola.offer(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.offer(ab.getRightChild());
				}
			} else if (!cola.isEmpty()) {
				System.out.println();
				cola.offer(null);
			}
		}
	}
	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (this == null || this.data == null) return;
		int nivelActual =0;
		boolean sigo = true;
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.offer(this);
		cola.offer(null);
		while (!cola.isEmpty() && sigo) {
			BinaryTree<T> ab = cola.poll();
			if (ab != null) {
				if(nivelActual >= n && nivelActual <= m){
					System.out.print(ab.getData() + " ");
				}
				if (ab.hasLeftChild()) {
					cola.offer(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.offer(ab.getRightChild());
				}
			} else if (!cola.isEmpty()) {
				nivelActual++;
				if(nivelActual > m){
					sigo = false;
					cola.clear();
				}
				System.out.println();
				cola.offer(null);
			}
		}

	}


   public static void main(String[] args){
		BinaryTree<Integer> ab = new BinaryTree<>(20);
		BinaryTree<Integer> hijoIzq = new BinaryTree<>(50);
		hijoIzq.addLeftChild(new BinaryTree<Integer>(10));
	   	hijoIzq.addRightChild(new BinaryTree<Integer>(5));
	   	BinaryTree<Integer> hijoDer = new BinaryTree<>(4);
	   	hijoDer.addLeftChild(new BinaryTree<Integer>(90));
	   	hijoDer.addRightChild(new BinaryTree<Integer>(100));
		ab.addLeftChild(hijoIzq);

		ab.addRightChild(hijoDer);

		//System.out.println("Cantidad de hojas: " + ab.contarHojas());

		BinaryTree<Integer> ab2 = ab.espejo();
		//ab.PorNiveles();
	   	System.out.println("===================");

	   //ab2.PorNiveles();

	   ab.entreNiveles(0,1);
   }
}

