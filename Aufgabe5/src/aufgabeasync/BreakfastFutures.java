package aufgabeasync;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class BreakfastFutures {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] counter = new int[1];

        Consumer<String> consumer = val -> {
            System.out.println(val);
            counter[0]++;
            if (counter[0] == 3) {
                setTheTable().thenAccept(table -> {
                    System.out.println(table);
                    long end = System.currentTimeMillis();
                    System.out.println("Preparation needed: "+(end-start)/1000.d+" s");
                });
            }
        };

        getBread().thenAccept(bread -> {
            System.out.println(bread);
            cookEggs().thenAccept(consumer);
            toastToast().thenAccept(consumer);
            pressOrangeJuice().thenAccept(consumer);
        });
    }

    public static CompletableFuture<String> getBread() {
        return schedule("Lecker Brötchen sind da", 10000);
    }

    public static CompletableFuture<String> cookEggs() {
        return schedule("Eier fertig", 3000);
    }

    public static CompletableFuture<String> toastToast() {
        return schedule("Toast fertig", 3000);
    }

    public static CompletableFuture<String> pressOrangeJuice() {
        return schedule("Orangensaft ist frisch gepresst", 3000);
    }

    public static CompletableFuture<String> setTheTable() {
        return schedule("Tisch ist gedeckt", 2000);
    }

    public static CompletableFuture<String> schedule(String msg, int delay) {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                future.complete(msg);
            }
        }, delay);
        return future;
    }

}
