package tp5.ejercicio5;

public class Jubilado extends Persona {
	private boolean cobro;
	
	public Jubilado(String nombre, boolean cobro) {
		super(nombre);
		this.cobro = cobro;
	}
	
	public boolean getCobro() {
		return cobro;
	}
	
	
}
