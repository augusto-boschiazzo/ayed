package tp03.ejercicio3;

import practica3.ArbolBinario;
import practica3.ListaGenerica;
import practica3.ListaGenericaEnlazada;

public class ContadorArbol {
	private ArbolBinario<Integer> dato;
	
	public ContadorArbol(ArbolBinario<Integer> dato) {
		this.dato = dato;
	}
	

	public ListaGenerica<Integer> numerosPares(){
		ListaGenerica<Integer> lista = new ListaGenericaEnlazada<Integer>();
		contarParesInOrden(lista,dato);
		return lista;
		}
	
	private void contarParesInOrden(ListaGenerica<Integer> lista,ArbolBinario<Integer> arbol) {
		if (arbol.tieneHijoIzquierdo())
			contarParesInOrden(lista,arbol.getHijoIzquierdo());
		if (arbol.getDato() % 2 == 0)
			lista.agregarFinal(arbol.getDato());
		if (arbol.tieneHijoDerecho())
			contarParesInOrden(lista,arbol.getHijoDerecho());
	}
	

}
