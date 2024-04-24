package tp3;

import java.util.Iterator;

public class RedDeAguaPotable {
	private GeneralTree<Character> arbol;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		double minimo = caudal;
		if (!arbol.isEmpty()) {
			Iterator<GeneralTree<Character>> it = arbol.getChildren().iterator();
			caudal = caudal / arbol.getChildren().size();
			double hijo;
			while (it.hasNext()) {
				hijo = minimoRecur(it.next(), caudal);
				if (hijo < minimo) {
					minimo = hijo;
				}
			}
		}
		return minimo;
	}
	
	private double minimoRecur(GeneralTree<Character> arbol, double caudal) {
		double minimo = caudal;
		double caudalHijos;
		Iterator<GeneralTree<Character>> it = arbol.getChildren().iterator();
		while (it.hasNext()) {
			caudalHijos = minimoRecur(it.next(), caudal / arbol.getChildren().size());
			if (caudalHijos < minimo) {
				minimo = caudalHijos;
			}
		}		

		return minimo;
	}
	
	
}
