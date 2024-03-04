package Listas;

public class ListaGenericaEnlazada<T> extends ListaGenerica<T> {
	private NodoGenerico<T> inicio;
	private NodoGenerico<T> actual;
	private NodoGenerico<T> fin;
	
	public void comenzar() {
		actual = inicio;
	}
	
	public T proximo() {
		T dato = actual.getDato();
		actual = actual.getSiguiente();
		return dato;
	}
	
	public boolean fin() {
		return (actual == null);
	}
	
	public T elemento(int pos) {
		if(pos < 1 || pos > this.tamanio) {
			return null;
		}
		NodoGenerico<T> n = this.inicio;
		while (pos-- > 1)
			n = n.getSiguiente();
		return n.getDato();
	}
	
	public boolean agregarEn(T elem, int pos) {
		if (pos < 1 || pos > this.tamanio + 1) // posicion no valida
			return false;
		this.tamanio++;
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(elem);
		if (pos == 1) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
			if (tamanio == 1) {
				this.fin=this.inicio;
			}
		} else {
			NodoGenerico<T> n = this.inicio;
			NodoGenerico<T> ant = null;
			int posActual = 1;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}
	
	@Override
	public boolean agregarInicio(T elem) {
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(T elem) {
		NodoGenerico<T> aux = new NodoGenerico<T>();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}
	
	@Override
	public boolean eliminar(T elem) {
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null) {
				this.inicio = this.inicio.getSiguiente();
				this.fin = this.inicio;
			}else {
				ant.setSiguiente(n.getSiguiente());
				if (actual==n)
					actual = n.getSiguiente();
			}
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 1 || pos > this.tamanio) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 1) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoGenerico<T> n = this.inicio;
		NodoGenerico<T> ant = null;
		while (!(n == null) && (pos > 1)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		
		if (actual==n)
			actual = n.getSiguiente();
		
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}
	
	public boolean esVacia() {
		return (this.inicio == null);
	}
	
	public boolean incluye(T elem) {
		int i = this.tamanio;
		NodoGenerico<T> n = this.inicio;
		while (i-- > 0) {
			if (n.getDato() == elem) {
				return true;
			}
			n = n.getSiguiente();
		}
		return false;
	}
	
	public boolean reemplazarEn(T elem, int pos) {
		if(pos < 1 || pos > this.tamanio + 1) {
			return false;
		}
		NodoGenerico<T> n = this.inicio;
		for (int i = 0; i < pos; i++) {
			n = n.siguiente;
		}
		n.dato = elem;
		return true;
	}
	
	public ListaGenerica<T> clonar() {
		NodoGenerico<T> punteroPrevio = this.actual;
		ListaGenerica<T> nueva = new ListaGenericaEnlazada<T>();
		this.comenzar();
		while(!this.fin()) {
			nueva.agregarFinal(this.proximo());
		}
		this.actual = punteroPrevio;
		return nueva;
	}
	
	public String toString() {
		String aux = "";
		this.comenzar();
		for (int i = 0; i < tamanio; i++) {
			aux += this.proximo() + " ";
		}
		return aux;
	}

	public void combinarConListaEnlazada(ListaGenerica<T> otra) {
		otra.comenzar();
		for (int i = 0; i < otra.tamanio; i++) {
			this.agregarFinal(otra.proximo());
		}
	}
	

}
