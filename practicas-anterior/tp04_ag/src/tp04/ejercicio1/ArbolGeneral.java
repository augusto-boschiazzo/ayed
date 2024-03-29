package tp04.ejercicio1;

import tp02.ejercicio2.Cola;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public int altura() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		int i = 0;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(aux != null) {
				aux.getHijos().comenzar();
				while(!aux.getHijos().fin()) {
					cola.encolar(aux.getHijos().proximo());
				}
			}
			else if(!cola.esVacia()) {
				cola.encolar(null); 
				i++;
			}
		}
		return(i);
	}
	public Integer nivel(T dato) {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		int i = 0;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(aux != null) {
				if(aux.getDato() == dato)
					return i;
				aux.getHijos().comenzar();
				while(!aux.getHijos().fin()) {
					cola.encolar(aux.getHijos().proximo());
				}
			}
			else if(!cola.esVacia()) {
				cola.encolar(null); 
				i++;
			}
		}
		return(-1);
	}

	public Integer ancho() {
		Cola<ArbolGeneral<T>> cola = new Cola<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		int cant = 0;
		int max = 0;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(aux != null) {
				aux.getHijos().comenzar();
				while(!aux.getHijos().fin()) {
					cola.encolar(aux.getHijos().proximo());
					cant++;
				}
			}
			else if(!cola.esVacia()) {
				cola.encolar(null); 
				if (cant > max) 
					max = cant;
				cant = 0;
			}
		}
		return(max);
	}

}