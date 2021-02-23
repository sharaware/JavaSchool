package org.javaschool.lesson11.task2;

public class Task2Thread implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while(true) {
            synchronized (this){
                try {
                    this.wait(1000);
                    System.out.println("i = " + i++);
                } catch (InterruptedException e) {
                    System.out.println("Execution of thread '" + Thread.currentThread().getName() + "' interrupted");
                    break;
                }
            }
        }
    }
}
