package tp1;

public class ejercicio1 {

	public static void incisoFor(int a, int b) {
		for (int i = a; i < b; i++) {
			System.out.println(i);
		}
	}
	
	public static void incisoWhile(int a, int b) {
		boolean aux = a < b;
		while (aux) {
			System.out.println(a++);
			aux = a < b;
		}
	}
	
	public static void incisoRecur(int a, int b) {
		if (a < b) {
			System.out.println(a);
			incisoRecur(a+1,b);
		}
	}
	
	public static void main(String[] args) {
		incisoFor(1,5);
		incisoWhile(1,5);
		incisoRecur(1,5);
	}
	
	
}
