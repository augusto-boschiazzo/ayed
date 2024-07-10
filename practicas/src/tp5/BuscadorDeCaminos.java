package tp5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCaminos {
	private Graph<String> bosque;
	
	public List<List<String>> recorridoMasSeguro() {
		List<List<String>> caminos = new LinkedList<List<String>>();
		if (!bosque.isEmpty()) {
			Vertex<String> casa = bosque.search("Casa Caperucita");
			if (casa != null) {
				boolean[] visitados = new boolean[bosque.getSize()];
				inicializarVisitados(visitados);
				dfs(casa.getPosition(), caminos, new LinkedList<String>(), visitados);
			}
		}
		return caminos;
	}
	
	private void dfs(int i, List<List<String>> caminos, List<String> caminoAct, boolean[] visitados) {
		Vertex<String> v = bosque.getVertex(i);
		String lugar = v.getData();
		caminoAct.add(lugar);
		if (lugar.equals("Casa Abuelita")) {
			caminos.add(new LinkedList<String>(caminoAct));
		}
		else {
			visitados[i] = true;
			Iterator<Edge<String>> it = bosque.getEdge(v).iterator();
			while(it.hasNext()) {
				Edge<String> edge = it.next();
				int j = edge.getTarget().getPosition();
				int cantFrutas = edge.getWeight();
				if (!visitados[j] && cantFrutas < 5) {
					dfs(j, caminos, caminoAct, visitados);
				}
			}
		}
		caminoAct.remove(caminoAct.size() -1);
	}
	
	private void inicializarVisitados(boolean[] visitados) {
		for (int i = 0; i < bosque.getSize(); i++) {
			visitados[i] = false;
		}
	}
	
	
}
