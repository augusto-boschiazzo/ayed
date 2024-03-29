package tp04.ejercicio1;

import tp02.ejercicio2.Cola;

public class Pruebas {
	public static void recorridoPorNiveles(ArbolGeneral<Integer> a, int n, int m) {
		Cola<ArbolGeneral<Integer>> cola = new Cola<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		int i = 0;
		cola.encolar(a);
		cola.encolar(null);
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(aux != null) {
				if(i >= n && i <= m)
					System.out.println(aux.getDato());
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
		System.out.println(i);
	}
	
	public static void main(String args[]) {
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> h11 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> h12 = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> h13 = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> h21 = new ArbolGeneral<Integer>(21);
		ArbolGeneral<Integer> h22 = new ArbolGeneral<Integer>(22);
		
		h11.agregarHijo(h21);
		h12.agregarHijo(h22);
		a.agregarHijo(h11);
		a.agregarHijo(h12);
		a.agregarHijo(h13);
		
		recorridoPorNiveles(a, 0, 1);
	}
}
