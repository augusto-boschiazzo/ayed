package Pruebas;
import Listas.ListaGenericaEnlazada;

public class TestListaDeEnterosEnlazada {
	
	public static void main(String[] args) {
		ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
		for (String n: args) {
			lista.agregarFinal(Integer.parseInt(n));
		}
		
		System.out.println(lista.toString());
		lista.comenzar();
		
		impRec(lista);
		
		ListaGenericaEnlazada<Integer> otra = new ListaGenericaEnlazada<Integer>();
		for (String n: args) {
			otra.agregarFinal(Integer.parseInt(n));
		}
		
		lista.combinarConListaEnlazada(otra);
		System.out.println(lista.toString());
	}
	
	public static void impRec(ListaGenericaEnlazada<Integer> lista) {
		Integer aux = lista.proximo();
		if (!lista.fin())
			impRec(lista);
		System.out.println(aux);
	}
	
	
}
