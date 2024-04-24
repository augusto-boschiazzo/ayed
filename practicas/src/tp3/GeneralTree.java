package tp3;

import java.util.Iterator;
import java.util.LinkedList;

public class GeneralTree<T> {
	private T data;
	private LinkedList<GeneralTree<T>> children;
	
	public GeneralTree (T data) {
		this.data = data;
		children = new LinkedList<GeneralTree<T>>();
	}
	
	public GeneralTree (T data, LinkedList<GeneralTree<T>> children) {
		this.data = data;
		this.children = children;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public LinkedList<GeneralTree<T>> getChildren() {
		return children;
	}
	
	public void setChildren(LinkedList<GeneralTree<T>> children) {
		this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		children.add(child);
	}
	
	public boolean isLeaf() {
		return children.isEmpty();
	}
	
	public boolean hasChildren() {
		return !this.isLeaf();
	}
	
	public boolean isEmpty() {
		return this.data == null && this.isLeaf();
	}
	
	public void removeChild(GeneralTree<T> arbol) {
		children.remove(arbol);
	}
	
	public int altura() {
		int max = -1;
		if (!this.isEmpty())
			alturaRecur(this, 1, max);
		return max;
	}
	
	private void alturaRecur(GeneralTree<T> arbol, int altura, int max) {
		if (altura > max) {
			max = altura;
		}
		Iterator<GeneralTree<T>> it = children.iterator();
		if (it.hasNext()) {
			alturaRecur(it.next(), altura+1, max);
		}
	}
	
	public int nivel(T dato) {
		int nivel = 0;
		if (!this.isEmpty())
			nivel = nivelRecur(this, dato, nivel);
		return nivel;
	}
	
	private int nivelRecur(GeneralTree<T> arbol, T dato, int nivel) {
		int encontrado = 0;
		if (arbol.getData().equals(dato))
			encontrado = nivel;
		else {
			Iterator<GeneralTree<T>> it = children.iterator();
			while (it.hasNext() && encontrado == 0) {
				encontrado = nivelRecur(it.next(), dato, nivel+1);
			}
		}
		return encontrado;
	}
	
	public int ancho() {
		int ancho = 0;
		if (!this.isEmpty())
			ancho(this, ancho);
		return ancho;
	}
	
	private void ancho(GeneralTree<T> arbol, int max) {
		int ancho = 0;
		Iterator<GeneralTree<T>> it = children.iterator();
		while (it.hasNext()) {
			ancho++;
			ancho(it.next(), max);
		}
		if (ancho > max)
			max = ancho;
	}
	
	public boolean esAncestro(T a, T b) {
		if (!this.isEmpty()) {
			GeneralTree<T> sub = this.buscarSubArbol(a);
			if (sub != null) {
				return sub.buscarSubArbol(b) != null;
			}
		}
		return false;
	}
	
	public GeneralTree<T> buscarSubArbol(T e) {
		GeneralTree<T> arbol = null;
		if (this.getData().equals(e)) {
			arbol = this;
		}
		else {
			if (this.hasChildren() && arbol == null) {
				Iterator<GeneralTree<T>> it = this.getChildren().iterator();
				while (it.hasNext()) {
					it.next().buscarSubArbol(e);
				}
			}
		}
		return arbol;
	}
	

}
