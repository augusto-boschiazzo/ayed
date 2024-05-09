package tp3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio10 {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		Filtrado maximo = new Filtrado();
		if (!arbol.isEmpty()) {
			Filtrado actual = new Filtrado();
			recorrerArbol(arbol, actual, maximo, 0);
		}
		return maximo.getLista();
	}
	
	public static void recorrerArbol(GeneralTree<Integer> arbol, Filtrado actual, Filtrado maximo, int nivel) {
		int valor = arbol.getData() * nivel;
		actual.setValor(actual.getValor() + valor);
		if (arbol.getData() != 0)
			actual.agregarLista(arbol.getData());
		if (actual.getValor() > maximo.getValor()) {
			maximo.setValor(actual.getValor());
			List<Integer> nueva = new LinkedList<Integer>(actual.getLista());
			maximo.setLista(nueva);
		}
		if (arbol.hasChildren()) {
			Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
			while (it.hasNext()) {
				recorrerArbol(it.next(), actual, maximo, nivel +1);
			}
		}
		actual.setValor(actual.getValor() - valor);
		actual.eliminarUltimoLista();
	}
	

}
