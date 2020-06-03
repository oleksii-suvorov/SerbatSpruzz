
public class Spruzzatore {
	private double portata;
	private String nome;
	
	public Spruzzatore() {
		this(5, "Default");
	}
	 
	public Spruzzatore(double portata) {
		this(portata, "Default");
	}
	
	public Spruzzatore(double portata, String nome) {
		this.portata = portata;
		this.nome = nome;
	}
	
	public double getPortata() {
		return this.portata;
	}
	
	public String toString() {
		return "Spruzzatore " + this.nome + ": portata " + + this.portata + " l/m";
	}
}
