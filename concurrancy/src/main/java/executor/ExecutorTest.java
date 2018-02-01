package executor;

import com.google.common.util.concurrent.FutureCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<?> future = executor.submit(()->{
            try {
                System.out.println("Name: " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Epic fail.");
            }
        });
        System.out.println("Waiting for task to finish..");
        future.get();
        System.out.println("Task finished!:");

        executor.shutdown();
    }
}
