
public class Dienstleistung extends Produkt 
{
	private int stunden, personen;

	public Dienstleistung (String n, int p, int s){
		super(n); 
		stunden=s; 
		personen=p;
	}

	public int gibPreis()
	{
		return 1242*stunden*personen;
	}
	
//	public void ausgeben()
//	{
//		System.out.println(personen+" Nasen für "+stunden+"h "+getName());
//	} 
	
	public String toString()
	{
		return personen+" Nasen für "+stunden+"h "+getName();
	}
}
