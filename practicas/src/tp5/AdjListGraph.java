		package tp5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjListGraph<T> implements Graph<T> {
	private List<AdjListVertex<T>> vertices;
	
	public AdjListGraph() {
		vertices = new LinkedList<AdjListVertex<T>>();
	}
	
	public Vertex<T> createVertex(T data) {
		int newPos = this.vertices.size();
		AdjListVertex<T> vertex = new AdjListVertex<T>(data, newPos);
		this.vertices.add(vertex);
		return vertex;
	}
	
	public void removeVertex(Vertex<T> vertex) {
		int position = vertex.getPosition();
		if (this.vertices.get(position) != vertex) {
			return;
		}
		this.vertices.remove(vertex);
		for (;position < this.vertices.size(); position++) {
			this.vertices.get(position).decrementPosition();
		}
		for (Vertex<T> other: this.vertices) {
			this.disconnect(other, vertex);
		}
	}
	
	public Vertex<T> search(T data) {
		for (Vertex<T> vertex: this.vertices) {
			if (vertex.getData().equals(data)) {
				return vertex;
			}
		}
		return null;
	}
	
	public boolean belongs(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		return pos >= 0 && pos < this.vertices.size() && this.vertices.get(pos) == vertex;
	}
	
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		if (this.belongs(origin) && this.belongs(destination)){
			((AdjListVertex<T>) origin).connect(destination);
		}
	}
	
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		if (this.belongs(origin) && this.belongs(destination)){
			((AdjListVertex<T>) origin).connect(destination, weight);
		}
	}
	
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		if (this.belongs(origin)) {
			((AdjListVertex<T>) origin).disconnect(destination);
		}
	}
	
	private Edge<T> edge(Vertex<T> origin, Vertex<T> destination) {
		if (this.belongs(origin)) {
			return ((AdjListVertex<T>) origin).getEdge(destination);
		}
		return null;
	}
	
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		return this.edge(origin, destination) != null;
	}
	
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		Edge<T> edge = this.edge(origin, destination);
		int weight = 0;
		if (edge != null)
			weight = edge.getWeight();
		return weight;
	}
	
	public boolean isEmpty() {
		return this != null || this.vertices.isEmpty();
	}
	
	public List<Vertex<T>> getVertices() {
		return new ArrayList<>(this.vertices);
	}
	
	public List<Edge<T>> getEdge(Vertex<T> vertex) {
		if (this.belongs(vertex)) {
			return ((AdjListVertex<T>) vertex).getEdges();
		}
		return null;
	}
	
	public Vertex<T> getVertex(int position) {
		if (position < 0 || position > this.vertices.size())
			return null;
		return this.vertices.get(position);
	}
	
	public int getSize() {
		return this.vertices.size();
	}
	
	
}
