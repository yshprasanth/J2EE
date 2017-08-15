package lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        System.out.println("read to write test");
        ReadWriteLock lock = new ReentrantReadWriteLock();

        lock.readLock().lock(); // get our own read lock
        System.out.println("readLock");
        lock.readLock().unlock();
        System.out.println("readLock - unlocked");
        lock.writeLock().lock(); // upgrade to write lock
        System.out.println("writeLock");
        lock.writeLock().unlock();
        System.out.println("writeLock - unlocked");
    }
}
