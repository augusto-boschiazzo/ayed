package tp2;

public class RedBinariaLlena {
	
	public static int retardoReenvio(BinaryTree<Integer> a) {
		int n = 0;
		int max = 0;
		if (!a.isEmpty()) {
			n += a.getData();
			if (a.hasLeftChild()) {
				n += retardoReenvio(a.getLeftChild());
			}
			max = n;
			n = 0;
			if (a.hasRightChild()) {
				n += retardoReenvio(a.getRightChild());
			}
			if (n > max) {
				max = n;
			}
		}
		return max;
	}
	

}
