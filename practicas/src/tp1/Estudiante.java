package tp1;

public class Estudiante extends Persona {
	private String comision;
	private String direccion;
	
	public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
		super(nombre, apellido, email);
		this.comision = comision;
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		String aux = super.toString() + " Comision: " + comision + " Direccion: " + direccion;
		return aux;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean aux = false;
		if (obj instanceof Estudiante) {
			Estudiante est = (Estudiante) obj;
			return super.equals(obj) && comision.equals(est.comision) && direccion.equals(est.direccion);
		}
		return aux;
	}
	

}
