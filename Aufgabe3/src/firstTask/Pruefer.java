package firstTask;

public class Pruefer extends Thread {
    private Konto erstesKonto;
    private Konto zweitesKonto;

    private int summe = 0;

    public Pruefer(Konto erstesKonto, Konto zweitesKonto) {
        this.erstesKonto = erstesKonto;
        this.zweitesKonto = zweitesKonto;
    }

    @Override
    public void run() {
        super.run();

        summe += erstesKonto.kontostandAbfragen();
        summe += zweitesKonto.kontostandAbfragen();

    }
}
