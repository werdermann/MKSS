package aufgabeasync;

import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class BreakfastFuturesExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService server = new ExecutorService() {
            @Override
            public void shutdown() {

            }

            @Override
            public List<Runnable> shutdownNow() {
                return null;
            }

            @Override
            public boolean isShutdown() {
                return false;
            }

            @Override
            public boolean isTerminated() {
                return false;
            }

            @Override
            public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public <T> Future<T> submit(Callable<T> task) {
                return null;
            }

            @Override
            public <T> Future<T> submit(Runnable task, T result) {
                return null;
            }

            @Override
            public Future<?> submit(Runnable task) {
                return null;
            }

            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
                return null;
            }

            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override
            public void execute(Runnable command) {

            }
        };

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
