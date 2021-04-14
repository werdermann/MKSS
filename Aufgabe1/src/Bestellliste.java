import java.util.ArrayList;
import java.util.Scanner;

public class Bestellliste {
	private ArrayList<Produkt> produkte = new ArrayList<>();

	public void menuloop() 
	{
		int eingabe;
		do {
			menueAusgeben();
			eingabe = Eingabe.leseInt();
			switch(eingabe)
			{
				case 0: break ;
				case 1: materialBestellen(); break ;
				case 2: dienstleistungBestellen(); break ;
				default: System.out.println("ungültig" ); break ;
			}
		} while(eingabe != 0);
		bestellungSortieren() ;
		bestellungBeenden() ;
	}
	
	private void menueAusgeben() {
		System.out.println("Was wollen Sie machen?");
		System.out.println("(0) Bestellung beenden");
		System.out.println("(1) Material bestellen");
		System.out.println("(2) Dienstleistung bestellen");
	}
	
	private void bestellungSortieren() {
		for(int i = 0; i<produkte.size()-1; i++) {
			for(int j = 0; j<produkte.size()-1; j++) {
				if( produkte.get(j + 1) != null &&
					produkte.get(j + 1).gibPreis ()< produkte.get(j).gibPreis()) {
					Produkt temp = produkte.get(j + 1);
					produkte.set(j + 1, produkte.get(j));
					produkte.set(j, temp);
				}
			}
		}
	}
	
	private void materialBestellen() {
		System.out.println("Name ");
		String l = Eingabe.leseString();
		System.out.println("Stückpreis ");
		int p = Eingabe.leseInt();
		System.out.println("Anzahl ");
		int s = Eingabe.leseInt();
		produkte.add(new Material(l, p, s));
	}
	
	private void dienstleistungBestellen() {
		System.out.println("Leisungsart ");
		String l = Eingabe.leseString();
		System.out.println("Personenzahl ");
		int p = Eingabe.leseInt();
		System.out.println("Stunden ");
		int s = Eingabe.leseInt();
		produkte.add(new Dienstleistung(l, p, s));
	}
	
	private void bestellungBeenden() {
		int sum = 0;
		for (Produkt produkt : produkte) {
			if (produkt != null) {
				System.out.print(produkt + " ");
				System.out.println(preisAufbereiten(produkt.gibPreis()));
				sum += produkt.gibPreis();
			}
		}
		System.out.println("Gesamtsumme: "+preisAufbereiten(sum));
	}

	private String preisAufbereiten(int preisInCent) {
		return (preisInCent / 100) + "." + (preisInCent % 100 < 10 ? "0" : "")
			+ preisInCent % 100 + " EUR";
	}
}
	