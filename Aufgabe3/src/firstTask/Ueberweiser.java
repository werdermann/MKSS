package firstTask;

public class Ueberweiser extends Thread {
    private Konto erstesKonto;
    private Konto zweitesKonto;

    public Ueberweiser(Konto erstesKonto, Konto zweitesKonto) {
        this.erstesKonto = erstesKonto;
        this.zweitesKonto = zweitesKonto;
    }

    @Override
    public void run() {
        super.run();

        System.out.println("Ein Thread: " + Thread.currentThread().getName());


        while (true) {

            int summe = 10;

            erstesKonto.abheben(summe);
            zweitesKonto.einzahlen(summe);
        }

    }

}
