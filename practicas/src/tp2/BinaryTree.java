package tp2;

public class BinaryTree<T> {
	T data;
	BinaryTree<T> leftChild;
	BinaryTree<T> rightChild;
	
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
		return this.data != null;
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
	
	
}
