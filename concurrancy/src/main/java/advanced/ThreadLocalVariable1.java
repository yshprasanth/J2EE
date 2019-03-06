package advanced;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalVariable1 {
    public static void main(String[] args) throws InterruptedException {
        Incrementer counter = new Incrementer();

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(counter);
        Thread.sleep(5000);
        service.execute(counter);
//        service.execute(counter);
//        service.execute(counter);
//        service.execute(counter);
//        service.execute(counter);
//        service.execute(counter);
//        service.execute(counter);

//        if(!service.isShutdown())
//            service.shutdown();
    }
}

class Incrementer implements Runnable {

    private Logger logger = LoggerFactory.getLogger(Incrementer.class);
    private int counter;
    private ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    @Override
    public void run() {
        counter++;
        atomicCounter.incrementAndGet();

        if(threadLocalCounter.get()!=null)
            threadLocalCounter.set(threadLocalCounter.get()+1);
        else
            threadLocalCounter.set(0);

        logger.info("counter: " + counter + ", " +  atomicCounter.get() + ", " + threadLocalCounter.get());

        while(true){
            threadLocalCounter.set(threadLocalCounter.get()+1);
            logger.info("threadLocalCounter: " + threadLocalCounter.get());
            if(threadLocalCounter.get()==5) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}