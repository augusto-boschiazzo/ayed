package Pila;
import Listas.ListaGenericaEnlazada;

public class Pila<T> {
	private ListaGenericaEnlazada<T> datos = new ListaGenericaEnlazada<T>();
	
	public void apilar(T dato) {
		datos.agregarEn(dato, 1);
	}
	
	public T desapilar() {
		T dato = datos.elemento(1);
		datos.eliminarEn(1);
		return dato;
	}
	
	public T tope() {
		return datos.elemento(1);
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
}
