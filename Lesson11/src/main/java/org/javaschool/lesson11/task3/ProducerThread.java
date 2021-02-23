package org.javaschool.lesson11.task3;

import java.util.Queue;
import java.util.Random;

public class ProducerThread implements Runnable {
    private final Queue<Integer> queue;

    public ProducerThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while(true) {
            int val = rand.nextInt(1000);
            try {
                Thread.sleep(val);
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
                break;
            }

            int size;
            synchronized (queue) {
                size = queue.size();
                if(size >= 10){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Producer interrupted");
                        break;
                    }
                } else {
                    queue.add(val);
                    if(size == 0) {
                        queue.notify();
                    }
                }
            }
        }
    }
}
