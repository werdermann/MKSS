package firstTask;

public class Konto {
    private int euro;

    public Konto(int euro) {
        this.euro = euro;
    }

    public void einzahlen(int euro) {
        System.out.println("Einzahlung: " + euro);
        this.euro += euro;
    }

    public void abheben(int euro) {
        System.out.println("Abhebung: " + euro);
        this.euro -= euro;
    }

    public int kontostandAbfragen() {
        System.out.println("Kontostand: " + this.euro);
        return this.euro;
    }


}
