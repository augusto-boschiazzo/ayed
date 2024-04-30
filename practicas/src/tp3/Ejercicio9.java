package tp3;

import java.util.LinkedList;

public class Ejercicio9 {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean aux = true;
		if (!arbol.isEmpty()) {
			aux = recorrer(arbol);
		}
		return aux;
	}
	
	private static boolean recorrer(GeneralTree<Integer> arbol) {
		boolean aux = true;
		if (arbol.hasChildren()) {
			int min = minimo(arbol.getChildren());
			aux = arbol.getData() == min;
			if (aux) {
				for (GeneralTree<Integer> a: arbol.getChildren()) {
					aux = aux && recorrer(a);
				}
			}
		}
		return aux;
	}
	
	private static int minimo(LinkedList<GeneralTree<Integer>> lista) {
		int minimo = 9999;
		for (GeneralTree<Integer> a: lista) {
			if (a.getData() < minimo)
				minimo = a.getData();
		}
		return minimo;
	}
	

}
