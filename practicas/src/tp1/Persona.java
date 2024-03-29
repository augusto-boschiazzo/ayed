package tp1;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String email;
	
	public Persona(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public String toString() {
		String aux = "Nombre: " + nombre + " Apellido: " + apellido + " Email: " + email;
		return aux;
	}
	
	public boolean equals(Object obj) {
		boolean aux = false;
		if(obj instanceof Persona) {
			Persona per = (Persona) obj;
			aux = nombre.equals(per.nombre) && apellido.equals(per.apellido) && email.equals(per.email);
		}
		return aux;
	}
	

}
