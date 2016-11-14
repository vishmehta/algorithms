package com.vishal.queue.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//http://howtodoinjava.com/algorithm/producer-consumer-problem-using-blockingqueue/

public class BlockingQueueConcurrencyPackage {

    private static final int QUEUE_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {

        int numProducers = 4;
        int numConsumers = 3;

        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<Object>(QUEUE_SIZE);

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(myQueue)).start();
        }

        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(myQueue)).start();
        }

        // Let the simulation run for, say, 10 seconds
        Thread.sleep(10 * 1000);

        // End of simulation - shut down gracefully
        System.exit(0);

    }

}

class Producer implements Runnable {
    private BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Produced resource - Queue size now = " + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer INTERRUPTED");
        }
    }

    private Object getResource() {
        try {
            Thread.sleep(100); // simulate time passing during read
        } catch (InterruptedException ex) {
            System.out.println("Producer Read INTERRUPTED");
        }
        return new Object();
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    public void run() {
        try {
            while (true) {
                Object obj = queue.take();
                System.out.println("Consumed resource - Queue size now = " + queue.size());
                take(obj);
            }
        } catch (InterruptedException ex) {
            System.out.println("CONSUMER INTERRUPTED");
        }
    }

    private void take(Object obj) {
        try {
            Thread.sleep(100); // simulate time passing
        } catch (InterruptedException ex) {
            System.out.println("Consumer Read INTERRUPTED");
        }
        System.out.println("Consuming object " + obj);
    }

}
