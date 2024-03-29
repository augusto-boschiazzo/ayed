package punto1;

public class ppal {

	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		incisoA(a, b);
		incisoB(a, b);
		incisoC(a, b);
		
	}
	
	public static void incisoA(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void incisoB(int a, int b) {
		int i = a;
		while (i <= b) {
			System.out.println(i);
			i++;
		}
	}
	
	public static void incisoC(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			a++;
			incisoC(a, b);
		}
	}

}
