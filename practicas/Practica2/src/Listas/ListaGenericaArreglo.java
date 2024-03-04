package Listas;

public class ListaGenericaArreglo {
	private Integer[] datos;
	private int actual = 0;
	private int tamanio;
	
	public ListaGenericaArreglo (int dimF) {
		datos = new Integer[dimF];
		tamanio = 0;
	}
	
	public void comenzar() {
		actual = 0;
	}
	
	public Integer proximo() {
		return datos[actual++];
	}
	
	public boolean fin() {
		return actual == tamanio;
	}
	
	public Integer elemento(int pos) {
		return datos[pos -1];
	}
	
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 1 || pos > tamanio + 1 || pos > datos.length || tamanio > datos.length) {
			return false;
		}
		tamanio++;
		for (int i = tamanio -1; i >= pos; i--) {
			datos[i] = datos[i -1];
		}
		datos[pos -1] = elem;
		return true;
	}
	
	public boolean agregarInicio(Integer elem) {
		if (tamanio +1 > datos.length) {
			return false;
		}
		tamanio++;
		for (int i = tamanio -1; i >= 0; i--) {
			datos[i] = datos[i-1];
		}
		datos[0] = elem;
		return true;
	}
	
	public boolean agregarFinal(Integer elem) {
		if (tamanio +1 > datos.length) {
			return false;
		}
		datos[tamanio] = elem;
		tamanio++;
		return true;
	}
	
	public boolean eliminar(Integer elem) {
		for (int i = 0; i < datos.length; i++) {
			if (datos[i].equals(elem)) {
				for (int j = i; j < datos.length-1; j++) {
					datos[j] = datos[j+1];
				}
				tamanio--;
				return true;
			}
		}
		return false;
	}
	
	public boolean eliminarEn(int pos) {
		if (pos > datos.length || pos > tamanio)
			return false;
		for (int i = pos; i < datos.length-1; i++) {
			datos[i] = datos[i+1];
		}	
		tamanio--;
		return true;
	}
	
	public boolean incluye(Integer elem) {
		for (Integer dato: datos) {
			if (dato.equals(elem)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean esVacia() {
		return tamanio == 0;
	}
	
	public String toString() {
		String aux = "";
		for (Integer n: datos) {
			aux += n + " ";
		}
		return aux;
	}
	

}
