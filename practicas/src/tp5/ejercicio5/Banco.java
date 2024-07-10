package tp5.ejercicio5;

import tp5.Graph;
import tp5.Vertex;
import tp5.Edge;
import tp1.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;


public class Banco {
	
	public static List<Persona> jubiladosSinCobrar(Graph<Persona> grafo, Persona empleado, int distanciaMax) {
		List<Persona> lista = new LinkedList<Persona>();
		if (!grafo.isEmpty()) {
			Vertex<Persona> v = grafo.search(empleado);
			if (v != null) {
				bfs(v.getPosition(), grafo, lista, distanciaMax);
			}
		}
		return lista;
	}
	
	private static void bfs(int i, Graph<Persona> grafo, List<Persona> lista, int distanciaMax) {
		boolean[] visitados = new boolean[grafo.getSize()];
		inicializarVisitados(visitados, grafo);
		int distancia = 0, cant = 0;
		Queue<Vertex<Persona>> q = new Queue<Vertex<Persona>>();
		q.enqueue(grafo.getVertex(i));
		q.enqueue(null);
		while(!q.isEmpty() && cant <= 40 && distancia < distanciaMax) {
			Vertex<Persona> v = q.dequeue();
			if (v != null) {
				visitados[v.getPosition()] = true;
				Iterator<Edge<Persona>> it = grafo.getEdge(v).iterator();
				while (it.hasNext() && cant <= 40) {
					Vertex<Persona> ady = it.next().getTarget();
					if (ady.getData() instanceof Jubilado) {
						lista.add(ady.getData());
						cant++;
					}
				}
			}
			else if (!q.isEmpty()) {
				q.enqueue(null);
				distancia++;
			}
		}
	}
	
	private static void inicializarVisitados(boolean[] visitados, Graph<Persona> grafo) {
		for (int i = 0; i < visitados.length; i++) {
			Persona p = grafo.getVertex(i).getData();
			if (p instanceof Jubilado) {
				Jubilado j = (Jubilado)p;
				visitados[i] = j.getCobro();
			}
			else {
				visitados[i] = false;
			}
		}
	}
	
	
}
