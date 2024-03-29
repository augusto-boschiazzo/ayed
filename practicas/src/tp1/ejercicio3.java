package tp1;

public class ejercicio3 {
	
	public static void main(String[] args) {
		Persona [] array = new Persona[5];
		array[0] = new Estudiante("Augusto", "Boschiazzo", "augus@gmail.com", "Comision A", "Calle 12");
		array[1] = new Profesor("Camila", "Fuentes", "camilafuentes@gmail.com", "Acustica", "FTS");
		for (int i = 0; i < 2; i++) {
			System.out.println(array[i].toString());
		}
	}
	

}
