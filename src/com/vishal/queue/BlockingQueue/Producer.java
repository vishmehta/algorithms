package com.vishal.queue.BlockingQueue;

import java.util.concurrent.BlockingQueue;

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