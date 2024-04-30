package tp3;

public class Ejercicio9Test {
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(12);
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(12);
		arbol.addChild(a2);
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(25);
		arbol.addChild(a3);
		GeneralTree<Integer> a4 = new GeneralTree<Integer>(35);
		a2.addChild(a4);
		GeneralTree<Integer> a5 = new GeneralTree<Integer>(12);
		a2.addChild(a5);
		GeneralTree<Integer> a6 = new GeneralTree<Integer>(25);
		a3.addChild(a6);
		GeneralTree<Integer> a7 = new GeneralTree<Integer>(35);
		a4.addChild(a7);
		GeneralTree<Integer> a8 = new GeneralTree<Integer>(14);
		a5.addChild(a8);
		GeneralTree<Integer> a9 = new GeneralTree<Integer>(12);
		a5.addChild(a9);
		GeneralTree<Integer> a10 = new GeneralTree<Integer>(33);
		a5.addChild(a10);
		GeneralTree<Integer> a11 = new GeneralTree<Integer>(35);
		a7.addChild(a11);
		GeneralTree<Integer> a12 = new GeneralTree<Integer>(35);
		a10.addChild(a12);
		GeneralTree<Integer> a13 = new GeneralTree<Integer>(83);
		a10.addChild(a13);
		GeneralTree<Integer> a14 = new GeneralTree<Integer>(90);
		a10.addChild(a14);
		GeneralTree<Integer> a15 = new GeneralTree<Integer>(33);
		a10.addChild(a15);
		
		System.out.println(Ejercicio9.esDeSeleccion(arbol));
	}
	

}
