package grafos;
import Listas.*;

public class Vertice<T> {
	private T dato;
	private ListaGenerica<Arista<T>> adyacentes;
	private int posicion;
	
	public Vertice(T dato) {
		this.dato = dato;
		adyacentes = new ListaGenericaEnlazada<Arista<T>>();
	}
	
	public T dato() {
		return dato;
	}
	
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public int posicion() {
		return posicion;
	}
	
	public void conectar(Vertice<T> v) {
		conectar(v, 1);
	}
	
	public void conectar(Vertice<T> v, int peso) {
		Arista<T> a = new Arista<T>(v, peso);
		if (!adyacentes.incluye(a))
			adyacentes.agregarFinal(a);
	}
	
	public void desconectar(Vertice<T> v) {
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			Arista<T> a = adyacentes.proximo();
			if (a.getDestino().equals(v)) {
				adyacentes.eliminar(a);
				break;
			}
		}
	}
	
	public ListaGenerica<Arista<T>> obtenerAdyacentes(){
		return adyacentes;
	}
	
	public boolean esAdyacente(Vertice<T> v) {
		boolean aux = false;
		adyacentes.comenzar();
		while (!adyacentes.fin() && !aux){
			if (adyacentes.proximo().getDestino().equals(v))
				aux = true;
		}
		return aux;
	}
	
	public int peso(Vertice<T> v) {
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			Arista<T> a = adyacentes.proximo();
			if (a.getDestino().equals(v)) {
				return a.getPeso();
			}
		}
		return 0;
	}
	
	public Arista<T> obtenerArista(Vertice<T> v){
		adyacentes.comenzar();
		while (!adyacentes.fin()) {
			Arista<T> a = adyacentes.proximo();
			if (a.getDestino().equals(v)) {
				return a;
			}
		}
		return null;
	}
	
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	

}
