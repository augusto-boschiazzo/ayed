package Pruebas;
import Listas.ListaGenericaEnlazada;

public class Pruebas {

	public static void main(String[] args) {
		Ejercicio1_6 f = new Ejercicio1_6();
		ListaGenericaEnlazada<Integer> lista = f.calcularSucesion(6);
		System.out.println(lista.toString());;
	}

}
