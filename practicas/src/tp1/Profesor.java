package tp1;

public class Profesor extends Persona {
	private String catedra;
	private String facultad;
	
	public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
		super(nombre, apellido, email);
		this.catedra = catedra;
		this.facultad = facultad;
	}
	
	@Override
	public String toString() {
		String aux = super.toString() + " Catedra: " + catedra + " Facultad " + facultad;
		return aux;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean aux = false;
		if (obj instanceof Profesor) {
			Profesor prof = (Profesor) obj;
			return super.equals(obj) && catedra.equals(prof.catedra) && facultad.equals(prof.facultad);
		}
		return aux;
	}
	

}
