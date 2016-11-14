package com.vishal.queue.BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//http://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java

public class BlockingQueueWaitAndNotifyLocks {

    private final int MAX_SIZE = 10;
    private Queue queue = new LinkedList();
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void enqueue(Object object) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == MAX_SIZE) {
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
