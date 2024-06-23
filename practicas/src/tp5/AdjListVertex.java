package tp5;

import java.util.LinkedList;
import java.util.List;

public class AdjListVertex<T> implements Vertex<T> {
	private T data;
	private int position;
	private List<Edge<T>> edges;
	
	protected AdjListVertex(T data, int position) {
		this.data = data;
		this.position = position;
		edges = new LinkedList<Edge<T>>();
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public int getPosition() {
		return position;
	}
	
	public List<Edge<T>> getEdges() {
		return this.edges;
	}
	
	public Edge<T> getEdge(Vertex<T> destination){
		for (Edge<T> edge: edges) {
			if (edge.getTarget().equals(destination)) {
				return edge;
			}
		}
		return null;
	}
	
	protected void decrementPosition() {
		position--;
	}
	
	protected void connect(Vertex<T> vertex) {
		this.connect(vertex, 1);
	}
	
	protected void connect(Vertex<T> destination, int weight) {
		Edge<T> edge = this.getEdge(destination);
		if (edge == null)
			this.edges.add(new AdjListEdge<>(destination, weight));
	}
	
	public void disconnect(Vertex<T> vertex) {
		Edge<T> edge = this.getEdge(vertex);
		if (edge != null)
			this.edges.remove(edge);
	}

}
