package lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        System.out.println("read to write test");
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Runnable readLockRunnable = () -> {
                                                boolean hasLock = lock.readLock().tryLock();
                                                try {
                                                    Thread.sleep(5000);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                                if(hasLock)
                                                    lock.readLock().unlock();
                                            };

        Runnable writeLockRunnable = () -> {
                                                lock.writeLock().tryLock();
                                            };

        Runnable readUnlockRunnable = () -> lock.readLock().unlock();
        Runnable writeUnlockRunnable = () -> lock.writeLock().unlock();

        Thread t1 = new Thread(readLockRunnable); // get our own read lock
        Thread t2 = new Thread(readLockRunnable);
        Thread t3 = new Thread(readLockRunnable);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("readLock");

        t1 = new Thread(readUnlockRunnable); // unlock read lock
        t2 = new Thread(readUnlockRunnable);
        t3 = new Thread(readUnlockRunnable);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("readLock - unlocked");

        // upgrade to write lock
        t1 = new Thread(writeLockRunnable);
        t2 = new Thread(writeLockRunnable);
        t3 = new Thread(writeLockRunnable);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("writeLock !!");

        // upgrade to write lock
        t1 = new Thread(writeUnlockRunnable);
        t2 = new Thread(writeUnlockRunnable);
        t3 = new Thread(writeUnlockRunnable);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("writeLock - unlocked");
    }
}
