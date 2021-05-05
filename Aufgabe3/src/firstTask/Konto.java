package firstTask;

import java.util.concurrent.atomic.AtomicInteger;

public class Konto {
    private AtomicInteger euro;

    public Konto(int euro) {
        this.euro = new AtomicInteger(euro);
    }

    public void einzahlen(int euro) {
        System.out.println("Einzahlung: " + euro);

            this.euro.set(this.euro.get() + euro);

    }

    public void abheben(int euro) {
        System.out.println("Abhebung: " + euro);
        // this.euro -= euro;

            this.euro.set(this.euro.get() - euro);

    }

    public int kontostandAbfragen() {
        System.out.println("Kontostand: " + this.euro);
        return this.euro.get();
    }


}
