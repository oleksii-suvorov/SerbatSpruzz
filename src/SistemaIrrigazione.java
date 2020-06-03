public class SistemaIrrigazione {
	
	final int MAX_SERBATOI;
	final int MAX_SPRUZZATORI;
	
	private int nSerbatoi = 0;
	private int nSpruzzatori = 0;
	private double portataIn = 0;
	private Serbatoio[] serbatoi;
	private Spruzzatore[] spruzzatori;
	private double portata;
	private int capienza;
	private int capacitaResidua;
	private int c;
	
	
	public SistemaIrrigazione(int a, int b) {
		MAX_SERBATOI = a;
		MAX_SPRUZZATORI = b;
		serbatoi = new Serbatoio[MAX_SERBATOI];
		spruzzatori = new Spruzzatore[MAX_SPRUZZATORI];
	}
	
	public boolean aggiungiSerbatoio(Serbatoio serb) {
		if(nSerbatoi == MAX_SERBATOI) {
			return false;
		}
		serbatoi[nSerbatoi] = serb;
		nSerbatoi++;
		portata += serb.getPortata();
		capienza += serb.getCapienza();
		capacitaResidua += serb.getCapacitaAttuale();
		portataIn  += serb.getPortata();
		System.out.println(nSerbatoi);
		return true;
	}
	
	public boolean aggiungiSpruzzatore(Spruzzatore s) {
		if ( this.portataIn < s.getPortata()) {
			return false;
		} else {
			this.spruzzatori[nSpruzzatori++] = s;
			portata -= s.getPortata();
			portataIn -= s.getPortata();
			return true;
		}
		
	}
	
	public double attiva() {
		double litriPerMin = 15.0;
		double sumLitri = 0d;
		double controllo = 0;
		for(Serbatoio serb : serbatoi ) {
			controllo = serb.getCapacitaAttuale();
			if(controllo < litriPerMin) {
				System.out.println("System blocked.");
				return 0;
			}
	}
	for(Serbatoio serb : serbatoi ) {
		serb.svuotare(litriPerMin);
		sumLitri += litriPerMin;
	}
	return sumLitri;
	}
	
	public double attiva(int min) {
		double litriPerMin = 15.0;
		double sumLitri = 0d;
		double controllo = 0;
		for(Serbatoio serb : serbatoi ) {
				controllo = serb.getCapacitaAttuale();
				if(controllo < litriPerMin) {
					System.out.println("System blocked.");
					return 0;
				}
		}
		for(Serbatoio serb : serbatoi ) {
			serb.svuotare(litriPerMin * min);
			sumLitri += litriPerMin * min;
		}
		return sumLitri;
	}
	
	public void riempiSerbatoi() {
		for(Serbatoio serb : serbatoi ) {
			serb.riempi();
		}
	}
	
	public void printStato() {
		for(Serbatoio serb : serbatoi ) {
			System.out.println(serb);
		}
		for(Spruzzatore spr : spruzzatori ) {
			System.out.println(spr);
		}
	}
	
	public double getPortata() {
		return this.portata;
	}
	
	public double getPortataInutilizzata() {
		return this.portataIn;
	}
	
	
	public int getCapienza() {
		return this.capienza;
	}
	
	public double getCapacitaResidua() {
		return this.capacitaResidua;
	}

	public Serbatoio[] getSerbatoi() {
		return this.serbatoi;
	}

	public Spruzzatore[] getSpruzzatori() {
		return this.spruzzatori;
	}
	
	@Override
	public String toString() {
		

		String s = "";
		
		for(int i = 0; i < nSerbatoi; i++) {
			s+="Serbatoio " + serbatoi[i].getNome() + " capacita attuale " + (int)serbatoi[i].getCapacitaAttuale();
			
			if(i < nSerbatoi - 1)
				s += " - ";

		}
		
		return s;
		
	}
}
