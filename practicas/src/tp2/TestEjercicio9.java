package tp2;

public class TestEjercicio9 {
	
	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer>(20);
		BinaryTree<Integer> a2 = new BinaryTree<Integer>(5);
		arbol.addLeftChild(a2);
		BinaryTree<Integer> a3 = new BinaryTree<Integer>(30);
		arbol.addRightChild(a3);
		BinaryTree<Integer> a4 = new BinaryTree<Integer>(-5);
		a2.addLeftChild(a4);
		BinaryTree<Integer> a5 = new BinaryTree<Integer>(10);
		a2.addRightChild(a5);
		BinaryTree<Integer> a6 = new BinaryTree<Integer>(50);
		a3.addLeftChild(a6);
		BinaryTree<Integer> a7 = new BinaryTree<Integer>(-9);
		a3.addRightChild(a7);
		BinaryTree<Integer> a10 = new BinaryTree<Integer>(1);
		a5.addLeftChild(a10);
		BinaryTree<Integer> a13 = new BinaryTree<Integer>(4);
		a6.addRightChild(a13);
		BinaryTree<Integer> a27 = new BinaryTree<Integer>(6);
		a13.addRightChild(a27);
		
		Ejercicio9 ej = new Ejercicio9();
		
		BinaryTree<Numeros> nuevo = ej.sumAndDif(arbol);
		nuevo.entreNiveles(0, 8);
	}
	

}
