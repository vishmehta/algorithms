package com.vishal.queue.BlockingQueue;


import java.util.LinkedList;
import java.util.Queue;

//http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
//http://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java
public class BlockingQueueWaitAndNotifySynchronised {

    private final int MAX_SIZE = 10;
    private Queue queue = new LinkedList();

    public synchronized void enqueue(Object item) throws InterruptedException {

        while (queue.size() == MAX_SIZE) {
            wait();
        }
        queue.add(item);
        notify(); //we could do the notify method when there are 1 item in the queue
        //notifyAll(); --> For multiple producers and consumers
    }

    //no need to pass param as we can take from the head of the queue
    public synchronized void dequeue() throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }
        queue.poll(); //poll removes head and doesnt throw exception if there is something - should not be an issue as we check the queue is not empty before
        notify(); //we could do the notify method when there are LIMIT - 1 items
        //notifyAll(); --> For multiple producers and consumers

    }

}
