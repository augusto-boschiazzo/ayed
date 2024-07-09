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
		Minimo min = new Minimo();
		if (!mapaCiudades.isEmpty()) {
			boolean[] visitado = new boolean[mapaCiudades.getSize()];
			inicializarVisitados(visitado);
			Vertex<String> ciudad = mapaCiudades.search(origen);
			if (ciudad != null) {
				List<String> lista = new LinkedList<String>();
				dfsCorto(ciudad.getPosition(), lista, visitado, destino, min, 0);
			}
		}
		return min.getLista();
	}
	
	private void dfsCorto(int i, List<String> lista, boolean[] visitado, String destino, Minimo min, int peso) {
		Vertex<String> v = mapaCiudades.getVertex(i);
		String ciudad = v.getData();
		lista.add(ciudad);
		if (ciudad.equals(destino)) {
			if (peso < min.getMin()) {
				min.setMin(peso);
				min.setLista(lista);
			}
		}
		else {
			visitado[i] = true;
			Iterator<Edge<String>> it = mapaCiudades.getEdge(v).iterator();
			while (it.hasNext()) {
				Edge<String> edge = it.next();
				int j = edge.getTarget().getPosition();
				dfsCorto(j, lista, visitado, destino, min, peso + edge.getWeight());
			}
		}
		lista.remove(lista.size() -1);
	}
	
	public List<String> caminoSinCargar(String origen, String destino, int tanqueAuto) {
		List<String> lista = new LinkedList<String>();
		if (!mapaCiudades.isEmpty()) {
			boolean[] visitado = new boolean[mapaCiudades.getSize()];
			inicializarVisitados(visitado);
			Vertex<String> ciudad = mapaCiudades.search(origen);
			if (ciudad != null) {
				dfsSinCargar(ciudad.getPosition(), lista, visitado, destino, tanqueAuto, 0);
			}
		}
		return lista;
	}
	
	private boolean dfsSinCargar(int i, List<String> lista, boolean[] visitado, String destino, int tanqueAuto, int peso) {
		Vertex<String> v = mapaCiudades.getVertex(i);
		String ciudad = v.getData();
		lista.add(ciudad);
		boolean encontrado = false;
		if (ciudad.equals(destino)) {
			encontrado = true;
		}
		else {
			Iterator<Edge<String>> it = mapaCiudades.getEdge(v).iterator();
			visitado[i] = true;
			while (it.hasNext() && !encontrado) {
				Edge<String> edge = it.next();
				peso += edge.getWeight();
				int j = edge.getTarget().getPosition();
				if (peso <= tanqueAuto) {
					encontrado = dfsSinCargar(j, lista, visitado, destino, tanqueAuto, peso);
				}
				peso -= edge.getWeight();
			}
		}
		if (!encontrado)
			lista.remove(lista.size() -1);
		return encontrado;
	}
	
	
	
	
	private void inicializarVisitados(boolean[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			visitados[i] = false;
		}
	}

}
