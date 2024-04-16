package tp2;

public class TestEjercicio8 {
	
	public static void main(String[] args) {
		Ejercicio8 ej = new Ejercicio8();
		BinaryTree<Integer> pre = new BinaryTree<Integer>(65);
		BinaryTree<Integer> pre37 = new BinaryTree<Integer>(37);
		pre.addLeftChild(pre37);
		BinaryTree<Integer> pre47 = new BinaryTree<Integer>(47);
		pre37.addRightChild(pre47);
		BinaryTree<Integer> pre81 = new BinaryTree<Integer>(81);
		pre.addRightChild(pre81);
		BinaryTree<Integer> pre93 = new BinaryTree<Integer>(93);
		pre81.addRightChild(pre93);
		
		BinaryTree<Integer> arb = new BinaryTree<Integer>(65);
		BinaryTree<Integer> arb37 = new BinaryTree<Integer>(37);
		arb.addLeftChild(arb37);
		BinaryTree<Integer> arb47 = new BinaryTree<Integer>(47);
		arb37.addRightChild(arb47);
		BinaryTree<Integer> arb81 = new BinaryTree<Integer>(81);
		arb.addRightChild(arb81);
		BinaryTree<Integer> arb93 = new BinaryTree<Integer>(93);
		arb81.addRightChild(arb93);
		BinaryTree<Integer> arb22 = new BinaryTree<Integer>(22);
		arb37.addLeftChild(arb22);
		BinaryTree<Integer> arb76 = new BinaryTree<Integer>(76);
		arb81.addLeftChild(arb76);
		
		
		System.out.println(ej.esPrefijo(pre, arb));
	}
	

}
