package com.vishal.queue.BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//http://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java

public class BlockingQueueWaitAndNotifyLocks {

    private Queue queue = new LinkedList();
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BlockingQueueWaitAndNotifyLocks(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(Object object) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.add(object);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            queue.poll();
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }

}
