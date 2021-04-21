package implementation;

import model.Produkt;

public class Dienstleistung extends Produkt {
	private int stunden, personen;

	public Dienstleistung (String n, int p, int s){
		super(n); 
		stunden=s; 
		personen=p;
	}

	@Override
	public int gibPreis() {
		return 1242*stunden*personen;
	}

	@Override
	public String ausgeben() {
		return personen+ " Nasen f\u00FCr " +stunden+"h "+getName();
	}

	@Override
	public String getName() {
		return super.getName();
	}
}
