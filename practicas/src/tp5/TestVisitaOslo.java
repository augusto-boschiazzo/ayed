package tp5;

import java.util.LinkedList;
import java.util.List;

public class TestVisitaOslo {
	
	public static void main(String[] args) {
		Graph<String> grafo = new AdjListGraph<String>();
		grafo.createVertex("Ayuntamiento");
		grafo.createVertex("El Tigre");
		grafo.connect(grafo.search("Ayuntamiento"), grafo.search("El Tigre"));
		List<String> restringido = new LinkedList<String>();
		
		List<String> camino = VisitaOslo.paseoEnBici(grafo, "El Tigre", 100, restringido);
		
		for (String lugar: camino) {
			System.out.println(lugar + ", ");
		}
	}
	

}
