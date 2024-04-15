package tp2;

public class Test {
	
	public static void main(String[] args) {
		BinaryTree<Integer> a1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(4);
		a2.addRightChild(a5);
		a1.addLeftChild(a2);
		BinaryTree<Integer> a3 = new BinaryTree<Integer>(3);
		BinaryTree<Integer> a6 = new BinaryTree<Integer>(5);
		BinaryTree<Integer> a12 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> a13 = new BinaryTree<Integer>(8);
		a6.addLeftChild(a12);
		a6.addRightChild(a13);
		a3.addLeftChild(a6);
		BinaryTree<Integer> a7 = new BinaryTree<Integer>(6);
		a3.addRightChild(a7);
		a1.addRightChild(a3);
		BinaryTree<Integer> nuevo = Transformacion.suma(a1);
		nuevo.entreNiveles(0, 5);
	}
	

}
