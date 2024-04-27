package tp3;

public class TestEjercicio11 {
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbol = new GeneralTree<Integer>(0);
		GeneralTree<Integer> arbol1 = new GeneralTree<Integer>(0);
		arbol.addChild(arbol1);
		GeneralTree<Integer> arbol2 = new GeneralTree<Integer>(0);
		arbol.addChild(arbol2);
		GeneralTree<Integer> arbol3 = new GeneralTree<Integer>(0);
		arbol1.addChild(arbol3);
		GeneralTree<Integer> arbol4 = new GeneralTree<Integer>(0);
		arbol1.addChild(arbol4);
		GeneralTree<Integer> arbol5 = new GeneralTree<Integer>(0);
		arbol2.addChild(arbol5);
		GeneralTree<Integer> arbol6 = new GeneralTree<Integer>(0);
		arbol3.addChild(arbol6);
		GeneralTree<Integer> arbol7 = new GeneralTree<Integer>(0);
		arbol4.addChild(arbol7);
		GeneralTree<Integer> arbol8 = new GeneralTree<Integer>(0);
		arbol4.addChild(arbol8);
		GeneralTree<Integer> arbol9 = new GeneralTree<Integer>(0);
		arbol4.addChild(arbol9);
		GeneralTree<Integer> arbol10 = new GeneralTree<Integer>(0);
		arbol6.addChild(arbol10);
		GeneralTree<Integer> arbol11 = new GeneralTree<Integer>(0);
		arbol9.addChild(arbol11);
		GeneralTree<Integer> arbol12 = new GeneralTree<Integer>(0);
		arbol9.addChild(arbol12);
		GeneralTree<Integer> arbol13 = new GeneralTree<Integer>(0);
		arbol9.addChild(arbol13);
		GeneralTree<Integer> arbol14 = new GeneralTree<Integer>(0);
		arbol9.addChild(arbol14);
		
		System.out.println(Ejercicio11.resolver(arbol));
	}
	

}
