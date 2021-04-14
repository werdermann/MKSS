import java.util.Scanner;

public class Bestellliste 
{
	private Produkt[] produkte = new Produkt[5];
	int index = 0;

	public void menuloop() 
	{
		int eingabe ;
		do 
		{
			menueAusgeben();
			eingabe = Eingabe.leseInt();
			switch ( eingabe ) 
			{
				case 0: break ;
				case 1: materialBestellen(index++); break ;
				case 2: dienstleistungBestellen(index++); break ;
				default: System.out.println("ungültig" ); break ;
			}
		} 
		while( eingabe != 0 && index < produkte.length);
		bestellungSortieren() ;
		bestellungBeenden() ;
	}
	
	private void menueAusgeben() 
	{
		System.out.println("Was wollen Sie machen?");
		System.out.println("(0) Bestellung beenden");
		System.out.println("(1) Material bestellen");
		System.out.println("(2) Dienstleistung bestellen");
	}
	
	private void bestellungSortieren() 
	{
		for(int i = 0; i<produkte.length-1; i++) 
		{
			for(int j = 0; j<produkte.length-1; j++) 
			{
				if( produkte[j+1] != null &&
					produkte[j+1].gibPreis ()<produkte[j].gibPreis()) 
				{
					Produkt temp = produkte[j + 1] ;
					produkte[j+1] = produkte[ j ] ;
					produkte[j] = temp ;
				}
			}
		}
	}
	
	private void materialBestellen(int index) 
	{
		System.out.println("Name ");
		String l = Eingabe.leseString();
		System.out.println("Stückpreis ");
		int p = Eingabe.leseInt();
		System.out.println("Anzahl ");
		int s = Eingabe.leseInt();
		produkte[index] = new Material(l, p, s) ;
	}
	
	private void dienstleistungBestellen(int index) 
	{
		System.out.println("Leisungsart ");
		String l = Eingabe.leseString();
		System.out.println("Personenzahl ");
		int p = Eingabe.leseInt();
		System.out.println("Stunden ");
		int s = Eingabe.leseInt();
		produkte[index] = new Dienstleistung(l, p, s) ;
	}
	
	private void bestellungBeenden() 
	{
		int sum = 0;
		for(int i = 0; i < produkte.length; i++) 
		{
			if(produkte[i] != null) 
			{
				System.out.print(produkte[i] + " ");
				System.out.println(preisAufbereiten(produkte[i].gibPreis()));
				sum += produkte[i].gibPreis();
			}
		}
		System.out.println("Gesamtsumme: "+preisAufbereiten(sum));
	}

	private String preisAufbereiten(int preisInCent)
	{
		return (preisInCent / 100) + "." + (preisInCent % 100 < 10 ? "0" : "")
			+ preisInCent % 100 + " EUR";
	}
}
	