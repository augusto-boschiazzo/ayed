package tp2;

public class ContadorArbol {
	
	public static BinaryTree<Integer> numerosPares(BinaryTree<Integer> a){
		if (!a.isEmpty()) {
			BinaryTree<Integer> nuevo = new BinaryTree<Integer>(a.getData());
			if (a.hasLeftChild()) {
				nuevo.addLeftChild(numerosPares(a.getLeftChild()));
			}
			if (a.hasRightChild()) {
				nuevo.addRightChild(numerosPares(a.getRightChild()));
			}
		}
		return null;
	}
	

}
