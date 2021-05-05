package firstTask;

import java.util.concurrent.Semaphore;

public class Pruefer extends Thread {
    private Konto erstesKonto;
    private Konto zweitesKonto;
    private Semaphore semaphore;

    private int gesamtSumme = 0;

    public Pruefer(Semaphore semaphore, Konto erstesKonto, Konto zweitesKonto) {
        this.erstesKonto = erstesKonto;
        this.zweitesKonto = zweitesKonto;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        gesamtSumme += erstesKonto.kontostandAbfragen();
        gesamtSumme += zweitesKonto.kontostandAbfragen();

        try {
            pruefen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void pruefen() throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
            semaphore.acquire();

            int aktuelleGesamtsumme = erstesKonto.kontostandAbfragen() + zweitesKonto.kontostandAbfragen();
            System.out.println("Aktuelle Gesamtsumme: " + aktuelleGesamtsumme);

            if(gesamtSumme != aktuelleGesamtsumme) {
                System.out.println("Aktuelle Gesamtsumme: " + aktuelleGesamtsumme);

                System.exit(0);
            }

            semaphore.release();
        }
    }
}
