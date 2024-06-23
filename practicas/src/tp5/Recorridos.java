package tp5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Recorridos<T> {
	
	public List<T> dfs(Graph<T> grafo) {
		List<T> lista = new LinkedList<T>();
		if (!grafo.isEmpty()) {
			boolean [] visitados = new boolean[grafo.getSize()];
			this.inicializarVisitados(visitados);
			for(int i = 0; i < grafo.getSize(); i++) {
				if (!visitados[i]) {
					this.dfs(i, grafo, lista, visitados);
				}
			}
		}
		return lista;
	}
	
	private void dfs(int i, Graph<T> grafo, List<T> lista, boolean[] visitados) {
		Vertex<T> vertex = grafo.getVertex(i);
		lista.add(vertex.getData());
		visitados[i] = true;
		Iterator<Edge<T>> it = grafo.getEdge(vertex).iterator();
		int j;
		while(it.hasNext()) {
			j = it.next().getTarget().getPosition();
			if (!visitados[j])
				dfs(j, grafo, lista, visitados);
		}
	}
	
	public List<T> bfs(Graph<T> grafo){
		List<T> lista = new LinkedList<T>();
		if (!grafo.isEmpty()) {
			boolean [] visitados = new boolean[grafo.getSize()];
			this.inicializarVisitados(visitados);
			for (int i = 0; i < grafo.getSize(); i++) {
				if (!visitados[i]){
					bfs(i, grafo, lista, visitados);
				}
			}
		}
		return lista;
	}
	
	private void bfs(int i, Graph<T> grafo, List<T> lista, boolean[] visitados) {
		Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
		cola.enqueue(grafo.getVertex(i));
		visitados[i] = true;
		int j;
		while(!cola.isEmpty()) {
			Vertex<T> vertex = cola.dequeue();
			lista.add(vertex.getData());
			Iterator<Edge<T>> it = grafo.getEdge(vertex).iterator();
			while (it.hasNext()) {
				Edge<T> edge = it.next();
				j = edge.getTarget().getPosition();
				if(!visitados[j]) {
					Vertex<T> vertexDest = edge.getTarget();
					cola.enqueue(vertexDest);
				}
			}
		}
		
	}
	
	private void inicializarVisitados(boolean[] visitados) {
		for (int i = 0; i < visitados.length; i++) {
			visitados[i] = false;
		}
	}
	

}
