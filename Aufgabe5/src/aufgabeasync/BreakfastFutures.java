package aufgabeasync;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class BreakfastFutures {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        getBread().thenAccept(bread -> {
            setTheTable().thenAccept(table -> {
                System.out.println(table);
                long end = System.currentTimeMillis();
                System.out.println("Preparation needed: "+(end-start)/1000.d+" s");
            });
            System.out.println(bread);
        });

        System.out.println(cookEggs().get());
        System.out.println(toastToast().get());
        System.out.println(pressOrangeJuice().get());
    }

    public static CompletableFuture<String> getBread() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                completableFuture.complete("Lecker Brötchen sind da");
            }
        };
        new Timer().schedule(task, 10000);
        return completableFuture;
    }

    public static CompletableFuture<String> cookEggs() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                completableFuture.complete("Eier fertig");
            }
        };
        new Timer().schedule(task, 3000);
        return completableFuture;
    }

    public static CompletableFuture<String> toastToast() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                completableFuture.complete("Toast fertig");
            }
        };
        new Timer().schedule(task, 3000);
        return completableFuture;
    }

    public static CompletableFuture<String> pressOrangeJuice() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                completableFuture.complete("Orangensaft ist frisch gepresst");
            }
        };
        new Timer().schedule(task, 3000);
        return completableFuture;
    }

    public static CompletableFuture<String> setTheTable() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                completableFuture.complete("Tisch ist gedeckt");
            }
        };
        new Timer().schedule(task, 10000);
        return completableFuture;
    }

}
