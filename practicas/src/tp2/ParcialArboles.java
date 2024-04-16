package tp2;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isLeftTree(int num) {
		boolean aux = false;
		if (!arbol.isEmpty()) {
			BinaryTree<Integer> subarbol = buscarSubArbol(arbol, num);
			if (!subarbol.isEmpty()) {
				aux = masHijosIzq(subarbol);
			}
		}
		return aux;
	}
	
	public BinaryTree<Integer> buscarSubArbol(BinaryTree<Integer> arbol, int num) {
		BinaryTree<Integer> encontrado = null;
		if (!arbol.isEmpty()) {
			if (arbol.getData().equals(num)) {
				encontrado = arbol;
			}
			else {
				if (arbol.hasLeftChild()) {
					encontrado = buscarSubArbol(arbol.getLeftChild(), num);
				}
				if (arbol.hasRightChild() && encontrado == null) {
					encontrado = buscarSubArbol(arbol.getRightChild(), num);
				}
			}
		}
		return encontrado;
	}
	
	public boolean masHijosIzq(BinaryTree<Integer> arbol) {
		int hIzq = -1;
		int hDer = -1;
		if (arbol.hasLeftChild()) {
			hIzq = contarHijo(arbol.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			hDer = contarHijo(arbol.getRightChild());
		}
		return hIzq > hDer;
	}
	
	public int contarHijo(BinaryTree<Integer> arbol) {
		int cant = 0;
		boolean hijoIzq = arbol.hasLeftChild();
		if(hijoIzq) {
			cant++;
			cant += contarHijo(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			if (!hijoIzq) {
				cant++;
			}
			else {
				cant--;
			}
			cant += contarHijo(arbol.getRightChild());
		}
		return cant;
	}
	
	
}
