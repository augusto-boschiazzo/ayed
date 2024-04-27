package tp3;

import java.util.Iterator;

public class Ejercicio11 {
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if (!arbol.isEmpty()) {
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			int cant = 0;
			int tot = 1;
			GeneralTree<Integer> aux;
			while(!cola.isEmpty()) {
				aux = cola.dequeue();
				if (aux != null) {
					cant++;
					Iterator<GeneralTree<Integer>> it = aux.getChildren().iterator();
					while (it.hasNext())
						cola.enqueue(it.next());
				}
				else if (!cola.isEmpty()){
					cola.enqueue(null);
					if (cant != tot) {
						return false;
					}
					cant = 0;
					tot++;
				}
			}
			if (cant != tot) {
				return false;
			}
		}
		else
			return false;
		return true;
	}
	

}
