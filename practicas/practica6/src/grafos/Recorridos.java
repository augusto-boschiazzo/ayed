package grafos;

import Listas.*;
import Cola.*;

public class Recorridos<T> {
	
	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		for(int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i]) {
				lista.combinarConLista(dfs(grafo, i, marca));
			}
		}
		return lista;
	}
	
	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo, int i, boolean[] marca) {
		marca[i] = true;
		Arista<T> arista = null;
		int j = 0;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			arista = ady.proximo();
			j = arista.getDestino().posicion();
			if (!marca[j])
				lista.combinarConLista(dfs(grafo, j, marca));
		}
		return lista;
	}
	
	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		for(int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i]) {
				lista.combinarConLista(bfs(grafo, i, marca));
			}
		}
		return lista;
	}
	
	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo, int i, boolean[] marca) {
		ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
		ListaGenerica<Arista<T>> ady = null;
		Cola<Vertice<T>> q = new Cola<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while(!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			lista.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.getDestino().posicion();
				if(!marca[j]) {
					Vertice<T> w = arista.getDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
		return lista;
	}
	

}
