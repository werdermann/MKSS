public class DienstleistungFactory implements IProduktFactory {

    @Override
    public IProdukt createIProdukt() {
        System.out.println("Leisungsart ");
        String l = Eingabe.leseString();
        System.out.println("Personenzahl ");
        int p = Eingabe.leseInt();
        System.out.println("Stunden ");
        int s = Eingabe.leseInt();

        return new Dienstleistung(l, p, s);
    }

    @Override
    public String getName() {
        return "Dienstleistung";
    }
}
