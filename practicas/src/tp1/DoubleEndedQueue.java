package tp1;

public class DoubleEndedQueue<T> extends Queue<T> {
	
	public void enqueueFirst(T e) {
		getData().addFirst(e);
	}

}
