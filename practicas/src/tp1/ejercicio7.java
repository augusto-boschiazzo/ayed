package tp1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ejercicio7 {

	public static void main(String[] args) {
		LinkedList<Integer> lista = tresEne(5);
		int aux = sumarLinkedList(lista);
		lista.stream().forEach(n -> System.out.print(n + " "));
		System.out.println(aux);
	}
	
	public static void incisoA() {
		List<Persona> array = new LinkedList<Persona>();
		Estudiante est1 = new Estudiante("Augusto", "Boschiazzo", "augus@gmail.com", "Comision A", "Calle 12");
		Estudiante est2 = new Estudiante("Augusto", "Boschiazzo", "augus@gmail.com", "Comision A", "Calle 12");
		array.add(est1); array.add(new Profesor("Camila", "Fuentes", "camilafuentes@gmail.com", "Acustica", "FTS"));
		array.stream().forEach(p -> System.out.println(p.toString()));
		if (!array.contains(est2)) {
			array.add(est2);
		}
		array.stream().forEach(p -> System.out.println(p.toString()));
	}
	
	public static LinkedList<Integer> tresEne(Integer n){
		LinkedList<Integer> lista = new LinkedList<Integer>();
		tresEneR(lista, n);
		return lista;
	}
	
	public static void tresEneR(LinkedList<Integer> lista, Integer n) {
		if (n > 1) {
			lista.add(n);
			if (n % 2 != 0) {
				tresEneR(lista, (3 * n + 1));
			}
			else {
				tresEneR(lista, (n / 2));
			}
		}
		else {
			lista.add(n);
		}
	}
	
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		int aux = 0;
		if (!lista.isEmpty()) {
			aux = (int) lista.pop();
			aux += sumarLinkedList(lista);
		}
		return aux;
	}
	
	public static LinkedList<Integer> combinarOrdenado(LinkedList<Integer> lista1, LinkedList<Integer> lista2){
		LinkedList<Integer> nueva = new LinkedList<Integer>();
		while (!lista1.isEmpty() || !lista2.isEmpty()) {
			int n1 = lista1.pop();
			int n2 = lista2.pop();
		}
		return nueva;
	}
	
	
}
