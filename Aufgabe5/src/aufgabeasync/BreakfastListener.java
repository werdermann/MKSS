package aufgabeasync;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class BreakfastListener {

    public static void main(java.lang.String[] args) {
        long start = System.currentTimeMillis();
        getBread(bread -> {
           System.out.println(bread);
           cookEggs(System.out::println);
           toastToast(System.out::println);
           pressOrangeJuice(juice -> {
               System.out.println(juice);
               setTheTable(table -> {
                   System.out.println(table);
                   long end = System.currentTimeMillis();
                   System.out.println("Preparation needed: "+(end-start)/1000.d+" s");
               });
           });
        });
    }

    public static void getBread(Consumer<String> listener) {
        schedule("Lecker Brötchen sind da", 10000, listener);
    }

    public static void cookEggs(Consumer<String> listener) {
        schedule("Eier fertig", 3000, listener);
    }

    public static void toastToast(Consumer<String> listener) {
        schedule("Toast fertig", 3000, listener);
    }

    public static void pressOrangeJuice(Consumer<String> listener) {
        schedule("Orangensaft ist frisch gepresst", 3000, listener);
    }

    public static void setTheTable(Consumer<String> listener) {
        schedule("Tisch ist gedeckt", 2000, listener);
    }

    public static void schedule(String msg, int delay, Consumer<String> listener) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                listener.accept(msg);
            }
        }, delay);
    }

}
