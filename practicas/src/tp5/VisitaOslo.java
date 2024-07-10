package tp5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VisitaOslo {
	
	public static List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
		List<String> lista = new LinkedList<String>();
		if (!lugares.isEmpty()) {
			Vertex<String> origen = lugares.search("Ayuntamiento");
			if (origen != null) {
				boolean[] visitados = new boolean[lugares.getSize()];
				inicializarVisitados(visitados, lugares, lugaresRestringidos);
				dfs(lugares, lista, origen.getPosition(), destino, maxTiempo, 0, visitados);
			}
		}
		return lista;
	}
	
	private static boolean dfs(Graph<String> lugares, List<String> lista, int i, String destino, int maxTiempo, int tiempoActual, boolean[] visitados) {
		boolean encontrado = false;
		visitados[i] = true;
		Vertex<String> v = lugares.getVertex(i);
		String ciudad = v.getData();
		lista.add(ciudad);
		if(ciudad.equals(destino)) {
			encontrado = true;
		}
		else {
			Iterator<Edge<String>> it = lugares.getEdge(v).iterator();
			while (it.hasNext() && !encontrado) {
				Edge<String> edge = it.next();
				int j = edge.getTarget().getPosition();
				int tiempo = edge.getWeight();
				if (!visitados[j] && tiempo + tiempoActual <= maxTiempo) {
					encontrado = dfs(lugares, lista, j, destino, maxTiempo, tiempoActual + tiempo, visitados);
				}
			}
		}
		if (!encontrado)
			lista.remove(lista.size() -1);
		return encontrado;
	}
	
	private static void inicializarVisitados(boolean[] visitados, Graph<String> lugares, List<String> lugaresRestringidos) {
		for(int i = 0; i < visitados.length; i++) {
			if (lugaresRestringidos.contains(lugares.getVertex(i).getData())) {
				visitados[i] = true;
			}
			else
				visitados[i] = false;
		}
	}
	
	
}
