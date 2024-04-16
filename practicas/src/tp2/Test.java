package tp2;

public class Test {
	
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a7 = new BinaryTree<Integer>(7);
		arbol.addLeftChild(a7);
		BinaryTree<Integer> a23 = new BinaryTree<Integer>(23);
		a7.addLeftChild(a23);
		BinaryTree<Integer> a3 = new BinaryTree<Integer>(-3);
		a23.addLeftChild(a3);
		BinaryTree<Integer> a6 = new BinaryTree<Integer>(6);
		a7.addRightChild(a6);
		BinaryTree<Integer> a55 = new BinaryTree<Integer>(55);
		a6.addLeftChild(a55);
		BinaryTree<Integer> a11 = new BinaryTree<Integer>(11);
		a6.addRightChild(a11);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(-5);
		arbol.addRightChild(a5);
		BinaryTree<Integer> a19 = new BinaryTree<Integer>(19);
		a5.addLeftChild(a19);
		BinaryTree<Integer> a4 = new BinaryTree<Integer>(4);
		a19.addRightChild(a4);
		BinaryTree<Integer> a18 = new BinaryTree<Integer>(18);
		a4.addLeftChild(a18);
		ParcialArboles test = new ParcialArboles(arbol);
		System.out.println("num = 7 " + test.isLeftTree(7) + " num = 2 " + test.isLeftTree(2) + " num = -5 " + test.isLeftTree(-5) + " num = 19 " + test.isLeftTree(19) + " num = -3 " + test.isLeftTree(-3));
	}
	

}
