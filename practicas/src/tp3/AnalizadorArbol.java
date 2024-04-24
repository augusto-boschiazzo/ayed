package tp3;

import java.util.Iterator;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		int total = 0; int cant = 0; double max = -1;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> aux = cola.dequeue();
			if (aux != null) {
				total += aux.getData().getTiempo(); cant++;
				Iterator<GeneralTree<AreaEmpresa>> it = aux.getChildren().iterator();
				while (it.hasNext()) {
					cola.enqueue(it.next());
				}
			}
			else if (!cola.isEmpty()) {
				cola.enqueue(null);
				if (total / cant > max)
					max = total / cant;
				total = 0;
				cant = 0;
			}
		}
		return max;
	}
	

}
