package com.vishal.queue.BlockingQueue;

//http://tutorials.jenkov.com/java-concurrency/blocking-queues.html

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueWaitAndNotifyAll {

    private final int LIMIT = 10;
    private List queue = new LinkedList();

    public synchronized void enqueue(Object item) throws InterruptedException {

        while (queue.size() == LIMIT) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(item);
    }

    public synchronized void dequeue(Object item) throws InterruptedException {

        while (queue.size() == 0) {
            wait();
        }
        if (queue.size() == LIMIT) {
            notifyAll();
        }
        queue.remove(item);
    }

}
