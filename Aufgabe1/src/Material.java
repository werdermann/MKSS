

public class Material extends Produkt
{
	private int	stueckpreis;

	private int	anzahl;

	public Material(String name, int stueckpreis, int anzahl) {
		super(name);
		this.stueckpreis = stueckpreis;
		this.anzahl = anzahl;
	}

	@Override
	public int gibPreis() {
		return stueckpreis * anzahl;
	}

	@Override
	public String toString() {
		return anzahl + " * " + getName();
	}
}
