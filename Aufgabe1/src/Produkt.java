
public class Produkt {
	private int id = produktNr++;
	private String name;
	private static int produktNr = 0;

	public static int getAnzahl() {
		return produktNr;
	}

	public Produkt(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int gibPreis () {
		return 0;
	}
	
	public void ausgeben() {
	}
}