package aufgabeasync;

import java.util.concurrent.*;
import java.util.function.Consumer;

public class BreakfastFuturesExecutor {

    public static String activeProcess = "";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] counter = new int[1];

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> System.out.println("Service is running... " + activeProcess);
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);


        Consumer<String> consumer = val -> {
            System.out.println(val);
            counter[0]++;
            if (counter[0] == 3) {
                setTheTable(service).thenAccept(table -> {
                    System.out.println(table);
                    long end = System.currentTimeMillis();
                    System.out.println("Preparation needed: "+(end-start)/1000.d+" s");
                });
            }
        };

        getBread(service).thenAccept(bread -> {
            System.out.println(bread);
            cookEggs(service).thenAccept(consumer);
            toastToast(service).thenAccept(consumer);
            pressOrangeJuice(service).thenAccept(consumer);
        });

    }

    public static CompletableFuture<String> getBread(ScheduledExecutorService service) {
        activeProcess += "Brot holen... ";
        CompletableFuture<String> future = new CompletableFuture<>();
        Runnable runnable = () -> {
            future.complete("Lecker Brötchen sind da");
            activeProcess = activeProcess.replace("Brot holen... ", "");
        };
        service.schedule(runnable, 10, TimeUnit.SECONDS);
        return future;
    }

    public static CompletableFuture<String> cookEggs(ScheduledExecutorService service) {
        activeProcess += "Eier kochen... ";
        CompletableFuture<String> future = new CompletableFuture<>();
        Runnable runnable = () -> {
            future.complete("Eier fertig");
            activeProcess = activeProcess.replace("Eier kochen... ", "");
        };
        service.schedule(runnable, 3, TimeUnit.SECONDS);
        return future;
    }

    public static CompletableFuture<String> toastToast(ScheduledExecutorService service) {
        activeProcess += "Toast toasten... ";
        CompletableFuture<String> future = new CompletableFuture<>();
        Runnable runnable = () -> {
            future.complete("Toast fertig");
            activeProcess = activeProcess.replace("Toast toasten... ", "");
        };
        service.schedule(runnable, 3, TimeUnit.SECONDS);
        return future;
    }

    public static CompletableFuture<String> pressOrangeJuice(ScheduledExecutorService service) {
        activeProcess += "Orangensaft pressen... ";
        CompletableFuture<String> future = new CompletableFuture<>();
        Runnable runnable = () -> {
            future.complete("Orangensaft ist frisch gepresst");
            activeProcess = activeProcess.replace("Orangensaft pressen... ", "");
        };
        service.schedule(runnable, 3, TimeUnit.SECONDS);
        return future;
    }

    public static CompletableFuture<String> setTheTable(ScheduledExecutorService service) {
        activeProcess += "Tisch decken... ";
        CompletableFuture<String> future = new CompletableFuture<>();
        Runnable runnable = () -> {
            future.complete("Tisch ist gedeckt");
            activeProcess = activeProcess.replace("Tisch decken... ", "");
        };
        service.schedule(runnable, 2, TimeUnit.SECONDS);
        return future;
    }

}
