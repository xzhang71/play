package cci.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xzhang71 on 7/23/14.
 */
public class Chopstick {
    private Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }
}