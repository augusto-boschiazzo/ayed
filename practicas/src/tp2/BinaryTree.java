package tp2;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;
	
	public BinaryTree(T data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}

	public T getData() {
		return data;
	}

	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	public BinaryTree<T> getRightChild() {
		return rightChild;
	}
	
	public void addLeftChild(BinaryTree<T> tree) {
		leftChild = tree;
	}
	
	public void addRightChild(BinaryTree<T> tree) {
		rightChild = tree;
	}
	
	public void removeLeftChild() {
		leftChild = null;
	}
	
	public void removeRightChild() {
		rightChild = null;
	}
	
	public boolean isEmpty() {
		return this.data == null;
	}
	
	public boolean isLeaf() {
		return this.leftChild != null && this.rightChild != null;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	public int contarHojas() {
		int aux = 0;
		if(!this.isEmpty()) {
			if (this.isLeaf()) {
				aux++;
			}
			else {
				if (this.hasLeftChild()) {
					aux += this.leftChild.contarHojas();
				}
				if (this.hasRightChild()) {
					aux += this.rightChild.contarHojas();
				}
			}
		}
		return aux;
	}
	
	public BinaryTree<T> espejo() {
		if (!this.isEmpty()) {
			BinaryTree<T> nuevo = new BinaryTree<T>(this.getData());
			if (this.hasLeftChild()) {
				nuevo.addRightChild(this.leftChild.espejo());
			}
			if (this.hasRightChild()) {
				nuevo.addLeftChild(this.rightChild.espejo());
			}
			return nuevo;
		}
		return null;
	}
	
	public void entreNiveles(int n, int m) {
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		BinaryTree<T> aux;
		int nivel = 0;
		while(!cola.isEmpty() && nivel <= m) {
			aux = cola.dequeue();
			if(aux != null) {
				if (nivel >= n && nivel <= m)
					System.out.print(aux.data.toString() + " | ");
				if(aux.hasLeftChild()) {
					cola.enqueue(aux.leftChild);
				}
				if(aux.hasRightChild()) {
					cola.enqueue(aux.rightChild);
				}
			}
			else {
				cola.enqueue(null);
				nivel++;
				System.out.println();
			}
		}
	}
	
	public void setData(T e) {
		data = e;
	}
	
	
}
