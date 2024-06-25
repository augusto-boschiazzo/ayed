package tp5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mapa {
	Graph<String> mapaCiudades;
	
	public List<String> devolverCamino(String origen, String destino) {
		List<String> lista  = new LinkedList<String>();
		if (!mapaCiudades.isEmpty()) {
			boolean[] visitado = new boolean[mapaCiudades.getSize()];
			inicializarVisitados(visitado);
			Vertex<String> ciudad = mapaCiudades.search(origen);
			if (ciudad != null) {
				dfs(ciudad.getPosition(), destino, lista, visitado);
			}
		}
		return lista;
	}
	
	private boolean dfs(int i, String ciudad, List<String> lista, boolean[] visitado) {
		boolean encontrado = false;
		visitado[i] = true;
		Vertex<String> actual = mapaCiudades.getVertex(i);
		lista.add(actual.getData());
		if (actual.getData().equals(ciudad))
			encontrado = true;
		else {
			int j;
			Iterator<Edge<String>> it = mapaCiudades.getEdge(actual).iterator();
			while(it.hasNext() && !encontrado) {
				j = it.next().getTarget().getPosition();
				if (!visitado[j]) {
					encontrado = dfs(j, ciudad, lista, visitado);
				}
			}
		}
		if (!encontrado)
			lista.remove(lista.size()-1);
		return encontrado;
	}
	
	public List<String> devolverCaminoExceptuando(String origen, String destino, List<String> ciudades) {
		List<String> lista = new LinkedList<String>();
		if (!mapaCiudades.isEmpty()) {
			boolean[] visitado = new boolean[mapaCiudades.getSize()];
			inicializarVisitados(visitado);
			Vertex<String> ciudad = mapaCiudades.search(origen);
			if (ciudad != null) {
				dfsExcepto(ciudad.getPosition(), destino, lista, visitado, ciudades);
			}
		}
		return lista;
	}
	
	private boolean dfsExcepto(int i, String ciudad, List<String> lista, boolean[] visitado, List<String> ciudades) {
		boolean encontrado = false;
		visitado[i] = true;
		Vertex<String> actual = mapaCiudades.getVertex(i);
		lista.add(actual.getData());
		if (actual.getData().equals(ciudad))
			encontrado = true;
		else {
			int j;
			Iterator<Edge<String>> it = mapaCiudades.getEdge(actual).iterator();
			while(it.hasNext() && !encontrado) {
				Vertex<String> target = it.next().getTarget();
				j = target.getPosition();
				if (!visitado[j] && !ciudades.contains(target.getData())) {
					encontrado = dfsExcepto(j, ciudad, lista, visitado, ciudades);
				}
			}
		}
		if (!encontrado)
			lista.remove(lista.size()-1);
		return encontrado;
	}
	
	public List<String> caminoMasCorto(String origen, String destino) {
		List<String> lista = new LinkedList<String>();
		if (!mapaCiudades.isEmpty()) {
			boolean[] visitado = new boolean[mapaCiudades.getSize()];
			inicializarVisitados(visitado);
			Vertex<String> ciudad = mapaCiudades.search(origen);
			if (ciudad != null) {
				dijkstra(ciudad.getPosition(), destino, lista);
			}
		}
		return lista;
	}
	
	private void dijkstra(int i, String ciudad, List<String> listaMin) {
		List<String> listaAux = new LinkedList<String>();
		
	}
	
	private void inicializarVisitados(boolean[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			visitados[i] = false;
		}
	}

}
