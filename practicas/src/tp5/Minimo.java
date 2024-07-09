package tp5;

import java.util.LinkedList;
import java.util.List;

public class Minimo {
	private List<String> lista;
	private int min;
	
	public Minimo() {
		this.lista = new LinkedList<String>();
		this.min = 9999;
	}
	
	public List<String> getLista() {
		return lista;
	}
	
	public void setLista(List<String> lista) {
		this.lista = new LinkedList<String>(lista);
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
		

}
