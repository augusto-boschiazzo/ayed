package tp1;

public class CircularQueue<T> extends Queue<T> {
	
	public T shift() {
		T aux = getData().removeFirst();
		getData().addLast(aux);
		return aux;
	}
	

}
