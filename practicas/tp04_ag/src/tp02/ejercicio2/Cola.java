package tp02.ejercicio2;

public class Cola<T> {
	private ListaEnlazadaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
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
