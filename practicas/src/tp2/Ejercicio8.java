package tp2;

public class Ejercicio8 {
	
	public Ejercicio8() {
		
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean aux = false;
		if (!arbol1.isEmpty() && !arbol2.isEmpty()) {
			aux = prefijoRecur(arbol1, arbol2);
		}
		return aux;
	}
	
	private boolean prefijoRecur(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean aux = arbol1.getData() == arbol2.getData();
		if (aux && arbol1.hasLeftChild()) {
			if (arbol2.hasLeftChild()) {
				aux = aux && prefijoRecur(arbol1.getLeftChild(), arbol2.getLeftChild());
			}
			else aux = false;
		}
		if (aux && arbol1.hasRightChild()) {
			if (arbol2.hasRightChild()) {
				aux = aux && prefijoRecur(arbol1.getRightChild(), arbol2.getRightChild());
			}
			else aux = false;
		}
		return aux;
	}
	

}
