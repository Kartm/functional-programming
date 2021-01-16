package Exercises.List_11.Task_4;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    public ReentrantLock lock = new ReentrantLock();

    public void grab() {
        lock.lock();
    }

    public void release() {
        lock.unlock();
    }

    public boolean isFree() {
        return lock.isLocked();
    }
}
