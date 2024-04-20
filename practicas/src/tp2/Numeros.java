package tp2;

public class Numeros {
	private int suma;
	private int resta;
	
	public Numeros(int suma, int resta) {
		this.suma = suma;
		this.resta = resta;
	}
	
	public int getSuma() {
		return suma;
	}
	
	public void setSuma(int suma) {
		this.suma = suma;
	}
	
	public int getResta() {
		return resta;
	}
	
	public void setResta(int resta) {
		this.resta = resta;
	}
	
	public String toString() {
		String aux = suma + "|" + resta;
		return aux;
	}
	

}
