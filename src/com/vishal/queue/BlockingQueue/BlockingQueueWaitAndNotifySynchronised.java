package com.vishal.queue.BlockingQueue;


import java.util.LinkedList;
import java.util.List;

//http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
//http://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java
public class BlockingQueueWaitAndNotifyAll {

    private final int LIMIT = 10;
    private List queue = new LinkedList();

    public synchronized void enqueue(Object item) throws InterruptedException {

        while (queue.size() == LIMIT) {
            wait();
        }
        queue.add(item);
        notify();
        //notifyAll(); //For multiple producers and consumers
    }

    public synchronized void dequeue(Object item) throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }
        notify();
        //notifyAll(); //For multiple producers and consumers
        queue.remove(item);
    }

}
