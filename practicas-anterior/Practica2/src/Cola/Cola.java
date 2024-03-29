package Cola;
import Listas.ListaGenericaEnlazada;

public class Cola<T> {
	private ListaGenericaEnlazada<T> datos = new ListaGenericaEnlazada<T>();
	
	public void encolar(T dato) {
		datos.agregarFinal(dato);
	}
	
	public T desencolar() {
		T dato = datos.elemento(1);
		datos.eliminarEn(1);
		return dato;
	}
	
	public boolean esVacia() {
		return datos.esVacia();
	}
}
