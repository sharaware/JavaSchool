package org.javaschool.lesson11.task3;

import java.util.Queue;

public class ConsumerThread implements Runnable{
    private final Queue<Integer> queue;

    public ConsumerThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            Integer val;
            int size;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
                break;
            }
            synchronized (queue){
                size = queue.size();
                if(size > 0) {
                    val = queue.remove();
                    System.out.println("Element " + val + " consumed, size = " + size);
                    if (size == 10) {
                        queue.notifyAll();
                    }
                } else {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Consumer interrupted");
                        break;
                    }
                }
            }
        }
    }
}
