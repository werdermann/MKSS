package firstTask;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Konto erstesKonto = new Konto(100);
        Konto zweitesKonto = new Konto(0);

        Ueberweiser ueberweiser = new Ueberweiser(erstesKonto, zweitesKonto);
        Pruefer pruefer = new Pruefer(erstesKonto, zweitesKonto);

        ueberweiser.start();


    }

}
