package tp1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ejercicio7 {

	public static void main(String[] args) {
		List<Persona> array = new LinkedList<Persona>();
		List<Persona> list = array;
		Estudiante est1 = new Estudiante("Augusto", "Boschiazzo", "augus@gmail.com", "Comision A", "Calle 12");
		Estudiante est2 = new Estudiante("Augusto", "Boschiazzo", "augus@gmail.com", "Comision A", "Calle 12");
		array.add(est1); array.add(new Profesor("Camila", "Fuentes", "camilafuentes@gmail.com", "Acustica", "FTS"));
		array.stream().forEach(p -> System.out.println(p.toString()));
		if (!array.contains(est2)) {
			array.add(est2);
		}
		array.stream().forEach(p -> System.out.println(p.toString()));
	}
	
}
