package repaso;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.Queue;
import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;

public class Parcial {

	public List<Auxiliar> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite) {
		List<Auxiliar> lista = new LinkedList<Auxiliar>();
		if (!red.isEmpty()) {
			Vertex<String> origen = red.search(usuario);
			if (origen != null) {
				bfs(origen.getPosition(), red, lista, distancia, limite);
			}
		}
		return lista;
	}
	
	private void bfs(int i, Graph<String> red, List<Auxiliar> lista, int distanciaMax, int limite) {
		Vertex<String> v = red.getVertex(i);
		Queue<Vertex<String>> q = new Queue<Vertex<String>>();
		q.enqueue(v);
		q.enqueue(null);
		boolean[] visitados = new boolean[red.getSize()];
		inicializarVisitados(visitados);
		visitados[i] = true;
		int cant = 0, distanciaAct = 1;
		while(!q.isEmpty() && cant < limite && distanciaAct <= distanciaMax) {
			Vertex<String> act = q.dequeue();
			if (act != null) {
				Iterator<Edge<String>> it = red.getEdge(act).iterator();
				while (it.hasNext() && cant < limite) {
					Vertex<String> ady = it.next().getTarget();
					q.enqueue(ady);
					visitados[ady.getPosition()] = true;
					cant++;
				}
			}
			else if (!q.isEmpty()) {
				q.enqueue(null);
				distanciaAct++;
			}
		}
	}
	
	private void inicializarVisitados(boolean[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			visitados[i] = false;
		}
	}
	
	public List<String> resolver(Graph<String> ciudades, String origen, String destino, List<String> pasandoPor) {
		List<String> lista = new LinkedList<String>();
		if(!ciudades.isEmpty()) {
			Vertex<String> ciudad = ciudades.search(origen);
			if(ciudad != null) {
				boolean[] visitados = new boolean[ciudades.getSize()];
				inicializarVisitados(visitados);
				dfs(ciudad.getPosition(), ciudades, lista, destino, visitados, pasandoPor);
			}
		}
		return lista;
	}
	
	private boolean dfs(int i, Graph<String> ciudades, List<String> lista, String destino, boolean[] visitados, List<String> pasandoPor) {
		boolean encontrado = false;
		Vertex<String> act = ciudades.getVertex(i);
		String ciudad = act.getData();
		lista.add(ciudad);
		if (ciudad.equals(destino)) {
			if (listaContieneLista(lista, pasandoPor)) {
				encontrado = true;
			}
		}
		else {
			visitados[i] = true;
			Iterator<Edge<String>> it = ciudades.getEdge(act).iterator();
			while(it.hasNext() && !encontrado) {
				Vertex<String> ady = it.next().getTarget();
				int j = ady.getPosition();
				dfs(j, ciudades, lista, destino, visitados, pasandoPor);
			}
		}
		if (!encontrado) {
			lista.remove(lista.size() -1);
		}
		return encontrado;
	}
	
	private boolean listaContieneLista(List<String> camino, List<String> pasandoPor) {
		boolean aux = true;
		for(String s: pasandoPor) {
			aux = aux && camino.contains(s);
		}
		return aux;
	}
	
	
}
