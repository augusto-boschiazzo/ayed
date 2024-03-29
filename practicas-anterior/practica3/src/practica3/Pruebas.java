package practica3;

import tp03.ejercicio3.ContadorArbol;

public class Pruebas {
	
	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> derecho = new ArbolBinario<Integer>(30);
		ArbolBinario<Integer> izquierdo = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> otro = new ArbolBinario<Integer>(9);
		
		arbol.agregarHijoDerecho(derecho);
		arbol.agregarHijoIzquierdo(izquierdo);
		izquierdo.agregarHijoDerecho(otro);
		
		arbol.entreNiveles(1, 2);
		
		/**
		ContadorArbol contador = new ContadorArbol(arbol);
		
		ListaGenerica<Integer> lista = contador.numerosPares();
		
		System.out.println(lista.toString());
		**/
	}
}
