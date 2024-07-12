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
	
	
}
