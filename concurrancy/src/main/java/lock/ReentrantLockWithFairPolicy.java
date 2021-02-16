package lock;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ReentrantLockWithFairPolicy {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeWrapper wrapper = new ThreadSafeWrapper(new StringBuffer("Hello!!"));

        ExecutorService writerExecutors = Executors.newFixedThreadPool(3);
        ExecutorService readerExecutors = Executors.newFixedThreadPool(10);


        Runnable writerTask = () -> {
            int counter=0;
            while(counter<10) {
                wrapper.writeWithLock(RandomStringUtils.randomAlphabetic(5));
                counter++;
            }};

        Runnable readerTask = () -> {
            int counter=0;
            while(counter<10) {
                wrapper.readWithLock();
                counter++;
            }};

        readerExecutors.submit(readerTask);
        writerExecutors.submit(writerTask);
        readerExecutors.shutdown();
        writerExecutors.shutdown();
    }
}

class ThreadSafeWrapper {
    ReadWriteLock lock = new ReentrantReadWriteLock(true);
    StringBuffer buffer;

    public ThreadSafeWrapper(StringBuffer initialText) {
        this.buffer = initialText;
    }

    public final String writeWithLock(String text) {
        try {
            System.out.println("**** trying for write lock: " + Thread.currentThread());
            lock.writeLock().tryLock(5000, SECONDS);
            System.out.println("Acquired write lock: " + Thread.currentThread());
            return doWrite(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        } finally {
            lock.writeLock().unlock();
        }
    }

    public final String readWithLock() {
        try {
            System.out.println("***** trying for read lock: " + Thread.currentThread());
            lock.readLock().tryLock(5000, SECONDS);
            System.out.println("Acquired read lock: " + Thread.currentThread());
            return doRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        } finally {
            lock.readLock().unlock();
        }
    }

    private String doWrite(String text) {
        try {
            long waitTime = Math.round(Math.random()*100);
            System.out.println("doWrite - " + Thread.currentThread() + ", waiting: " + waitTime);
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("writing - " + Thread.currentThread() + ", text: " + text + ", to buffer: " + buffer);
        buffer.append(text);
        return buffer.toString();
    };

    private String doRead() {
        try {
            long waitTime = Math.round(Math.random()*100);
            System.out.println("doRead - " + Thread.currentThread() + ", waiting: " + waitTime);
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("reading - " + Thread.currentThread() + ", buffer: " + buffer);
        return buffer.toString();
    }
}