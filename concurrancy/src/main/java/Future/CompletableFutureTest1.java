package Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest1 {

    public static void main(String[] args) {
        ExecutorService executor0 = Executors.newWorkStealingPool();
        ExecutorService executor1 = Executors.newWorkStealingPool();
        System.nanoTime();
//Completed when both of the futures are completed
        CompletableFuture<String> waitingForAll = CompletableFuture
                .allOf(
                        CompletableFuture.supplyAsync(() -> "first"),
                        CompletableFuture.supplyAsync(() -> "second", executor1)
                )
                .thenApply(ignored -> " is completed.");
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Concurrency Refcard", executor0)
                //Using same executor
                .thenApply(result -> "Java " + result)
                //Using different executor
                .thenApplyAsync(result -> "Dzone " + result, executor1)
                //Completed when this and other future are completed
                .thenCombine(waitingForAll, (first, second) -> first + second)
                //Implicitly using ForkJoinPool#commonPool as the executor
                .thenAcceptAsync(result -> {
                    System.out.println("Result is '" + result + "'.");
                })
                //Generic handler
                .whenComplete((ignored, exception) -> {
                    if (exception != null)
                        exception.printStackTrace();
                });
//First blocking call - blocks until it is not finished.
        future.join();
        future
                //Executes in the current thread (which is main).
                .thenRun(() -> System.out.println("Current thread is '" + Thread.currentThread().getName() + "'."))
                //Implicitly using ForkJoinPool#commonPool as the executor
                .thenRunAsync(() -> System.out.println("Current thread is '" + Thread.currentThread().getName() + "'"));
    }
}
