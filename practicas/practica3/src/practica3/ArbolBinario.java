package practica3;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;
	
	public ArbolBinario() {
		this.dato = null;
		this.hijoDerecho = null;
		this.hijoIzquierdo = null;
	}
	
	public ArbolBinario(T dato){
		this.dato = dato;
		this.hijoDerecho = null;
		this.hijoIzquierdo = null;
	}
	
	public T getDato() {
		return dato;
	}
	
	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return hijoDerecho;
	}
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}
	
	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}
	
	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}
	
	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}
	
	public boolean esVacio() {
		return (this.dato == null) && (!this.tieneHijoDerecho() && !this.tieneHijoIzquierdo());
	}
	
	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());
	}
	
	public String toString() {
		if(!this.esVacio()) 
			return "Dato: " + dato;
		return "";
	}
	
	public boolean tieneHijoIzquierdo() {
		return (this.hijoIzquierdo != null);
	}
	
	public boolean tieneHijoDerecho() {
		return (this.hijoDerecho != null);
	}
	
	public int contarHojas() {
		int aux = 0;
		if(this.tieneHijoIzquierdo()) {
			aux += this.getHijoIzquierdo().contarHojas();
		}
		if(this.tieneHijoDerecho()) {
			aux += this.getHijoDerecho().contarHojas();
		}
		if(this.esHoja()) {
			aux = 1;
		}
		return aux;			
	}
	
	public ArbolBinario<T> espejo() {
		ArbolBinario<T> espejo = new ArbolBinario<T>(this.getDato());
		if (!this.esHoja()) {
			if(this.tieneHijoIzquierdo()) {
				espejo.agregarHijoDerecho(this.hijoIzquierdo.espejo());
			}
			if(this.tieneHijoDerecho()) {
				espejo.agregarHijoIzquierdo(this.hijoDerecho.espejo());
			}
		}
		return espejo;
	}
	
	public void entreNiveles(int n, int m) {
		int i = 0;
		if(!this.esVacio()) {
			ArbolBinario<T> arbol_aux = null;
			Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
			cola.encolar(this);
			cola.encolar(null);
			while(!cola.esVacia()) {
				arbol_aux = cola.desencolar();
				if (arbol_aux != null) {
					if (i >= n && i <= m) {
						System.out.println(arbol_aux.getDato());
					}
					if(arbol_aux.tieneHijoIzquierdo()) {
						cola.encolar(arbol_aux.hijoIzquierdo);
					}
					if(arbol_aux.tieneHijoDerecho()) {
						cola.encolar(arbol_aux.hijoDerecho);
					}
				}
				else if(cola.esVacia()) {
					cola.encolar(null);
				}
				i++;
			}
		}
	}
	
	
}
