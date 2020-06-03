import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serbatoio {
	private int capienza;
	private double portata;
	private String nome;
	private int getCapacitaAttuale;
	private final int RIEMP;
	
	public Serbatoio (int capienza, double portata) {
		this(capienza, portata, "Default");
	}
	
	public Serbatoio (int capienza, double portata, String nome) {
		this.capienza = capienza;
		this.portata = portata;
		this.nome = nome;
		this.getCapacitaAttuale = capienza;
		this.RIEMP = capienza;
	}
	
	public int getCapienza() {
		return this.capienza;
	}
	
	public double getCapacitaAttuale() {
		return this.getCapacitaAttuale;
	}
	
	public double getPortata() {
		return this.portata;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void svuotare(double a) {
		this.getCapacitaAttuale -= a;
	}
	
	public void riempi() {
		this.getCapacitaAttuale = RIEMP;
	}
	
	public String toString() {
		return "Serbatoio " + this.nome + ": Capienza " +
	this.capienza + " l, Capacità attuale " + this.getCapacitaAttuale + 
	" l, Portata " + this.portata + " l/m";
	}
	
	

	public void readStatus(String file) throws IOException {
		try(FileReader in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);) {
			
			for(String s = br.readLine(); s != null; s = br.readLine()) {
				System.out.println(s);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeStatus(String file) throws IOException {
		try(FileWriter out = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(out);) {
			String s = "" + getCapacitaAttuale;
			bw.append(s);
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
