package tp5;

public class AdjListEdge<T> implements Edge<T> {
	private Vertex<T> target;
	private int weight;
	
	protected AdjListEdge(Vertex<T> target, int weight) {
		this.target = target;
		this.weight = weight;
	}
	
	public Vertex<T> getTarget() {
		return target;
	}
	
	public int getWeight() {
		return weight;
	}
	

}
