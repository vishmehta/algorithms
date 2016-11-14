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
