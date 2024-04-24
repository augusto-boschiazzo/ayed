package tp3;

public class Ejercicio6Test {
	
	public static void main(String[] args) {
		GeneralTree<Character> a = new GeneralTree<Character>('a');
		GeneralTree<Character> b = new GeneralTree<Character>('b');
		a.addChild(b);
		GeneralTree<Character> c = new GeneralTree<Character>('c');
		a.addChild(c);
		GeneralTree<Character> d = new GeneralTree<Character>('d');
		a.addChild(d);
		GeneralTree<Character> e = new GeneralTree<Character>('e');
		a.addChild(e);
		GeneralTree<Character> f = new GeneralTree<Character>('f');
		c.addChild(f);
		GeneralTree<Character> g = new GeneralTree<Character>('g');
		c.addChild(g);
		GeneralTree<Character> h = new GeneralTree<Character>('h');
		d.addChild(h);
		GeneralTree<Character> i = new GeneralTree<Character>('i');
		d.addChild(i);
		GeneralTree<Character> j = new GeneralTree<Character>('j');
		d.addChild(j);
		GeneralTree<Character> k = new GeneralTree<Character>('k');
		d.addChild(k);
		GeneralTree<Character> l = new GeneralTree<Character>('l');
		d.addChild(l);
		GeneralTree<Character> m = new GeneralTree<Character>('m');
		g.addChild(m);
		GeneralTree<Character> n = new GeneralTree<Character>('n');
		j.addChild(n);
		GeneralTree<Character> o = new GeneralTree<Character>('o');
		j.addChild(o);
		
		RedDeAguaPotable ej = new RedDeAguaPotable(a);
		System.out.println(ej.minimoCaudal(1000));
	}
	
	
}
