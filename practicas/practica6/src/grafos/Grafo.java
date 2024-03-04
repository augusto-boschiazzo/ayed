package grafos;
import Listas.*;

public class Grafo<T> {
	ListaGenerica<Vertice<T>> vertices;
	
	public Grafo(){
		vertices = new ListaGenericaEnlazada<Vertice<T>>();
	}
	
	public void agregarVertice(Vertice<T> v){
		if(!vertices.incluye(v)) {
			v.setPosicion(vertices.tamanio());
			vertices.agregarFinal(v);
		}
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino) {
		origen.conectar(destino);
	}
	
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
		origen.conectar(destino, peso);
	}
	
	public void desconectar(Vertice<T> origen, Vertice<T> destino) {
		origen.desconectar(destino);
	}
	
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
		return origen.esAdyacente(destino);
	}
	
	public boolean esVacio() {
		return vertices.esVacia();
	}
	
	public ListaGenerica<Vertice<T>> listaDeVertices() {
		return vertices;
	}
	
	public int peso(Vertice<T> origen, Vertice<T> destino) {
		return origen.peso(destino);
	}
	
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
		return v.obtenerAdyacentes();
	}
	
	public Vertice<T> vertice(int posicion) {
		return vertices.elemento(posicion);
	}
	
	public ListaGenerica<Arista<T>> todosAdyacentes() {
		ListaGenericaEnlazada<Arista<T>> adyacentes = new ListaGenericaEnlazada<Arista<T>>();
		vertices.comenzar();
		while (!vertices.fin())
			adyacentes.combinarConLista(vertices.proximo().obtenerAdyacentes());
		return adyacentes;
	}
	

}
