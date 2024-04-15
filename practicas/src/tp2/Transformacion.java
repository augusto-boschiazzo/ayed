package tp2;

public class Transformacion {
	
	public static BinaryTree<Integer> suma(BinaryTree<Integer> a) {
		recorrido(a);
		return a;
	}
	
	public static int recorrido(BinaryTree<Integer> a) {
		int n = a.getData();
		int izq = 0;
		int der = 0;
		if (a.hasLeftChild()) {
			izq = recorrido(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			der = recorrido(a.getRightChild());
		}
		a.setData(izq + der);
		return n + izq + der;
	}
	

}
