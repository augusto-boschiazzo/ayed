package Pruebas;
import Listas.ListaGenericaArreglo;

public class TestListaDeEnterosConArreglos {
	
	public static void main(String[] args) {
		ListaGenericaArreglo lista = new ListaGenericaArreglo(args.length);
		for (String n: args) {
			lista.agregarFinal(Integer.parseInt(n));
		}
		
		System.out.println(lista.toString());;
	}
}
