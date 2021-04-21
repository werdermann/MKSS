package main;

import frontend.Bestellliste;
import implementation.DienstleistungFactory;
import implementation.MaterialFactory;
import implementation.SoftwareFactory;
import model.IProduktFactory;

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
