package implementation;

import model.IProdukt;
import model.IProduktFactory;

public class SoftwareFactory implements IProduktFactory {

    @Override
    public IProdukt createIProdukt() {
        System.out.println("Name ");
        String l = Eingabe.leseString();
        System.out.println("St\u00FCckpreis ");
        int p = Eingabe.leseInt();
        System.out.println("Anzahl ");
        int s = Eingabe.leseInt();

        return new Software(l, p, s);
    }

    @Override
    public String getName() {
        return "Software";
    }
}
