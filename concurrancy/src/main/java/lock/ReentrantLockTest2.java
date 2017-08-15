package lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest2 {
    public static void main(String[] args) {
        ThreadSafeWrapper<String> wrapper = new ThreadSafeWrapper<String>("lala") {
            @Override
            protected void doMethodOne(String obj, String var) {
                System.out.println("method one: " + obj + " " + var);
            }

            @Override
            protected void doMethodTwo(String obj, String var) {
                System.out.println("method two: " + obj + " " + var);
            }
        };
        wrapper.methodOneWriteLock("foo");
        wrapper.methodTwoReadLock("bar");
    }
}

abstract class ThreadSafeWrapper<T> {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    T object;

    public ThreadSafeWrapper(T object) {
        this.object = object;
    }

    public final void methodOneWriteLock(String var) {
        lock.writeLock().lock();
        try {
            doMethodOne(object, var);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public final void methodTwoReadLock(String var) {
        lock.readLock().lock();
        try {
            doMethodTwo(object, var);
        } finally {
            lock.readLock().unlock();
        }
    }

    abstract void doMethodOne(T obj, String var);

    abstract void doMethodTwo(T obj, String var);
}