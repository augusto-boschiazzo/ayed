package tp3;

import java.util.LinkedList;

public class GeneralTree<T> {
	private T data;
	private LinkedList<GeneralTree<T>> children;
	
	public GeneralTree (T data) {
		this.data = data;
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
		int altura = 0;
		
		return altura;
	}
	
	private int alturaRecur(GeneralTree<T> arbol) {
		int altura = 0;
		
		return altura;
	}
	

}
