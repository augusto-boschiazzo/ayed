package Pruebas;
import Listas.ListaGenericaEnlazada;

public class Ejercicio1_6 {
	public ListaGenericaEnlazada<Integer> calcularSucesion(Integer n) {
		if (n == 1) {
			ListaGenericaEnlazada<Integer> aux = new ListaGenericaEnlazada<Integer>();
			aux.agregarInicio(n);
			return aux;
		}
		else {
			if (n % 2 == 0) {
				ListaGenericaEnlazada<Integer> lista = calcularSucesion(n / 2);
				lista.agregarInicio(n);
				return lista;
			}
			else {
				ListaGenericaEnlazada<Integer> lista = calcularSucesion(n * 3 + 1);
				lista.agregarInicio(n);
				return lista;
			}
		}
	}
}
