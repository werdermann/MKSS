

public class BestelllisteMain {
	public static void main(String[] args) {
		Bestellliste bestelliste = new Bestellliste();

		IProduktFactory[] bestellungen = new IProduktFactory[3];
		bestellungen[0] = new MaterialFactory();
		bestellungen[1] = new DienstleistungFactory();
		bestellungen[2] = new SoftwareFactory();

		bestelliste.setProduktFactories(bestellungen);

		bestelliste.menuloop();
	}
}
