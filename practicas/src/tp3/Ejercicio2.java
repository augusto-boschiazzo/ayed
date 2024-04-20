package tp3;

import java.util.Iterator;
import java.util.LinkedList;

public class Ejercicio2 {

	public LinkedList<Integer> numerosPreOrden(GeneralTree<Integer> arbol, Integer n) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		if (!arbol.isEmpty()) {
			recorridoPreOrden(arbol, n, lista);
		}
		return lista;
	}
	
	private void recorridoPreOrden(GeneralTree<Integer> arbol, Integer n, LinkedList<Integer> lista) {
		Integer dato = arbol.getData();
		if (dato % 2 != 0 && dato > n)
			lista.add(dato);
		Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
		while (it.hasNext())
			recorridoPreOrden(it.next(), n, lista);
	}
	
	public LinkedList<Integer> numerosInOrden(GeneralTree<Integer> arbol, Integer n) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		if (!arbol.isEmpty()) {
			recorridoInOrden(arbol, n, lista);
		}
		return lista;
	}
	
	private void recorridoInOrden(GeneralTree<Integer> arbol, Integer n, LinkedList<Integer> lista) {
		Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
		recorridoInOrden(it.next(), n, lista);
		Integer dato = arbol.getData();
		if (dato % 2 != 0 && dato > n)
			lista.add(dato);
		while (it.hasNext())
			recorridoInOrden(it.next(), n, lista);
	}

	public LinkedList<Integer> numerosPosOrden(GeneralTree<Integer> arbol, Integer n) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		if (!arbol.isEmpty()) {
			recorridoPosOrden(arbol, n, lista);
		}
		return lista;
	}
	
	private void recorridoPosOrden(GeneralTree<Integer> arbol, Integer n, LinkedList<Integer> lista) {
		Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
		while (it.hasNext())
			recorridoPreOrden(it.next(), n, lista);
		Integer dato = arbol.getData();
		if (dato % 2 != 0 && dato > n)
			lista.add(dato);
	}
	
	public LinkedList<Integer> numerosPorNiveles(GeneralTree<Integer> arbol, Integer n) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<Integer> aux = cola.dequeue();
			if (aux != null) {
				Integer dato = arbol.getData();
				if (dato % 2 != 0 && dato > n)
					lista.add(dato);
				Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
				while (it.hasNext())
					cola.enqueue(it.next());
			}
			else {
				cola.enqueue(null);
			}
		}
		return lista;		
	}
	
	
}
