package java.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: jdk-sourcecode
 * @description:
 * @author: Hatake
 * @create: 2020-06-28 10:47
 **/
public class ReentrantReadWriteLockTest {

    public static void get(ReentrantReadWriteLock lock) throws InterruptedException {
        lock.readLock().lock();
        System.out.println("get");
        Thread.sleep(3000L);
        lock.readLock().unlock();
    }

    public static void get2(ReentrantReadWriteLock lock){
        lock.readLock().lock();
        System.out.println("get2");
        lock.readLock().unlock();
    }
    public static void set(ReentrantReadWriteLock lock) throws InterruptedException {
        lock.writeLock().lock();
        System.out.println("write");
        Thread.sleep(5000L);
        lock.writeLock().unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        get(lock);
        set(lock);
    }
}
