package grafos;

public class Arista<T> {
	private Vertice<T> destino;
	private int peso;
	
	public Arista(Vertice<T> destino, int peso) {
		this.destino = destino;
		this.peso = peso;
	}

	public Vertice<T> getDestino() {
		return destino;
	}
	
	public int getPeso() {
		return peso;
	}

	
}
