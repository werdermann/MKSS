package firstTask;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        Konto erstesKonto = new Konto(0);
        Konto zweitesKonto = new Konto(0);

        Ueberweiser ueberweiser = new Ueberweiser(sem, erstesKonto, zweitesKonto);
        Pruefer pruefer = new Pruefer(sem, erstesKonto, zweitesKonto);

        ueberweiser.start();
        pruefer.start();
    }

}
