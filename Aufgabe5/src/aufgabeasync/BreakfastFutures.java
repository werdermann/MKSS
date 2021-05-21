package aufgabeasync;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class BreakfastFutures {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        System.out.println(getBread().get());
        System.out.println(cookEggs().get());
        System.out.println(toastToast().get());
        System.out.println(pressOrangeJuice().get());
        System.out.println(setTheTable().get());
        long end = System.currentTimeMillis();
        System.out.println("Preparation needed: "+(end-start)/1000.d+" s");

    }

    public static CompletableFuture<String> getBread() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                completableFuture.complete("Lecker Brötchen sind da");
            }
        };
        new Timer().schedule(task, 3000);
        return completableFuture;
    }

    public static CompletableFuture<String> cookEggs() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            completableFuture.complete("Eier fertig");
        });

        return completableFuture;
    }

    public static CompletableFuture<String> toastToast() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            completableFuture.complete("Toast fertig");
        });

        return completableFuture;
    }

    public static CompletableFuture<String> pressOrangeJuice() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            completableFuture.complete("Orangensaft ist frisch gepresst");
        });

        return completableFuture;
    }

    public static CompletableFuture<String> setTheTable() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Tisch ist gedeckt");
        return completableFuture;
    }

}
