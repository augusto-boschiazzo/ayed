package tp1;

public class ejercicio2 {

	public static int[] primerosMult(int n) {
		int [] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = (i+1) * n;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int [] array = primerosMult(n);
		for (int i = 0; i < n; i++) {
			System.out.println(array[i]);
		}
	}
	
	
}
