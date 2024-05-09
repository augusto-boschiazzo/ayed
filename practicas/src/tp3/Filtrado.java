package tp3;

//Corresponde al ejercicio 10

import java.util.LinkedList;
import java.util.List;

public class Filtrado {
	private int valor;
	private List<Integer> lista;
	
	public Filtrado() {
		lista = new LinkedList<Integer>();
		valor = 0;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void agregarLista(int n) {
		lista.add(n);
	}
	
	public void eliminarUltimoLista() {
		if (!lista.isEmpty())
			lista.remove(lista.size() -1);
	}
	
	public List<Integer> getLista() {
		return lista;
	}
	
	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}
	

}
