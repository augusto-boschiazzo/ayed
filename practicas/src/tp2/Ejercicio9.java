package tp2;

public class Ejercicio9 {
	
	public BinaryTree<Numeros> sumAndDif(BinaryTree<Integer> arbol) {
		BinaryTree<Numeros> nuevo = null;
		if (!arbol.isEmpty()) {
			nuevo = recur(arbol, 0, 0);
		}
		return nuevo;
	}
	
	public BinaryTree<Numeros> recur(BinaryTree<Integer> arbol, int suma, int resta) {
		int dato = arbol.getData();
		Numeros n = new Numeros(suma + dato,  dato - resta);
		BinaryTree<Numeros> nuevo = new BinaryTree<Numeros>(n);
		if (arbol.hasLeftChild()) {
			nuevo.addLeftChild(recur(arbol.getLeftChild(), n.getSuma(), dato));
		}
		if (arbol.hasRightChild()) {
			nuevo.addRightChild(recur(arbol.getRightChild(), n.getSuma(), dato));
		}
		return nuevo;
	}
	

}
