package tp3;

import java.util.LinkedList;

public class Queue<T> {
	private LinkedList<T> data;

	public Queue() {
		data = new LinkedList<T>();
	}
	
	public void enqueue(T e) {
		data.add(e);
	}
	
	public T dequeue() {
		return data.removeFirst();
	}
	
	public T head() {
		return data.getFirst();
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public String toString() {
		String aux = "";
		for (T e: data) {
			aux += e.toString() + " ";
		}
		return aux;
	}
	
	protected LinkedList<T> getData(){
		return data;
	}
	

}
