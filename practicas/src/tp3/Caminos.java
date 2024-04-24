package tp3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Caminos {
	private GeneralTree<Integer> arbol;

	public Caminos(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> lista = new LinkedList<Integer>();
		if (!arbol.isEmpty()) {
			caminoRecur(arbol, -1, 0, lista);
		}
		return lista;
	}
	
	private void caminoRecur(GeneralTree<Integer> arbol, int max, int prof, List<Integer> lista) {
		lista.add(arbol.getData());
		if(arbol.hasChildren()) {
			Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
			while(it.hasNext()) {
				caminoRecur(it.next(), max, prof +1, lista);
			}
		}
		if (prof < max) {
			lista.remove(arbol.getData());
		}
	}
	

}
