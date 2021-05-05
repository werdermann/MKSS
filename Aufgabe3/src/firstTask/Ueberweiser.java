package firstTask;

import java.util.concurrent.Semaphore;

public class Ueberweiser extends Thread {
    private Konto erstesKonto;
    private Konto zweitesKonto;
    private Semaphore semaphore;

    public Ueberweiser(Semaphore semaphore, Konto erstesKonto, Konto zweitesKonto) {
        this.erstesKonto = erstesKonto;
        this.zweitesKonto = zweitesKonto;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            ueberweisen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void ueberweisen() throws InterruptedException {
        for(int i = 0; i < 10000; i++) {
            semaphore.acquire();

            int summe = 10;

            erstesKonto.abheben(summe);
            zweitesKonto.einzahlen(summe);

            semaphore.release();
        }
    }

}
