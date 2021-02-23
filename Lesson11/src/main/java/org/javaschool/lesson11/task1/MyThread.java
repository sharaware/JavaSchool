package org.javaschool.lesson11.task1;

public class MyThread implements Runnable{
    private final MyResource first;
    private final MyResource second;

    public MyThread(MyResource first, MyResource second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            String f = first.getRes();
            System.out.println(f);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (second) {
                String s = second.getRes();
                System.out.println(s);
            }
        }
    }
}
