package tp3;

import java.util.List;

public class TestEjercicio10 {
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(1);
		GeneralTree<Integer> a11 = new GeneralTree<Integer>(0);
		arbol.addChild(a11);
		GeneralTree<Integer> a12 = new GeneralTree<Integer>(1);
		arbol.addChild(a12);
		GeneralTree<Integer> a13 = new GeneralTree<Integer>(1);
		arbol.addChild(a13);
		GeneralTree<Integer> a21 = new GeneralTree<Integer>(1);
		a11.addChild(a21);
		GeneralTree<Integer> a22 = new GeneralTree<Integer>(1);
		a11.addChild(a22);
		GeneralTree<Integer> a23 = new GeneralTree<Integer>(1);
		a12.addChild(a23);
		GeneralTree<Integer> a24 = new GeneralTree<Integer>(0);
		a12.addChild(a24);
		GeneralTree<Integer> a25 = new GeneralTree<Integer>(0);
		a13.addChild(a25);
		GeneralTree<Integer> a31 = new GeneralTree<Integer>(1);
		a21.addChild(a31);
		GeneralTree<Integer> a32 = new GeneralTree<Integer>(1);
		a21.addChild(a32);
		GeneralTree<Integer> a33 = new GeneralTree<Integer>(1);
		a21.addChild(a33);
		GeneralTree<Integer> a34 = new GeneralTree<Integer>(0);
		a24.addChild(a34);
		GeneralTree<Integer> a35 = new GeneralTree<Integer>(0);
		a25.addChild(a35);
		GeneralTree<Integer> a41 = new GeneralTree<Integer>(1);
		a34.addChild(a41);
		GeneralTree<Integer> a42 = new GeneralTree<Integer>(0);
		a35.addChild(a42);
		GeneralTree<Integer> a43 = new GeneralTree<Integer>(0);
		a35.addChild(a43);
		
		List<Integer> lista = Ejercicio10.resolver(arbol);
		
		lista.stream().forEach(n -> System.out.print(n + " | "));
	}
	

}
