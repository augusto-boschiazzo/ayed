package tp5;

import java.util.List;

public interface Graph<T> {
	public Vertex<T> createVertex(T data);
	public void removeVertex(Vertex<T> vertex);
	public Vertex<T> search(T data);
	public void connect(Vertex<T> origin, Vertex<T> destination);
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight);
	public void disconnect(Vertex<T> origin, Vertex<T> destination);
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);
	public int weight(Vertex<T> origin, Vertex<T> destination);
	public boolean isEmpty();
	public List<Vertex<T>> getVertices();
	public List<Edge<T>> getEdges();
	public Vertex<T> getVertex(int position);
	public int getSize();
	

}
