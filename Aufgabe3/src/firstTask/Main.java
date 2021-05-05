package firstTask;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1);

        Konto erstesKonto = new Konto(0);
        Konto zweitesKonto = new Konto(0);

        Ueberweiser ueberweiser = new Ueberweiser(sem, erstesKonto, zweitesKonto);
        Pruefer pruefer = new Pruefer(sem, erstesKonto, zweitesKonto);

        ueberweiser.start();
        pruefer.start();

        ueberweiser.join();
        pruefer.join();

        System.out.println("Done");
        System.out.println("1. Kontostand: " + erstesKonto.kontostandAbfragen());
        System.out.println("2. Kontostand: " + zweitesKonto.kontostandAbfragen());


    }

}
