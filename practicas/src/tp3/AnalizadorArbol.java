package tp3;

import java.util.Iterator;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		double prom; int cant;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> aux = cola.dequeue();
			if (aux != null) {
				prom = aux.getData().getTiempo(); cant = 0;
				Iterator<GeneralTree<AreaEmpresa>> it = aux.getChildren().iterator();
			}
		}
	}
	

}
