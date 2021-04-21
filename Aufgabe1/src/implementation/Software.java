package implementation;

import model.Produkt;

public class Software extends Produkt {
    private int	stueckpreis;
    private int	anzahl;

    public Software(String name, int stueckpreis, int anzahl) {
        super(name);
        this.stueckpreis = stueckpreis;
        this.anzahl = anzahl;
    }

    @Override
    public int gibPreis() {
        return 123 * stueckpreis * anzahl;
    }

    @Override
    public String ausgeben() {
        return anzahl + " * " + getName() + "-Lizensen";
    }

    @Override
    public String toString() {
        return anzahl + " * " + getName();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
